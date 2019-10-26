/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package bio.knowledge.aggregator.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-25T19:34:49.338-07:00")

@Api(value = "errorlog", description = "the errorlog API")
public interface ErrorlogApi {

    @ApiOperation(value = "", nickname = "getErrorLog", notes = "Get a log of the system errors associated with a specified query ", response = Object.class, responseContainer = "List", tags={ "metadata", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response with most recent errors ", response = Object.class, responseContainer = "List") })
    @RequestMapping(value = "/errorlog",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Object>> getErrorLog(@NotNull @ApiParam(value = "query identifier returned from a POSTed query ", required = true) @Valid @RequestParam(value = "queryId", required = true) String queryId);

}
