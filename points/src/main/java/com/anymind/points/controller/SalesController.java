package com.anymind.points.controller;

import com.anymind.points.dtos.request.SalesAnalyticsRequest;
import com.anymind.points.dtos.response.SalesAnalyticsResponse;
import com.anymind.points.services.SalesAnalyticsService;
import com.anymind.points.validation.util.BeanValidatorUtil;
import com.anymind.points.validation.util.RuleValidatorUtil;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller

public class SalesController {
	@Autowired
	SalesAnalyticsService salesAnalyticService;
	@QueryMapping
	public List<SalesAnalyticsResponse> salesPerHour(@Argument String startDateTime,@Argument String endDateTime) throws ParseException {
		 SalesAnalyticsRequest request = new SalesAnalyticsRequest(startDateTime, endDateTime);
		 RuleValidatorUtil.validate(request);
		 BeanValidatorUtil.validate(request);
		return salesAnalyticService.getSalesAndPointsPerHour( request);
	}
}
