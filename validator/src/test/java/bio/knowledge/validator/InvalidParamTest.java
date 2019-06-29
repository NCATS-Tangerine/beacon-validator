package bio.knowledge.validator;

import bio.knowledge.client.ApiException;
import bio.knowledge.client.api.ConceptsApi;
import bio.knowledge.client.api.StatementsApi;
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

import static bio.knowledge.validator.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvalidParamTest extends BasePathAccessor {

	@Autowired RuleContainer ruleContainer;
	
	@Rule public TestWatcher testWatcher;
	@Rule public Stopwatch stopwatch;
	
	@PostConstruct
	public void init() {
		testWatcher = ruleContainer.getTestWatcher();
		stopwatch = ruleContainer.getStopwatch();
	}
	
	@Test
	public void testInvalidParams() {
		ApiClient apiClient = new ApiClient(getBasePath());
		ConceptsApi conceptsApi = new ConceptsApi(apiClient);
		StatementsApi statementsApi = new StatementsApi(apiClient);
		
		String message = "Invalid parameters should have resulted in an ApiException";
		
		// Other methods throw a null pointer error without sending a request and so they are not testable.
		
		try {
			conceptsApi.getConcepts(null, null, null);
			fail(apiClient, message);
		} catch (ApiException e) {
			apiClient.clearQueryHistory();
		}
		
		try {
			statementsApi.getStatements(null, null, null, null, null, null, null);
			fail(apiClient, message);
		} catch (ApiException e) {
			apiClient.clearQueryHistory();
		}
	}

}
