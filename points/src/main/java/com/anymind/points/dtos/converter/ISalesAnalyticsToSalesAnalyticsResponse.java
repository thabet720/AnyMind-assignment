package com.anymind.points.dtos.converter;

import com.anymind.points.dtos.response.SalesAnalyticsResponse;
import com.anymind.points.entities.ISalesAnalaytics;
import com.anymind.points.utils.DateTimeUtil;

import org.springframework.core.convert.converter.Converter;

public class ISalesAnalyticsToSalesAnalyticsResponse implements Converter<ISalesAnalaytics, SalesAnalyticsResponse> {

	@Override
	public SalesAnalyticsResponse convert(ISalesAnalaytics source) {
		SalesAnalyticsResponse to = new  SalesAnalyticsResponse();
		to.setPoints(source.getPointsSum())  ;
		to.setSales(Double.toString(source.getPriceSum())) ;
		to.setDatetime(DateTimeUtil.stringFormatTimestamp(source.getDateHour(), "yyyy-MM-dd'T'hh:mm:ss'z'")) ;
		return to;
	}

}
