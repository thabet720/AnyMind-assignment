package com.anymind.points.services.impl;

import com.anymind.points.dao.PaymentDao;
import com.anymind.points.dtos.request.SalesAnalyticsRequest;
import com.anymind.points.dtos.response.SalesAnalyticsResponse;
import com.anymind.points.entities.ISalesAnalaytics;
import com.anymind.points.services.SalesAnalyticsService;
import com.anymind.points.utils.DateTimeUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class SalesAnalyticsServiceImpl implements SalesAnalyticsService{
	@Autowired
	private PaymentDao  dao;
	
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public List<SalesAnalyticsResponse> getSalesAndPointsPerHour( SalesAnalyticsRequest request) throws ParseException {
		
		List<SalesAnalyticsResponse> analytics = new ArrayList<SalesAnalyticsResponse>();
		List<ISalesAnalaytics> salesAnalytics = dao.getSalesAndPointsByHourAndInterval(DateTimeUtil.getTimestampFromString(request.getStartDateTime(), "yyyy-MM-dd'T'hh:mm:ss'z'"),DateTimeUtil.getTimestampFromString(request.getEndDateTime(), "yyyy-MM-dd'T'hh:mm:ss'z'"));
		for(ISalesAnalaytics sales:salesAnalytics ){
			analytics.add(conversionService.convert(sales, SalesAnalyticsResponse.class));
		}
		return analytics;
	}

}
