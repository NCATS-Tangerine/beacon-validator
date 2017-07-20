package bio.knowledge.client.model.base;

public class ApiClientBase {
	private String lastQueryUri;
    
    public String getLastQuery() {
    	return this.lastQueryUri;
    }
    
    public void setLastQuery(String lastQuery) {
    	this.lastQueryUri = lastQuery;
    }
}
