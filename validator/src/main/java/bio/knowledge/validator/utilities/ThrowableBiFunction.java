package bio.knowledge.validator.utilities;

import bio.knowledge.client.ApiException;

@FunctionalInterface
public interface ThrowableBiFunction<T, U, R>{
	R apply(T t, U u) throws ApiException;	
}
