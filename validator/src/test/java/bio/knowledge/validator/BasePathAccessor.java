package bio.knowledge.validator;

import org.springframework.beans.factory.annotation.Value;

public class BasePathAccessor {

    @Value(value = "${basePath}")
    private String BASE_PATH;

    protected String getBasePath() {
        return BASE_PATH.trim();
    }
}
