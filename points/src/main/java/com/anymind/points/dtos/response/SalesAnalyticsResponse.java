package com.anymind.points.dtos.response;

import com.anymind.points.entities.ISalesAnalaytics;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesAnalyticsResponse extends BaseResponse{
	private String datetime;
	private String sales;
	private int points;
	 
	
	
	public SalesAnalyticsResponse() {
		
	}

	public SalesAnalyticsResponse( ISalesAnalaytics analytics) {
		this.points = analytics.getPointsSum();
		this.sales= Double.toString(analytics.getPriceSum());
		this.datetime= new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'z'").format(new Date(analytics.getDateHour().getTime()));
		
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	

}
