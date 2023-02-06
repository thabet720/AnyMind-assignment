package com.anymind.points.dtos.request;

import com.anymind.points.validation.RuleConstraint;
import com.anymind.points.validation.field.IsDateFormatValid;
import com.anymind.points.validation.type.validator.GetSalesAnalyticsValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RuleConstraint(validateBy = GetSalesAnalyticsValidator.class)
public class SalesAnalyticsRequest extends BaseRequest{
	@NotNull(message = "must not be null")
	@NotBlank(message = " must not be empty")
	@IsDateFormatValid(message = " has an Invalid format")
	private String startDateTime;

	@NotNull(message = "must not be null")
	@NotBlank(message = " must not be empty")
	@IsDateFormatValid(message = " has an Invalid format")
	private String endDateTime;
	
	
	
	public SalesAnalyticsRequest() {
		super();
	}



	public SalesAnalyticsRequest(String startDateTime, String endDateTime) {
		super();
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
	}



	public String getStartDateTime() {
		return startDateTime;
	}



	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}



	public String getEndDateTime() {
		return endDateTime;
	}



	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	

}
