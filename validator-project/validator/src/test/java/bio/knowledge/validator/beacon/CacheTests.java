package bio.knowledge.validator.beacon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import bio.knowledge.client.ApiClient;
import bio.knowledge.client.ApiException;
import bio.knowledge.client.api.ConceptsApi;
import bio.knowledge.client.model.BeaconConcept;
import bio.knowledge.client.model.ExactMatchResponse;
import bio.knowledge.validator.BeaconTestBase;

/**
 * This test seems pointless, but I copied it over anyway.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTests extends BeaconTestBase {
	
	@Test
	public void testExactMatchesCaching() throws ApiException {
		ApiClient client = rule.getBeaconApiClient(BASE_PATH);
		ConceptsApi conceptsApi = new ConceptsApi(client);
		
		List<BeaconConcept> concepts = conceptsApi.getConcepts(Arrays.asList("diabetes"), null, 100);
		
		for (BeaconConcept concept : concepts) {
			Set<String> clique = new HashSet<String>(Arrays.asList(concept.getId()));
			
			int size = 0;
			while (clique.size() != size) {
				size = clique.size();
				
				List<ExactMatchResponse> matches = conceptsApi.getExactMatchesToConceptList(Arrays.asList(concept.getId()));
				
				for (ExactMatchResponse m : matches) {
					if (m.getId().equals(concept.getId())) {
						clique.addAll(m.getHasExactMatches());
					}
				}
				
				Assert.assertTrue(matches.size() == 1);
				Assert.assertTrue(matches.get(0).getId().equals(concept.getId()));
				Assert.assertTrue(clique.size() > 0);
			}
			
			System.out.println(clique.size());
			
			//TODO: test that the time it takes to return for each iteration is O(n) of the n 
			//		many new matches found.
		}
	}

}
