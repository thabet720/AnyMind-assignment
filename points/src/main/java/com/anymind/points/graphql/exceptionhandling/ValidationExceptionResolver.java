package com.anymind.points.graphql.exceptionhandling;

import com.anymind.points.validation.exception.ValidatorException;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ValidationExceptionResolver extends DataFetcherExceptionResolverAdapter {

	@Override
	protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
		if (ex instanceof ValidatorException) {
			return GraphqlErrorBuilder.newError().errorType(ErrorType.ValidationError)
					.message(((ValidatorException) ex).getMessageList().get(0), "").build();
		} else if (!(ex instanceof ValidatorException)) {
			return GraphqlErrorBuilder.newError().errorType(ErrorType.ExecutionAborted)
					.message("Oops something went wrong", "").build();

		} else {
			return null;
		}
	}

}
