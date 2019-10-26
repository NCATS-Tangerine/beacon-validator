package bio.knowledge.aggregator.api;

import bio.knowledge.aggregator.model.ServerConceptWithDetails;
import bio.knowledge.aggregator.model.ServerConceptsQuery;
import bio.knowledge.aggregator.model.ServerConceptsQueryResult;
import bio.knowledge.aggregator.model.ServerConceptsQueryStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-25T19:34:49.338-07:00")

@Controller
public class ConceptsApiController implements ConceptsApi {

    private static final Logger log = LoggerFactory.getLogger(ConceptsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ConceptsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ServerConceptWithDetails> getConceptDetails(@ApiParam(value = "a [CURIE-encoded](https://www.w3.org/TR/curie/) identifier, as returned  by any other endpoint of the beacon aggregator API, of an exactly matching  concept clique of interest.",required=true) @PathVariable("cliqueId") String cliqueId,@ApiParam(value = "set of aggregator indices of beacons to be used as knowledge sources for the query ") @Valid @RequestParam(value = "beacons", required = false) List<Integer> beacons) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerConceptWithDetails>(objectMapper.readValue("{  \"clique\" : \"wd:Q14883734\",  \"name\" : \"Werner Syndrome\",  \"categories\" : \"disease\",  \"aliases\" : [ \"wd:Q14883734\", \"OMIM:277700\" ],  \"entries\" : [ {    \"beacon\" : 3,    \"id\" : \"OMIM:277700\",    \"synonyms\" : [ \"Werner Syndrome\", \"Pangeria\", \"Syndrome, Werner\", \"Progeria, Adult\", \"Werner Syndrome [Disease/Finding]\", \"Werner syndrome (disorder)\", \"adult progeria\", \"Werner\", \"syndromes werner\", \"Syndrome, Werner\\'s\", \"WRN\", \"Werner\\'s syndrome\", \"adults progeria\", \"Werner syndrome (adult progeria) (diagnosis)\", \"Werner syndrome (adult progeria)\", \"Syndrome, Werners\", \"Adult premature aging syndrome\", \"syndromes werner\\'s\", \"Werners Syndrome\", \"syndrome werner\", \"Progeria of the adult\", \"WS\", \"syndromes werners\", \"Adult premature ageing syndrome\" ],    \"definition\" : \"autosomal recessive disorder that causes premature aging in adults, characterized by sclerodermal skin changes, cataracts, subcutaneous calcifications, muscular atrophy, a tendency to diabetes mellitus, aged appearance of the face, baldness, and a high incidence of neoplastic disease.\",    \"details\" : [ {      \"tag\" : \"Symptom\",      \"value\" : \"Premature greying of hair\"    }, {      \"tag\" : \"Symptom\",      \"value\" : \"Muscular atrophy\"    } ]  } ]}", ServerConceptWithDetails.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerConceptWithDetails>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServerConceptWithDetails>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServerConceptsQueryResult> getConcepts(@ApiParam(value = "the query identifier of a concepts query previously posted by the /concepts endpoint",required=true) @PathVariable("queryId") String queryId,@ApiParam(value = "set of aggregator indices of beacons whose data are to be retrieved ") @Valid @RequestParam(value = "beacons", required = false) List<Integer> beacons,@ApiParam(value = "(1-based) number of the page to be returned in a paged set of query results. Defaults to '1'. ") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,@ApiParam(value = "number of concepts per page to be returned in a paged set of query results. Defaults to '10'. ") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerConceptsQueryResult>(objectMapper.readValue("{  \"queryId\" : \"XRBTu9CgfiXEhcfMdr4y\",  \"beacons\" : [ 1, 5 ],  \"pageNumber\" : 1,  \"pageSize\" : 4,  \"results\" : [ {    \"clique\" : \"UNIPROT:Q14191\",    \"name\" : \"WRN protein, human\",    \"category\" : \"protein\"  }, {    \"clique\" : \"NCBIGENE:56897\",    \"name\" : \"WRNIP1\",    \"category\" : \"gene\"  }, {    \"clique\" : \"NCBIGENE:7486\",    \"name\" : \"WRN\",    \"category\" : \"gene\"  }, {    \"clique\" : \"DOID:5686\",    \"name\" : \"Werner Syndrome\",    \"category\" : \"disease\"  } ]}", ServerConceptsQueryResult.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerConceptsQueryResult>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServerConceptsQueryResult>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServerConceptsQueryStatus> getConceptsQueryStatus(@ApiParam(value = "an active query identifier as returned by a POST of concept query parameters.",required=true) @PathVariable("queryId") String queryId,@ApiParam(value = "subset of aggregator indices of beacons whose status is being polled (if omitted, then the status of all beacons from the query are returned) ") @Valid @RequestParam(value = "beacons", required = false) List<Integer> beacons) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerConceptsQueryStatus>(objectMapper.readValue("{  \"queryId\" : \"XRBTu9CgfiXEhcfMdr4y\",  \"status\" : [ {    \"beacon\" : 1,    \"status\" : 200,    \"discovered\" : 3,    \"processed\" : 3,    \"count\" : 3  }, {    \"beacon\" : 2,    \"status\" : 500  }, {    \"beacon\" : 5,    \"status\" : 102,    \"discovered\" : 37,    \"processed\" : 10  } ]}", ServerConceptsQueryStatus.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerConceptsQueryStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServerConceptsQueryStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServerConceptsQuery> postConceptsQuery(@NotNull @ApiParam(value = "an array of keywords or substrings against which to match concept names and synonyms", required = true) @Valid @RequestParam(value = "keywords", required = true) List<String> keywords,@ApiParam(value = "a subset array of concept categories (specified as codes 'gene',  'pathway', etc.) to which to constrain concepts matched by the main keyword search (see [Biolink Model](https://biolink.github.io/biolink-model) for the full list of codes) ") @Valid @RequestParam(value = "categories", required = false) List<String> categories,@ApiParam(value = "subset of aggregator indices of beacons to be used as knowledge sources for the query (if omitted, then the all beacons are queried) ") @Valid @RequestParam(value = "beacons", required = false) List<Integer> beacons) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerConceptsQuery>(objectMapper.readValue("{  \"queryId\" : \"XRBTu9CgfiXEhcfMdr4y\",  \"keywords\" : [ \"Werner\", \"Syndrome\" ],  \"categories\" : [ \"gene\", \"protein\", \"disease\" ]}", ServerConceptsQuery.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerConceptsQuery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServerConceptsQuery>(HttpStatus.NOT_IMPLEMENTED);
    }

}
