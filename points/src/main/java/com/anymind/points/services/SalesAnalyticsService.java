package com.anymind.points.services;

import com.anymind.points.dtos.request.SalesAnalyticsRequest;
import com.anymind.points.dtos.response.SalesAnalyticsResponse;

import java.text.ParseException;
import java.util.List;

public interface SalesAnalyticsService extends CommonService {
	public List<SalesAnalyticsResponse> getSalesAndPointsPerHour( SalesAnalyticsRequest request) throws ParseException;
}
