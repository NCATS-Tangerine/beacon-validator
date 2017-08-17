package bio.knowledge.validator.utilities;

import bio.knowledge.client.ApiException;

@FunctionalInterface
public interface ThrowableFunction<T, R> {
	R apply(T t) throws ApiException;
}
