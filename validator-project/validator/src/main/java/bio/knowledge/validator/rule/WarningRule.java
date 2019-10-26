package bio.knowledge.validator.rule;

import java.util.ArrayList;
import java.util.List;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Allows the submission of warnings that will result in an exception being thrown only if the test otherwise passes.
 */
public class WarningRule implements TestRule {
	
	private final List<String> warnings = new ArrayList<>();

	@Override
	public Statement apply(Statement base, Description description) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				base.evaluate();
						
				if (!warnings.isEmpty()) {
					String newline = warnings.size() == 1 ? " " : "\n";
					throw new Exception("Test passed with " + warnings.size() + "warnings" + newline + String.join("\n", warnings));
				}
			}
			
		};
	}
	
	public void warn(String message) {
		warnings.add(message);
	}

}
