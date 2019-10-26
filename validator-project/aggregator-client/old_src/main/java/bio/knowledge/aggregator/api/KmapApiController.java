package bio.knowledge.aggregator.api;

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
public class KmapApiController implements KmapApi {

    private static final Logger log = LoggerFactory.getLogger(KmapApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public KmapApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Object>> getKnowledgeMap(@ApiParam(value = "set of aggregator indices of beacons constraining knowledge maps returned  ") @Valid @RequestParam(value = "beacons", required = false) List<Integer> beacons) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Object>>(objectMapper.readValue("[ {  \"beacon\" : 1,  \"statements\" : [ {    \"subject\" : {      \"category\" : \"gene\",      \"prefixes\" : [ \"DRUGBANK\", \"CHEMBL\", \"UNIPROT\" ]    },    \"predicate\" : {      \"edge_label\" : \"is substance that treats\",      \"relation\" : \"RO:0002606\"    },    \"object\" : {      \"category\" : \"disease or phenotypic feature\",      \"prefixes\" : [ \"MP\", \"HP\", \"DOID\" ]    },    \"count\" : 500,    \"description\" : \"a small molecule or compound that is capable of some activity that negative regulates or decreases the magnitude of a pathological process, phenotype or disease\n\"  }, {    \"subject\" : {      \"category\" : \"drug\",      \"prefixes\" : [ \"DRUGBANK\", \"CHEMBL\" ]    },    \"predicate\" : {      \"edge_label\" : \"chemical_to_pathway_association\",      \"relation\" : \"SIO:001250\"    },    \"object\" : {      \"category\" : \"pathway\",      \"prefixes\" : [ \"KEGG\" ]    },    \"count\" : 100,    \"description\" : \"Drug interacts with a given pathway\n\"  } ]} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Object>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
