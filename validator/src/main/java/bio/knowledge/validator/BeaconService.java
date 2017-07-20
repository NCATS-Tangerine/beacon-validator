package bio.knowledge.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import bio.knowledge.client.ApiClient;
import bio.knowledge.client.ApiException;
import bio.knowledge.client.api.ConceptsApi;
import bio.knowledge.client.api.EvidenceApi;
import bio.knowledge.client.api.ExactmatchesApi;
import bio.knowledge.client.api.StatementsApi;
import bio.knowledge.client.api.SummaryApi;
import bio.knowledge.client.model.base.Concept;
import bio.knowledge.client.model.base.Statement;
import bio.knowledge.validator.utilities.Util;

public class BeaconService {
	
	private final Logger logger = Logger.getGlobal();
	
	private final ConceptsApi conceptsApi;
	private final StatementsApi statementsApi;
	private final EvidenceApi evidenceApi;
	private final ExactmatchesApi exactmatchesApi;
	private final SummaryApi summaryApi;
	
	private List<Exception> exceptions = new ArrayList<Exception>();
	
	public BeaconService(ApiClient apiClient) {
		conceptsApi = new ConceptsApi(apiClient);
		statementsApi = new StatementsApi(apiClient);
		evidenceApi = new EvidenceApi(apiClient);
		exactmatchesApi = new ExactmatchesApi(apiClient);
		summaryApi = new SummaryApi(apiClient);
	}
	
	public List<Exception> getExceptions() {
		return this.exceptions;
	}
	
	private void addException(Exception e) {
		this.exceptions.add(e);
	}
	
	public List<Concept> getConcepts(String keywords, String semgroups, int pageNumber, int pageSize) {
		try {
			return (List) conceptsApi.getConcepts(keywords, semgroups, pageNumber, pageSize);
		} catch (ApiException e) {
			logger.severe(e.getMessage());
			addException(e);
			return null;
		}
	}
	
	public Concept getConcept(String keywords, String semgroups) {
		List<Concept> matches = getConcepts(keywords, semgroups, 1, 1);
		if (matches.isEmpty()) {
			return null;
		} else {
			return matches.get(0);
		}
	}
	
	public List<Statement> getStatements(List<String> c, Integer pageNumber, Integer pageSize, String keywords, String semgroups) {
		try {
			return (List) statementsApi.getStatements(c, pageNumber, pageSize, keywords, semgroups);
		} catch (ApiException e) {
			logger.severe(e.getMessage());
			addException(e);
			return null;
		}
	}

}
