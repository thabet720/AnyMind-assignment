package com.anymind.points.Validator;



import com.anymind.points.PointsApplicationTests;
import com.anymind.points.dtos.request.SalesAnalyticsRequest;
import com.anymind.points.validation.exception.ValidatorException;
import com.anymind.points.validation.type.validator.GetSalesAnalyticsValidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetSalesAnalyticsValidatorTest extends PointsApplicationTests {
	private GetSalesAnalyticsValidator validator= new GetSalesAnalyticsValidator();
	
	@Test
	public void startTimeAfterEndTimeTest () {
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
			SalesAnalyticsRequest request = new SalesAnalyticsRequest("2023-02-01T00:20:00z", "2023-01-01T00:20:00z");
			validator.validate(request);
		});
		Assertions.assertEquals("start date must be before end date", ex.getMessage());
	}
	@Test
	public void startTimeInFutureTest () {
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
			SalesAnalyticsRequest request = new SalesAnalyticsRequest("2024-02-01T00:20:00z", "2024-03-01T00:20:00z");
			validator.validate(request);
		});
		Assertions.assertEquals("start date must not be in the future", ex.getMessage());
	}

}
