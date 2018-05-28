/*
 * Translator Knowledge Beacon API
 * This is the Translator Knowledge Beacon web service application programming interface (API). 
 *
 * OpenAPI spec version: 1.0.18
 * Contact: richard@starinformatics.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package bio.knowledge.client.api;

import bio.knowledge.client.ApiException;
import bio.knowledge.client.model.BeaconConceptCategory;
import bio.knowledge.client.model.BeaconKnowledgeMapStatement;
import bio.knowledge.client.model.BeaconPredicate;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for MetadataApi
 */
@Ignore
public class MetadataApiTest {

    private final MetadataApi api = new MetadataApi();

    
    /**
     * 
     *
     * Get a list of concept categories and number of their concept instances documented by the knowledge source. These types should be mapped onto the Translator-endorsed Biolink Model concept type classes with local types, explicitly added as mappings to the Biolink Model YAML file.  
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getConceptCategoriesTest() throws ApiException {
        List<BeaconConceptCategory> response = api.getConceptCategories();

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Get a high level knowledge map of the all the beacons by subject semantic type, predicate and semantic object type 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getKnowledgeMapTest() throws ApiException {
        List<BeaconKnowledgeMapStatement> response = api.getKnowledgeMap();

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Get a list of predicates used in statements issued by the knowledge source 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPredicatesTest() throws ApiException {
        List<BeaconPredicate> response = api.getPredicates();

        // TODO: test validations
    }
    
}
