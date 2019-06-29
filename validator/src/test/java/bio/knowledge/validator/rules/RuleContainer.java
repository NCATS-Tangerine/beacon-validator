package bio.knowledge.validator.rules;

import bio.knowledge.validator.ApiClient;
import bio.knowledge.validator.BasePathAccessor;
import bio.knowledge.validator.BeaconExceptionInterface;
import bio.knowledge.validator.logging.Logger;
import bio.knowledge.validator.logging.LoggerFactory;
import org.apache.commons.math3.stat.StatUtils;
import org.junit.rules.Stopwatch;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Component
public class RuleContainer  extends BasePathAccessor {

	@Autowired LoggerFactory loggerFactory;
	
	private TestWatcher testWatcher;
	
	private Stopwatch stopwatch;
	
	private Map<String, Double> time_sec = new HashMap<String, Double>();
	
	private Map<String, Double> unit_map = new TreeMap<String, Double>();
	
	@PostConstruct
	private void init() {
		testWatcher = new TestWatcher() {
			
			@Override
			public void failed(Throwable e, Description description) {
				if (e instanceof BeaconExceptionInterface) {
					ApiClient apiClient = ((BeaconExceptionInterface) e).getApiClient();
					
					Logger logger = loggerFactory.get(apiClient);
					
					logger.error(e, description.getMethodName(), apiClient.getQueryHistory());
				} else {
					Logger logger = loggerFactory.get(getBasePath());
					logger.error(e, description.getMethodName(), new ArrayList<String>());
				}
		    }
		};
		
		stopwatch = new Stopwatch() {
			@Override
			protected void finished(long nanos, Description description) {
				time_sec.put(description.getMethodName(), (double) nanos);
			}
		};
		
		unit_map.put("hrs", 3.6e+12);
		unit_map.put("min", 6e+10);
		unit_map.put("sec", 1e+9);
		unit_map.put("ms", 1000000d);		
	}
	
	@PreDestroy
	public void finish() {
		double[] values = new double[time_sec.size()];
		
		Logger logger = loggerFactory.get(getBasePath());
		
		int i = 0;
		for (String method : time_sec.keySet()) {
			double time = time_sec.get(method);
			logger.info("Time for " + method + ": " + formatTime(time));
			values[i++] = time;
		}
		
		double geometricMean = round(StatUtils.geometricMean(values));
		double mean = round(StatUtils.mean(values));
		double sum = round(StatUtils.sum(values));
		
		logger.info("Gemoetric mean: " + formatTime(geometricMean));
		logger.info("Arithmetic mean: " + formatTime(mean));
		logger.info("Sum: " + formatTime(sum));
	}
	
	public TestWatcher getTestWatcher() {
		return testWatcher;
	}
	
	public Stopwatch getStopwatch() {
		return this.stopwatch;
	}
	
	/**
	 * Rounds to three decimal places
	 */
	private double round(double d) {
		return Math.round(d * 1000) / 1000d;
	}

	private String formatTime(double ns) {
		
		for (String unit : unit_map.keySet()) {
			double conversion = unit_map.get(unit);
			double time = ns / conversion;
			
			if (time >= 1) {
				return String.valueOf(round(time)) + " " + unit;
			}
		}
		
		return String.valueOf(round(ns)) + " ns";
	}

}
