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
import bio.knowledge.aggregator.client.model.ServerAnnotation;
import bio.knowledge.aggregator.client.model.ServerStatementsQuery;
import bio.knowledge.aggregator.client.model.ServerStatementsQueryResult;
import bio.knowledge.aggregator.client.model.ServerStatementsQueryStatus;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for StatementsApi
 */
@Ignore
public class StatementsApiTest {

    private final StatementsApi api = new StatementsApi();

    
    /**
     * 
     *
     * Retrieves a (paged) list of annotations cited as evidence for a specified concept-relationship statement 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEvidenceTest() throws ApiException {
        String statementId = null;
        String keywords = null;
        Integer pageNumber = null;
        Integer pageSize = null;
        List<Integer> beacons = null;
        List<ServerAnnotation> response = api.getEvidence(statementId, keywords, pageNumber, pageSize, beacons);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Given a specification [CURIE-encoded](https://www.w3.org/TR/curie/) a &#39;source&#39; clique identifier for a set of exactly matching concepts,  retrieves a paged list of concept-relations where either the subject or object concept matches the &#39;source&#39; clique identifier.  Optionally, a &#39;target&#39; clique identifier may also be given, in which case the &#39;target&#39; clique identifier should match the concept clique opposing the &#39;source&#39;, that is, if the &#39;source&#39; matches a subject, then the  &#39;target&#39; should match the object of a given statement (or vice versa). 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStatementsQueryTest() throws ApiException {
        String queryId = null;
        List<Integer> beacons = null;
        Integer pageNumber = null;
        Integer pageSize = null;
        ServerStatementsQueryResult response = api.getStatementsQuery(queryId, beacons, pageNumber, pageSize);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Retrieves the status of a given query about the statements in the system 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStatementsQueryStatusTest() throws ApiException {
        String queryId = null;
        List<Integer> beacons = null;
        ServerStatementsQueryStatus response = api.getStatementsQueryStatus(queryId, beacons);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Posts a query to retrieve concept-relations where either the subject or object concept matches a [CURIE-encoded &#39;source&#39;](https://www.w3.org/TR/curie/) clique identifier designating a set of exactly matching concepts. A &#39;target&#39; clique identifier may optionally be given, in which case the &#39;target&#39; clique identifier should match the concept clique opposing the &#39;source&#39;, that is, if the &#39;source&#39; matches a subject, then the  &#39;target&#39; should match the object of a given statement (or vice versa). 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postStatementsQueryTest() throws ApiException {
        String source = null;
        List<String> relations = null;
        String target = null;
        String keywords = null;
        List<String> types = null;
        List<Integer> beacons = null;
        ServerStatementsQuery response = api.postStatementsQuery(source, relations, target, keywords, types, beacons);

        // TODO: test validations
    }
    
}
