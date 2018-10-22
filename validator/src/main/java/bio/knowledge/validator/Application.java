package bio.knowledge.validator;

import java.util.Properties;

import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		if (args.length > 0) {
			Properties properties = new Properties();
			properties.put("basePath", args[0]);
//			properties.put("logging.level.org.springframework.web", "DEBUG");
		}
		
		SpringApplication.run(Application.class, args);
		
		for (int i = 0; i < args.length; i++) {
			System.out.println("arg[" + String.valueOf(i) + "] = " + args[i]);
		}
		
		Computer computer = new Computer();
		JUnitCore jUnitCore = new JUnitCore();
//		jUnitCore.run(computer, ActiveEndpointsTests.class);
		jUnitCore.main("bio.knowledge.validator.ActiveEndpointsTests");
		
//		SpringApplication.run(Application.class, args);
	}
}
