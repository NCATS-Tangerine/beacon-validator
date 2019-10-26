package bio.knowledge.validator.rule;

import java.util.ArrayList;
import java.util.List;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Provides factory methods for instantiating ApiClients for the aggregator or for a
 * beacon that records all queries made, which are then reported if the test fails.
 * 
 * @author Lance Hannestad
 */
public class QueryCatcherRule implements TestRule {
	
	List<String> queries = new ArrayList<>();
	
	public bio.knowledge.client.ApiClient getBeaconApiClient(String uri) {
		return new bio.knowledge.client.ApiClient() {
			{ setBasePath(formatUrl(uri)); }
			
			@Override
			public String buildUrl(String path, List<bio.knowledge.client.Pair> queryParams) {
				String query = super.buildUrl(path, queryParams);
				queries.add(query);
				return query;
			}
		};
	}
	
	public bio.knowledge.aggregator.client.ApiClient getAggregatorApiClient(String uri) {
		return new bio.knowledge.aggregator.client.ApiClient() {
			{ setBasePath(formatUrl(uri)); }
			
			@Override
			public String buildUrl(String path, List<bio.knowledge.aggregator.client.Pair> queryParams) {
				String query = super.buildUrl(path, queryParams);
				queries.add(query);
				return query;
			}
		};
	}

	@Override
	public Statement apply(Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					base.evaluate();
				} catch (Throwable cause) {
					cause.printStackTrace();
					
					if (queries.isEmpty()) {
						throw cause;
					} else {
						String message = "Queries caused a test failure:\n" + String.join("\n", queries);
						throw new Exception(message, cause);
					}
				}
			}
		};
	}
	
	private static String formatUrl(String url) {
		url = url.trim();
		
		while (url.endsWith("/")) {
			url = url.substring(0, url.length() - 1);
		}
		
		return url;
	}

}
