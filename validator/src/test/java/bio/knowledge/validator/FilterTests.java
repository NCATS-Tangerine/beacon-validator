package bio.knowledge.validator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import bio.knowledge.client.ApiException;
import bio.knowledge.client.api.ConceptsApi;
import bio.knowledge.client.api.StatementsApi;
import bio.knowledge.client.extra.Concept;
import bio.knowledge.client.model.BeaconConcept;
import bio.knowledge.client.model.BeaconStatement;
import bio.knowledge.validator.containers.FilterSetContainer;
import bio.knowledge.validator.containers.FilterSetContainer.FilterSet;
import bio.knowledge.validator.containers.MetadataContainer;
import bio.knowledge.validator.logging.Logger;
import bio.knowledge.validator.logging.LoggerFactory;
import bio.knowledge.validator.rules.RuleContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilterTests {
	@Value(value="${basePath}")
	public String BASE_PATH;
	
	@Autowired FilterSetContainer filterSetContainer;
	@Autowired MetadataContainer metadataContainer;
	@Autowired RuleContainer ruleContainer;
	
	@Rule public TestWatcher testWatcher;
	@Rule public Stopwatch stopwatch;
	
	@PostConstruct
	public void init() {
		testWatcher = ruleContainer.getTestWatcher();
		stopwatch = ruleContainer.getStopwatch();
	}
	
	private static final Integer FILTER_SIZE = 3;
	
	@Test
	public void testConceptFilters() throws ApiException {
		ApiClient apiClient = new ApiClient(BASE_PATH);
		ConceptsApi conceptsApi = new ConceptsApi(apiClient);
		
		FilterSet filterSet = filterSetContainer.getFilterSet();
		
		List<List<String>> typesList = filterSet.getTypesList();
		List<List<String>> keywordsList = filterSet.getKeywordsList();
		
		for (List<String> keywords : keywordsList) {
			for (List<String> types : typesList) {
				List<BeaconConcept> concepts = conceptsApi.getConcepts(keywords, types, 1, 100);
				
				for (BeaconConcept concept : concepts) {
					assertTrue("Types filter failed for " + concept.getId(), types.contains(concept.getType()));
					
					assertTrue(
							"Keywords filter failed for " + concept.getId(),
							keywords.stream().anyMatch(keyword -> contains(keyword, concept.getName())) ||
							keywords.stream().anyMatch(keyword -> contains(keyword, concept.getDefinition())) ||
							keywords.stream().anyMatch(keyword -> concept.getSynonyms().stream().anyMatch(synonym -> contains(keyword, synonym)))
					);
				}
			}
		}
	}
	
	
	@Test
	public void testStatementsFilters() throws ApiException {
		FilterSet filterSet = filterSetContainer.getFilterSet();
		
		List<String> predicates = metadataContainer.getPredicates().stream().map(
				predicate -> predicate.getId()
		).collect(Collectors.toList());
		
		List<List<String>> typesList = filterSet.getTypesList();
		List<List<String>> keywordsList = filterSet.getKeywordsList();
		
		ApiClient apiClient = new ApiClient(BASE_PATH);
		StatementsApi statementsApi = new StatementsApi(apiClient);
		ConceptsApi conceptsApi = new ConceptsApi(apiClient);
		
		for (List<String> keywords : keywordsList) {
			for (List<String> types : typesList) {
				List<BeaconConcept> concepts = conceptsApi.getConcepts(keywords, null, 1, FILTER_SIZE);
				
				List<String> s = concepts.stream().map(concept -> concept.getId()).collect(Collectors.toList());
				
				for (String predicate : predicates) {
					List<BeaconStatement> statements = statementsApi.getStatements(s, predicate, null, keywords, types, 1, 100);
					
					List<String> targets = new ArrayList<String>();
					
					for (BeaconStatement statement : statements) {
						assertEquals("Predicate filter failed for statement " + statement.getId(), statement.getPredicate().getName(), predicate);
						
						Concept subject = statement.getSubject();
						Concept object = statement.getObject();
						
						if (s.contains(subject.getId())) {
							targets.add(object.getId());
						} else if (s.contains(object.getId())) {
							targets.add(subject.getId());
						} else {
							fail("Source filter failed for statement " + statement.getId());
						}
					}
					
					targets  = targets.subList(0, Math.min(FILTER_SIZE, targets.size()));
					
					List<BeaconStatement> targetedStatements = statementsApi.getStatements(s, null, targets, null, null, 1, 100);
					
					for (BeaconStatement statement : targetedStatements) {
						String subjectId = statement.getSubject().getId();
						String objectId = statement.getObject().getId();
						
						if (s.contains(subjectId)) {
							assertTrue("Target filter failed for statement " + statement.getId(), targets.contains(objectId));
						} else if (s.contains(objectId)) {
							assertTrue("Target filter failed for statement " + statement.getId(), targets.contains(subjectId));
						} else {
							fail("Source filter failed for statement " + statement.getId());
						}
					}
				}
			}
		}
	}
	
	/**
	 * Returns true if any term in substring is contained in superstring, false otherwise.
	 */
	private boolean contains(String superstring, String substring) {		
		if (substring.contains(" ")) {
			String[] substrings = substring.split(" ");
			
			for (String s : substrings) {
				if (contains(superstring, s)) return true;
			}
			
			return false;
		}
		
		superstring = superstring.toLowerCase();
		substring = substring.toLowerCase();
		
		return superstring.contains(substring);
	}
}
