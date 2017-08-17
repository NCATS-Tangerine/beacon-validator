package bio.knowledge.validator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import bio.knowledge.client.ApiClient;
import bio.knowledge.validator.Validator.TestTerminationException;
import bio.knowledge.validator.utilities.MyLogger;

public class Application {
	public final static String stringdb = "http://52.15.182.253:8090/api";
	public final static String SemMedDb = "http://rka.ncats.io";
	public final static String Wikidata = "http://garbanzo.sulab.org";
	public final static String renci = "http://stars.renci.org:5000";
	public final static String biolink = "http://127.0.0.1:5000";
	
	Logger logger = Logger.getGlobal();
	
	private Validator validator;

	public static void main(String[] args) {
		
		try {
			MyLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String beaconUrl;
		
		if (args.length == 0) {
			String fileName = new java.io.File(Application.class.getProtectionDomain()
					  .getCodeSource()
					  .getLocation()
					  .getPath())
					.getName();
			
			if (!fileName.endsWith(".jar")) {
				fileName = fileName + ".jar";
			}
			
			System.out.println("Usage: java -jar " + fileName + " beacon-url [keyword...]");
			return;
		} else {
			try {
				URL url = new URL(args[0]);
				beaconUrl = url.toString();
				beaconUrl = beaconUrl.endsWith("/") ? beaconUrl.substring(0, beaconUrl.length() - 1) : beaconUrl;
			} catch (MalformedURLException e) {
				System.out.println("The string \"" + args[0] + "\" is not a valid URL. Ensure that it begins with \"http://\"");
				return;
			}
		}
		
		Application application = new Application(beaconUrl);
		
		if (args.length > 1) {
			String keywords = "";
			for (int i = 1; i < args.length; i++) {
				keywords += args[i] + " ";
			}
			keywords = keywords.trim();
			application.validator.setKeywords(keywords);
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
//				List<Exception> exceptions = application.getExceptions();
//				Logger.getGlobal().info("Test finished with " + String.valueOf(exceptions.size()) + " errors detected.");
				Logger.getGlobal().info("Test finished.");
			}
		});
		
		Logger.getGlobal().info("Testing beacon at: " + beaconUrl);
		Logger.getGlobal().info("Using keywords: " + application.validator.getKeywords());
		
		application.run();
	}
	
	public Application(String beaconUrl) {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(beaconUrl);
		validator = new Validator(apiClient);
	}
	
	private void run() {
		try {
			validator.validate();
		} catch (TestTerminationException e) {
			logger.info("Test terminated prematurely");
		}
	}
}
