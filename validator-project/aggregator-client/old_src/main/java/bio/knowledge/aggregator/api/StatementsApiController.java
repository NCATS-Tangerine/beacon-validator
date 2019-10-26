package bio.knowledge.aggregator.api;

import bio.knowledge.aggregator.model.ServerStatementDetails;
import bio.knowledge.aggregator.model.ServerStatementsQuery;
import bio.knowledge.aggregator.model.ServerStatementsQueryResult;
import bio.knowledge.aggregator.model.ServerStatementsQueryStatus;
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
public class StatementsApiController implements StatementsApi {

    private static final Logger log = LoggerFactory.getLogger(StatementsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public StatementsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ServerStatementDetails> getStatementDetails(@ApiParam(value = "(url-encoded) CURIE identifier of the concept-relationship statement (\"assertion\", \"claim\") for which associated evidence is sought, e.g. kbs:Q420626_P2175_Q126691 ",required=true) @PathVariable("statementId") String statementId,@ApiParam(value = "an array of keywords or substrings against which to filter a reference label (e.g. title) statement evidence citation array.") @Valid @RequestParam(value = "keywords", required = false) List<String> keywords,@ApiParam(value = "(1-based) number of the page to be returned in a paged set of statement.evidence array entries. Defaults to 1. ") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,@ApiParam(value = "number of cited references per page to be returned in a paged set of statement.evidence array entries. Defaults to '10'. ") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerStatementDetails>(objectMapper.readValue("{  \"id\" : \"kb:12345\",  \"keywords\" : [ \"hernia\" ],  \"pageNumber\" : 1,  \"pageSize\" : 10,  \"is_defined_by\" : \"http://starinformatics.com\",  \"provided_by\" : \"https://skr3.nlm.nih.gov/SemMedDB/\",  \"qualifiers\" : [ ],  \"annotation\" : [ {    \"tag\" : \"stage\",    \"value\" : \"neo-natal\"  } ],  \"evidence\" : [ {    \"id\" : \"PMID:22781086\",    \"uri\" : \"https://www.ncbi.nlm.nih.gov/pubmed/?term=22781086\",    \"name\" : \"Neonatal diabetes mellitus and congenital diaphragmatic hernia coincidence or concurrent etiology?\",    \"evidence_type\" : \"ECO_0000033\"  } ]}", ServerStatementDetails.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerStatementDetails>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServerStatementDetails>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServerStatementsQueryResult> getStatements(@ApiParam(value = "an active query identifier as returned by a POST of statement query parameters.",required=true) @PathVariable("queryId") String queryId,@ApiParam(value = "subset of aggregator indices of beacons whose statements are to be retrieved ") @Valid @RequestParam(value = "beacons", required = false) List<Integer> beacons,@ApiParam(value = "(1-based) number of the page to be returned in a paged set of query results. Defaults to '1'. ") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,@ApiParam(value = "number of concepts per page to be returned in a paged set of query results. Defaults to '10'. ") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerStatementsQueryResult>(objectMapper.readValue("{  \"queryId\" : \"Mi1ZtYiLofVNTxDa9Dz5\",  \"beacons\" : [ 5 ],  \"pageNumber\" : 1,  \"pageSize\" : 1,  \"results\" : [ {    \"id\" : \"kb:12345\",    \"subject\" : {      \"id\" : \"wd:Q14912054\",      \"name\" : \"KCNJ11\",      \"categories\" : \"gene\"    },    \"predicate\" : {      \"edge_label\" : \"has_phenotype\",      \"relation\" : \"RO:0002200\",      \"negated\" : \"false\"    },    \"object\" : {      \"id\" : \"wd:Q2898645\",      \"name\" : \"Neonatal diabetes mellitus\",      \"categories\" : \"disease\"    },    \"beacon\" : \"5\"  } ]}", ServerStatementsQueryResult.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerStatementsQueryResult>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServerStatementsQueryResult>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServerStatementsQueryStatus> getStatementsQueryStatus(@ApiParam(value = "an active query identifier as returned by a POST of statements  query parameters.",required=true) @PathVariable("queryId") String queryId,@ApiParam(value = "subset of aggregator indices of beacons whose status is being polled (if omitted, then the status of all beacons from the query are returned) ") @Valid @RequestParam(value = "beacons", required = false) List<Integer> beacons) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerStatementsQueryStatus>(objectMapper.readValue("{  \"queryId\" : \"XY456\",  \"status\" : [ {    \"beacon\" : 1,    \"status\" : 200,    \"discovered\" : 3,    \"processed\" : 3,    \"count\" : 3  }, {    \"beacon\" : 2,    \"status\" : 500  }, {    \"beacon\" : 5,    \"status\" : 102,    \"discovered\" : 37,    \"processed\" : 10  } ]}", ServerStatementsQueryStatus.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerStatementsQueryStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServerStatementsQueryStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServerStatementsQuery> postStatementsQuery(@NotNull @ApiParam(value = "a [CURIE-encoded](https://www.w3.org/TR/curie/) identifier of the  exactly matching 'source' clique, cliques as identified by other endpoints of the beacon aggregator API.  ", required = true) @Valid @RequestParam(value = "source", required = true) String source,@ApiParam(value = "a subset (array) of identifiers of predicate relation identifiers with which to constrain the statement relations retrieved  for the given query seed concept. The predicate ids sent should  be as published by the beacon-aggregator by the /predicates API endpoint. ") @Valid @RequestParam(value = "relations", required = false) List<String> relations,@ApiParam(value = "a [CURIE-encoded](https://www.w3.org/TR/curie/) identifier of the  exactly matching 'target' clique, cliques as identified by other endpoints of the beacon aggregator API.  ") @Valid @RequestParam(value = "target", required = false) String target,@ApiParam(value = "an array of keywords or substrings against which to match the  'target' concept or 'predicate' names of the set of  concept-relations matched by the 'source' concepts.") @Valid @RequestParam(value = "keywords", required = false) List<String> keywords,@ApiParam(value = "a subset (array) of identifiers of concept categories to which to constrain 'target' concepts associated with the given 'source' concept ((see [Biolink Model](https://biolink.github.io/biolink-model) for the full list of categories). ") @Valid @RequestParam(value = "categories", required = false) List<String> categories,@ApiParam(value = "set of aggregator indices of beacons to be used as knowledge sources for the query ") @Valid @RequestParam(value = "beacons", required = false) List<Integer> beacons) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerStatementsQuery>(objectMapper.readValue("{  \"queryId\" : \"Mi1ZtYiLofVNTxDa9Dz5\",  \"source\" : \"NCBIGENE:7486\",  \"relations\" : \"has_phenotype\",  \"target\" : \"\",  \"keywords\" : [ ],  \"categories\" : [ \"disease\" ]}", ServerStatementsQuery.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerStatementsQuery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServerStatementsQuery>(HttpStatus.NOT_IMPLEMENTED);
    }

}
