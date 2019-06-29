package bio.knowledge.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import bio.knowledge.client.ApiException;
import bio.knowledge.client.api.ConceptsApi;
import bio.knowledge.client.model.BeaconConcept;
import bio.knowledge.client.model.ExactMatchResponse;
import bio.knowledge.validator.rules.RuleContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTests  extends BasePathAccessor {

	@Autowired RuleContainer ruleContainer;
	
	@Rule public TestWatcher testWatcher;
	@Rule public Stopwatch stopwatch;
	
	@PostConstruct
	public void init() {
		testWatcher = ruleContainer.getTestWatcher();
		stopwatch = ruleContainer.getStopwatch();
	}
	
	@Test
	public void testExactMatchesCaching() throws ApiException {
		ApiClient client = new ApiClient(getBasePath());
		ConceptsApi conceptsApi = new ConceptsApi(client);
		
		List<BeaconConcept> concepts = conceptsApi.getConcepts(Utils.asList("diabetes"), null, 100);
		
		for (BeaconConcept concept : concepts) {
			Set<String> clique = new HashSet<String>(Utils.asList(concept.getId()));
			
			int size = 0;
			while (clique.size() != size) {
				size = clique.size();
				
				List<ExactMatchResponse> matches = conceptsApi.getExactMatchesToConceptList(Utils.asList(concept.getId()));
				
				for (ExactMatchResponse m : matches) {
					if (m.getId().equals(concept.getId())) {
						clique.addAll(m.getHasExactMatches());
					}
				}
				
				Assert.assertTrue(client, matches.size() == 1);
				Assert.assertTrue(client, matches.get(0).getId().equals(concept.getId()));
				Assert.assertTrue(client, clique.size() > 0);
			}
			
			System.out.println(clique.size());
			
			//TODO: test that the time it takes to return for each iteration is O(n) of the n 
			//		many new matches found.
		}
	}

}
