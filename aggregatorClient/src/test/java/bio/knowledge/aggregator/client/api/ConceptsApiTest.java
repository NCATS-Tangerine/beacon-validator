/*
 * Translator Knowledge Beacon Aggregator API
 * This is the Translator Knowledge Beacon Aggregator web service application programming interface (API) that provides integrated access to a pool of knowledge sources publishing concepts and relations through the Translator Knowledge Beacon API. This API is similar to that of the latter mentioned API with the addition of some extra informative endpoints plus session identifier and beacon indices. These latter identifiers are locally assigned numeric indices provided to track the use of specific registered beacons within the aggregator API itself. 
 *
 * OpenAPI spec version: 1.0.10
 * Contact: richard@starinformatics.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package bio.knowledge.aggregator.client.api;

import bio.knowledge.aggregator.client.ApiException;
import bio.knowledge.aggregator.client.model.ServerCliqueIdentifier;
import bio.knowledge.aggregator.client.model.ServerConceptWithDetails;
import bio.knowledge.aggregator.client.model.ServerConceptsQuery;
import bio.knowledge.aggregator.client.model.ServerConceptsQueryResult;
import bio.knowledge.aggregator.client.model.ServerConceptsQueryStatus;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ConceptsApi
 */
@Ignore
public class ConceptsApiTest {

    private final ConceptsApi api = new ConceptsApi();

    
    /**
     * 
     *
     * Retrieves the beacon aggregator assigned clique of equivalent concepts that includes the specified (url-encoded) CURIE identifier. Note that the clique to which a given concept CURIE belongs may change over time as the aggregator progressively discovers the members of the clique. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCliqueTest() throws ApiException {
        String identifier = null;
        ServerCliqueIdentifier response = api.getClique(identifier);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Retrieves details for a specified clique of equivalent concepts in the system,  as specified by a (url-encoded) CURIE identifier of a clique known to the aggregator 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getConceptDetailsTest() throws ApiException {
        String cliqueId = null;
        List<Integer> beacons = null;
        ServerConceptWithDetails response = api.getConceptDetails(cliqueId, beacons);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Retrieves a (paged) simple list of concepts from beacons with status &#39;data ready&#39; from a previously /concepts posted query parameter submission 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getConceptsTest() throws ApiException {
        String queryId = null;
        List<Integer> beacons = null;
        Integer pageNumber = null;
        Integer pageSize = null;
        ServerConceptsQueryResult response = api.getConcepts(queryId, beacons, pageNumber, pageSize);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Retrieves the status of a given query about the concepts in the system 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getConceptsQueryStatusTest() throws ApiException {
        String queryId = null;
        List<Integer> beacons = null;
        ServerConceptsQueryStatus response = api.getConceptsQueryStatus(queryId, beacons);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Posts the query parameters to retrieves a (paged) list of  concepts from the system 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postConceptsQueryTest() throws ApiException {
        String keywords = null;
        List<String> types = null;
        List<Integer> beacons = null;
        ServerConceptsQuery response = api.postConceptsQuery(keywords, types, beacons);

        // TODO: test validations
    }
    
}
