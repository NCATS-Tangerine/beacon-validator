package bio.knowledge.validator;

import bio.knowledge.client.ApiClient;
import bio.knowledge.client.ApiException;
import bio.knowledge.client.api.MetadataApi;
import bio.knowledge.client.model.BeaconConceptCategory;
import bio.knowledge.client.model.BeaconKnowledgeMapStatement;
import bio.knowledge.client.model.BeaconPredicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class MetadataContainer {
	
	@Value(value="${basePath}")
	public String BASE_PATH;
	
	private List<BeaconConceptCategory> types;
	private List<BeaconKnowledgeMapStatement> kmap;
	private List<BeaconPredicate> predicates;
	
	private MetadataApi metadataApi;
	
	@PostConstruct
	public void init() throws ApiException {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(BASE_PATH);
		metadataApi = new MetadataApi(apiClient);
	}
	
	public List<BeaconConceptCategory> getCategories() throws ApiException {
		if (types != null) {
			return this.types;
		} else {
			types = metadataApi.getConceptCategories();
			return types;
		}
	}
	
	public List<BeaconKnowledgeMapStatement> getKMap() throws ApiException {
		if (kmap != null) {
			return this.kmap;
		} else {
			kmap = metadataApi.getKnowledgeMap();
			return kmap;
		}
	}
	
	public List<BeaconPredicate> getPredicates() throws ApiException {
		if (predicates != null) {
			return this.predicates;
		} else {
			predicates = metadataApi.getPredicates();
			return predicates;
		}
	}

}
