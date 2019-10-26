/*
 * Bio Translator Knowledge Beacon API
 * This is the Translator Knowledge Beacon web service application programming interface (API) 
 *
 * OpenAPI spec version: 1.1.1
 * Contact: richard@starinformatics.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package bio.knowledge.client.api;

import bio.knowledge.client.ApiCallback;
import bio.knowledge.client.ApiClient;
import bio.knowledge.client.ApiException;
import bio.knowledge.client.ApiResponse;
import bio.knowledge.client.Configuration;
import bio.knowledge.client.Pair;
import bio.knowledge.client.ProgressRequestBody;
import bio.knowledge.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import bio.knowledge.client.model.BeaconStatement;
import bio.knowledge.client.model.BeaconStatementWithDetails;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatementsApi {
    private ApiClient apiClient;

    public StatementsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public StatementsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for getStatementDetails */
    private com.squareup.okhttp.Call getStatementDetailsCall(String statementId, List<String> keywords, Integer size, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/statements/{statementId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "statementId" + "\\}", apiClient.escapeString(statementId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (keywords != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "keywords", keywords));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "size", size));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getStatementDetailsValidateBeforeCall(String statementId, List<String> keywords, Integer size, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'statementId' is set
        if (statementId == null) {
            throw new ApiException("Missing the required parameter 'statementId' when calling getStatementDetails(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getStatementDetailsCall(statementId, keywords, size, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 
     * Retrieves a details relating to a specified concept-relationship statement include &#39;is_defined_by and &#39;provided_by&#39; provenance; extended edge properties exported as tag &#x3D; value; and any associated annotations (publications, etc.)  cited as evidence for the given statement. 
     * @param statementId (url-encoded) CURIE identifier of the concept-relationship statement (\&quot;assertion\&quot;, \&quot;claim\&quot;) for which associated evidence is sought  (required)
     * @param keywords an array of keywords or substrings against which to  filter annotation names (e.g. publication titles). (optional)
     * @param size maximum number of concept entries requested by the client; if this  argument is omitted, then the query is expected to returned all  the available data for the query  (optional)
     * @return BeaconStatementWithDetails
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public BeaconStatementWithDetails getStatementDetails(String statementId, List<String> keywords, Integer size) throws ApiException {
        ApiResponse<BeaconStatementWithDetails> resp = getStatementDetailsWithHttpInfo(statementId, keywords, size);
        return resp.getData();
    }

    /**
     * 
     * Retrieves a details relating to a specified concept-relationship statement include &#39;is_defined_by and &#39;provided_by&#39; provenance; extended edge properties exported as tag &#x3D; value; and any associated annotations (publications, etc.)  cited as evidence for the given statement. 
     * @param statementId (url-encoded) CURIE identifier of the concept-relationship statement (\&quot;assertion\&quot;, \&quot;claim\&quot;) for which associated evidence is sought  (required)
     * @param keywords an array of keywords or substrings against which to  filter annotation names (e.g. publication titles). (optional)
     * @param size maximum number of concept entries requested by the client; if this  argument is omitted, then the query is expected to returned all  the available data for the query  (optional)
     * @return ApiResponse&lt;BeaconStatementWithDetails&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<BeaconStatementWithDetails> getStatementDetailsWithHttpInfo(String statementId, List<String> keywords, Integer size) throws ApiException {
        com.squareup.okhttp.Call call = getStatementDetailsValidateBeforeCall(statementId, keywords, size, null, null);
        Type localVarReturnType = new TypeToken<BeaconStatementWithDetails>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Retrieves a details relating to a specified concept-relationship statement include &#39;is_defined_by and &#39;provided_by&#39; provenance; extended edge properties exported as tag &#x3D; value; and any associated annotations (publications, etc.)  cited as evidence for the given statement. 
     * @param statementId (url-encoded) CURIE identifier of the concept-relationship statement (\&quot;assertion\&quot;, \&quot;claim\&quot;) for which associated evidence is sought  (required)
     * @param keywords an array of keywords or substrings against which to  filter annotation names (e.g. publication titles). (optional)
     * @param size maximum number of concept entries requested by the client; if this  argument is omitted, then the query is expected to returned all  the available data for the query  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getStatementDetailsAsync(String statementId, List<String> keywords, Integer size, final ApiCallback<BeaconStatementWithDetails> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getStatementDetailsValidateBeforeCall(statementId, keywords, size, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<BeaconStatementWithDetails>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getStatements */
    private com.squareup.okhttp.Call getStatementsCall(List<String> s, String edgeLabel, String relation, List<String> t, List<String> keywords, List<String> categories, Integer size, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/statements".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (s != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "s", s));
        if (edgeLabel != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "edge_label", edgeLabel));
        if (relation != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "relation", relation));
        if (t != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "t", t));
        if (keywords != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "keywords", keywords));
        if (categories != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("csv", "categories", categories));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "size", size));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getStatementsValidateBeforeCall(List<String> s, String edgeLabel, String relation, List<String> t, List<String> keywords, List<String> categories, Integer size, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 's' is set
        if (s == null) {
            throw new ApiException("Missing the required parameter 's' when calling getStatements(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getStatementsCall(s, edgeLabel, relation, t, keywords, categories, size, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 
     * Given a specified set of [CURIE-encoded](https://www.w3.org/TR/curie/)  source (&#39;s&#39;) concept identifiers,  retrieves a list of relationship statements where either the subject or object concept matches any of the input &#39;source&#39; concepts provided.  Optionally, a set of target (&#39;t&#39;) concept  identifiers may also be given, in which case a member of the &#39;target&#39; identifier set should match the concept opposing the &#39;source&#39; in the  statement, that is, if the&#39;source&#39; matches a subject, then the  &#39;target&#39; should match the object of a given statement (or vice versa). 
     * @param s an array set of [CURIE-encoded](https://www.w3.org/TR/curie/) identifiers of  &#39;source&#39; concepts possibly known to the beacon. Unknown CURIES should simply be ignored (silent match failure).  (required)
     * @param edgeLabel (Optional) A predicate edge label against which to constrain the search for statements (&#39;edges&#39;) associated with the given query seed concept. The predicate edge_names for this parameter should be as published by the /predicates API endpoint and must be taken from the minimal predicate (&#39;slot&#39;) list of the [Biolink Model](https://biolink.github.io/biolink-model).  (optional)
     * @param relation (Optional) A predicate relation against which to constrain the search for statements (&#39;edges&#39;) associated with the given query seed concept. The predicate relations for this parameter should be as published by the /predicates API endpoint and the preferred format is a CURIE  where one exists, but strings/labels acceptable. This relation may be equivalent to the edge_label (e.g. edge_label: has_phenotype, relation: RO:0002200), or a more specific relation  in cases where the source provides more granularity (e.g. edge_label: molecularly_interacts_with, relation: RO:0002447)  (optional)
     * @param t (optional) an array set of [CURIE-encoded](https://www.w3.org/TR/curie/) identifiers of &#39;target&#39; concepts possibly known to the beacon.  Unknown CURIEs should simply be ignored (silent match failure).  (optional)
     * @param keywords an array of keywords or substrings against which to filter concept names and synonyms (optional)
     * @param categories an array set of concept categories (specified as Biolink name labels codes gene, pathway, etc.) to which to constrain concepts matched by the main keyword search (see [Biolink Model](https://biolink.github.io/biolink-model) for the full list of codes)  (optional)
     * @param size maximum number of concept entries requested by the client; if this  argument is omitted, then the query is expected to returned all  the available data for the query  (optional)
     * @return List&lt;BeaconStatement&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<BeaconStatement> getStatements(List<String> s, String edgeLabel, String relation, List<String> t, List<String> keywords, List<String> categories, Integer size) throws ApiException {
        ApiResponse<List<BeaconStatement>> resp = getStatementsWithHttpInfo(s, edgeLabel, relation, t, keywords, categories, size);
        return resp.getData();
    }

    /**
     * 
     * Given a specified set of [CURIE-encoded](https://www.w3.org/TR/curie/)  source (&#39;s&#39;) concept identifiers,  retrieves a list of relationship statements where either the subject or object concept matches any of the input &#39;source&#39; concepts provided.  Optionally, a set of target (&#39;t&#39;) concept  identifiers may also be given, in which case a member of the &#39;target&#39; identifier set should match the concept opposing the &#39;source&#39; in the  statement, that is, if the&#39;source&#39; matches a subject, then the  &#39;target&#39; should match the object of a given statement (or vice versa). 
     * @param s an array set of [CURIE-encoded](https://www.w3.org/TR/curie/) identifiers of  &#39;source&#39; concepts possibly known to the beacon. Unknown CURIES should simply be ignored (silent match failure).  (required)
     * @param edgeLabel (Optional) A predicate edge label against which to constrain the search for statements (&#39;edges&#39;) associated with the given query seed concept. The predicate edge_names for this parameter should be as published by the /predicates API endpoint and must be taken from the minimal predicate (&#39;slot&#39;) list of the [Biolink Model](https://biolink.github.io/biolink-model).  (optional)
     * @param relation (Optional) A predicate relation against which to constrain the search for statements (&#39;edges&#39;) associated with the given query seed concept. The predicate relations for this parameter should be as published by the /predicates API endpoint and the preferred format is a CURIE  where one exists, but strings/labels acceptable. This relation may be equivalent to the edge_label (e.g. edge_label: has_phenotype, relation: RO:0002200), or a more specific relation  in cases where the source provides more granularity (e.g. edge_label: molecularly_interacts_with, relation: RO:0002447)  (optional)
     * @param t (optional) an array set of [CURIE-encoded](https://www.w3.org/TR/curie/) identifiers of &#39;target&#39; concepts possibly known to the beacon.  Unknown CURIEs should simply be ignored (silent match failure).  (optional)
     * @param keywords an array of keywords or substrings against which to filter concept names and synonyms (optional)
     * @param categories an array set of concept categories (specified as Biolink name labels codes gene, pathway, etc.) to which to constrain concepts matched by the main keyword search (see [Biolink Model](https://biolink.github.io/biolink-model) for the full list of codes)  (optional)
     * @param size maximum number of concept entries requested by the client; if this  argument is omitted, then the query is expected to returned all  the available data for the query  (optional)
     * @return ApiResponse&lt;List&lt;BeaconStatement&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<BeaconStatement>> getStatementsWithHttpInfo(List<String> s, String edgeLabel, String relation, List<String> t, List<String> keywords, List<String> categories, Integer size) throws ApiException {
        com.squareup.okhttp.Call call = getStatementsValidateBeforeCall(s, edgeLabel, relation, t, keywords, categories, size, null, null);
        Type localVarReturnType = new TypeToken<List<BeaconStatement>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Given a specified set of [CURIE-encoded](https://www.w3.org/TR/curie/)  source (&#39;s&#39;) concept identifiers,  retrieves a list of relationship statements where either the subject or object concept matches any of the input &#39;source&#39; concepts provided.  Optionally, a set of target (&#39;t&#39;) concept  identifiers may also be given, in which case a member of the &#39;target&#39; identifier set should match the concept opposing the &#39;source&#39; in the  statement, that is, if the&#39;source&#39; matches a subject, then the  &#39;target&#39; should match the object of a given statement (or vice versa). 
     * @param s an array set of [CURIE-encoded](https://www.w3.org/TR/curie/) identifiers of  &#39;source&#39; concepts possibly known to the beacon. Unknown CURIES should simply be ignored (silent match failure).  (required)
     * @param edgeLabel (Optional) A predicate edge label against which to constrain the search for statements (&#39;edges&#39;) associated with the given query seed concept. The predicate edge_names for this parameter should be as published by the /predicates API endpoint and must be taken from the minimal predicate (&#39;slot&#39;) list of the [Biolink Model](https://biolink.github.io/biolink-model).  (optional)
     * @param relation (Optional) A predicate relation against which to constrain the search for statements (&#39;edges&#39;) associated with the given query seed concept. The predicate relations for this parameter should be as published by the /predicates API endpoint and the preferred format is a CURIE  where one exists, but strings/labels acceptable. This relation may be equivalent to the edge_label (e.g. edge_label: has_phenotype, relation: RO:0002200), or a more specific relation  in cases where the source provides more granularity (e.g. edge_label: molecularly_interacts_with, relation: RO:0002447)  (optional)
     * @param t (optional) an array set of [CURIE-encoded](https://www.w3.org/TR/curie/) identifiers of &#39;target&#39; concepts possibly known to the beacon.  Unknown CURIEs should simply be ignored (silent match failure).  (optional)
     * @param keywords an array of keywords or substrings against which to filter concept names and synonyms (optional)
     * @param categories an array set of concept categories (specified as Biolink name labels codes gene, pathway, etc.) to which to constrain concepts matched by the main keyword search (see [Biolink Model](https://biolink.github.io/biolink-model) for the full list of codes)  (optional)
     * @param size maximum number of concept entries requested by the client; if this  argument is omitted, then the query is expected to returned all  the available data for the query  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getStatementsAsync(List<String> s, String edgeLabel, String relation, List<String> t, List<String> keywords, List<String> categories, Integer size, final ApiCallback<List<BeaconStatement>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getStatementsValidateBeforeCall(s, edgeLabel, relation, t, keywords, categories, size, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<BeaconStatement>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}