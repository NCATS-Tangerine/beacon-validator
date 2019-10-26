package bio.knowledge.validator;

import org.junit.Rule;
import org.springframework.beans.factory.annotation.Value;

import bio.knowledge.validator.rule.QueryCatcherRule;
import bio.knowledge.validator.rule.WarningRule;

public class BeaconTestBase {
	
	@Value("${basePath}")
    public String BASE_PATH;

	@Rule
	public QueryCatcherRule rule = new QueryCatcherRule();
	
	@Rule
	public WarningRule warningRule = new WarningRule();

}
