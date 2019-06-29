package bio.knowledge.validator;

import bio.knowledge.client.ApiException;
import bio.knowledge.client.api.ConceptsApi;
import bio.knowledge.client.api.MetadataApi;
import bio.knowledge.client.api.StatementsApi;
import bio.knowledge.client.model.BeaconConcept;
import bio.knowledge.client.model.BeaconStatement;
import bio.knowledge.validator.rules.RuleContainer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.util.List;

import static bio.knowledge.validator.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveEndpointsTests extends BasePathAccessor {

	@Autowired
	RuleContainer ruleContainer;

	@Rule
	public TestWatcher testWatcher;
	@Rule
	public Stopwatch stopwatch;

	@PostConstruct
	public void init() {
		testWatcher = ruleContainer.getTestWatcher();
		stopwatch = ruleContainer.getStopwatch();
	}

	@Test
	public void testConceptsCall() throws ApiException {
		ApiClient apiClient = new ApiClient(getBasePath());
		ConceptsApi conceptsApi = new ConceptsApi(apiClient);
		conceptsApi.getConcepts(Utils.asList("e"), null, 1);
	}

	@Test
	public void testConceptDetailsCall() throws ApiException {
		ApiClient apiClient = new ApiClient(getBasePath());
		ConceptsApi conceptsApi = new ConceptsApi(apiClient);
		List<BeaconConcept> concepts = conceptsApi.getConcepts(Utils.asList("e"), null, 1);

		if (concepts.isEmpty()) {
			fail(apiClient, "Could not run test since concepts endpoint returned empty");
		}

		String conceptId = concepts.get(0).getId();

		conceptsApi.getConceptDetails(conceptId);
	}

	@Test
	public void testExactMatchesToConceptIdCall() throws ApiException {
		ApiClient apiClient = new ApiClient(getBasePath());
		ConceptsApi conceptsApi = new ConceptsApi(apiClient);

		List<BeaconConcept> concepts = conceptsApi.getConcepts(Utils.asList("e"), null, 1);

		if (concepts.isEmpty()) {
			fail(apiClient, "Could not run test since concepts endpoint returned empty");
		}

		String conceptId = concepts.get(0).getId();
		
		conceptsApi.getExactMatchesToConceptList(Utils.asList(conceptId));
	}

	@Test
	public void testExactMatchesToConceptListCall() throws ApiException {
		ApiClient apiClient = new ApiClient(getBasePath());
		ConceptsApi conceptsApi = new ConceptsApi(apiClient);
		List<BeaconConcept> concepts = conceptsApi.getConcepts(Utils.asList("e"), null, 1);

		if (concepts.isEmpty()) {
			fail(apiClient, "Could not run test since concepts endpoint returned empty");
		}

		String conceptId = concepts.get(0).getId();

		conceptsApi.getExactMatchesToConceptList(Utils.asList(conceptId));
	}

	@Test
	public void testStatementsCall() throws ApiException {
		ApiClient apiClient = new ApiClient(getBasePath());
		ConceptsApi conceptsApi = new ConceptsApi(apiClient);
		StatementsApi statementsApi = new StatementsApi(apiClient);
		List<BeaconConcept> concepts = conceptsApi.getConcepts(Utils.asList("e"), null, 1);

		if (concepts.isEmpty()) {
			fail(apiClient, "Could not run test since concepts endpoint returned empty");
		}

		String conceptId = concepts.get(0).getId();

		statementsApi.getStatements(Utils.asList(conceptId), null, null, null, null, null, 1);
	}

	@Test
	public void testStatementDetails() throws ApiException {
		ApiClient apiClient = new ApiClient(getBasePath());
		ConceptsApi conceptsApi = new ConceptsApi(apiClient);
		StatementsApi statementsApi = new StatementsApi(apiClient);
		List<BeaconConcept> concepts = conceptsApi.getConcepts(Utils.asList("e"), null, 50);

		if (concepts.isEmpty()) {
			fail(apiClient, "Could not run test since concepts endpoint returned empty");
		}

		for (BeaconConcept concept : concepts) {
			String conceptId = concept.getId();
			List<BeaconStatement> statements = statementsApi.getStatements(Utils.asList(conceptId), null, null, null, null,
					null, 1);

			if (!statements.isEmpty()) {
				String statementId = statements.get(0).getId();

				statementsApi.getStatementDetails(statementId, null, 1);
				return;
			}
		}

		fail(apiClient, "Could not find any evidence to test this endpoint");

	}

	@Test
	public void testKmapCall() throws ApiException {
		ApiClient apiClient = new ApiClient(getBasePath());
		MetadataApi metadataApi = new MetadataApi(apiClient);
		metadataApi.getKnowledgeMap();
	}

	@Test
	public void testTypesCall() throws ApiException {
		ApiClient apiClient = new ApiClient(getBasePath());
		MetadataApi metadataApi = new MetadataApi(apiClient);
		metadataApi.getConceptCategories();
	}

	@Test
	public void testPredicatesCall() throws ApiException {
		ApiClient apiClient = new ApiClient(getBasePath());
		MetadataApi metadataApi = new MetadataApi(apiClient);
		metadataApi.getPredicates();
	}

}
