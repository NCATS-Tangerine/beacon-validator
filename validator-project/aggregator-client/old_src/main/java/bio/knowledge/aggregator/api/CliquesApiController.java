package bio.knowledge.aggregator.api;

import bio.knowledge.aggregator.model.ServerCliquesQuery;
import bio.knowledge.aggregator.model.ServerCliquesQueryResult;
import bio.knowledge.aggregator.model.ServerCliquesQueryStatus;
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
public class CliquesApiController implements CliquesApi {

    private static final Logger log = LoggerFactory.getLogger(CliquesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CliquesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ServerCliquesQueryResult> getCliques(@ApiParam(value = "the query identifier of a concepts query previously posted by the /cliques endpoint",required=true) @PathVariable("queryId") String queryId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerCliquesQueryResult>(objectMapper.readValue("{  \"queryId\" : \"XRBTu9CgfiXEhcfMdr4y\",  \"results\" : [ {    \"id\" : \"NCBIGENE:2176\",    \"cliqueId\" : \"NCBIGENE:2176\"  }, {    \"id\" : \"MONDO:0005406\",    \"cliqueId\" : \"NCIT:C34942\"  } ]}", ServerCliquesQueryResult.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerCliquesQueryResult>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServerCliquesQueryResult>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServerCliquesQueryStatus> getCliquesQueryStatus(@ApiParam(value = "an active query identifier as returned by a POST of clique query parameters.",required=true) @PathVariable("queryId") String queryId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerCliquesQueryStatus>(objectMapper.readValue("{  \"queryId\" : \"XRBTu9CgfiXEhcfMdr4y\",  \"status\" : [ {    \"beacon\" : 1,    \"status\" : 200,    \"count\" : 10  }, {    \"beacon\" : 2,    \"status\" : 500  }, {    \"beacon\" : 5,    \"status\" : 102  } ]}", ServerCliquesQueryStatus.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerCliquesQueryStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServerCliquesQueryStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServerCliquesQuery> postCliquesQuery(@NotNull @ApiParam(value = "an array of [CURIE-encoded](https://www.w3.org/TR/curie/)  identifiers of interest to be resolved to a list of concept cliques", required = true) @Valid @RequestParam(value = "ids", required = true) List<String> ids) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServerCliquesQuery>(objectMapper.readValue("{  \"queryId\" : \"XRBTu9CgfiXEhcfMdr4y\",  \"ids\" : [ \"NCIT:C34942\", \"MONDO:0005406\" ]}", ServerCliquesQuery.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServerCliquesQuery>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServerCliquesQuery>(HttpStatus.NOT_IMPLEMENTED);
    }

}
