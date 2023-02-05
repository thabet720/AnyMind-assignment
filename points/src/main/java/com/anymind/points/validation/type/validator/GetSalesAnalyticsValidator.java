package com.anymind.points.validation.type.validator;

import com.anymind.points.dtos.request.SalesAnalyticsRequest;
import com.anymind.points.utils.DateTimeUtil;
import com.anymind.points.validation.RuleValidator;
import com.anymind.points.validation.exception.ValidatorException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

public class GetSalesAnalyticsValidator implements RuleValidator<SalesAnalyticsRequest>{

	@Override
	public void validate(SalesAnalyticsRequest t) throws ValidatorException {
		try {
			Timestamp startDate = DateTimeUtil.getTimestampFromString(t.getStartDateTime(), "yyyy-MM-dd'T'hh:mm:ss'z'");
			Timestamp endDate = DateTimeUtil.getTimestampFromString(t.getEndDateTime(), "yyyy-MM-dd'T'hh:mm:ss'z'");
			Timestamp now = new Timestamp(new Date().getTime());
			if(startDate.after(now)) {
				throw new ValidatorException("start date must not be in the future");
			}
			if(endDate.before(startDate)) {
				throw new ValidatorException("start date must be before end date");
			}
		} catch (ParseException e) {
		  
		}
		
		
		
	}

}
