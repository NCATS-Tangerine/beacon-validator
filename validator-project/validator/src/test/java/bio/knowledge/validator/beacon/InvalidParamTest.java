package bio.knowledge.validator.beacon;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import bio.knowledge.client.ApiClient;
import bio.knowledge.client.ApiException;
import bio.knowledge.client.api.ConceptsApi;
import bio.knowledge.client.api.StatementsApi;
import bio.knowledge.validator.BeaconTestBase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvalidParamTest extends BeaconTestBase {

	@Test
	public void testNullCOnceptsQuery() throws ApiException {
		ApiClient apiClient = rule.getBeaconApiClient(BASE_PATH);
		
		ConceptsApi conceptsApi = new ConceptsApi(apiClient);
		
		try {
			conceptsApi.getConcepts(null, null, null);
			Assert.fail("Invalid parameters should have resulted in an ApiException");
		} catch (ApiException e) {
			// Expected error
		}
	}
	
	@Test
	public void testNullStatementsQuery() throws ApiException {
		ApiClient apiClient = rule.getBeaconApiClient(BASE_PATH);
		
		StatementsApi statementsApi = new StatementsApi(apiClient);

		try {
			statementsApi.getStatements(null, null, null, null, null, null, null);
			Assert.fail("Invalid parameters should have resulted in an ApiException");
		} catch (ApiException e) {
			// Expected error
		}
	}

}
