package com.anymind.points.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.anymind.points.PointsApplicationTests;
import com.anymind.points.dao.PaymentDao;
import com.anymind.points.dtos.request.SalesAnalyticsRequest;
import com.anymind.points.dtos.response.SalesAnalyticsResponse;
import com.anymind.points.entities.ISalesAnalaytics;
import com.anymind.points.services.impl.SalesAnalyticsServiceImpl;
import com.anymind.points.utils.DateTimeUtil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

public class SalesAnalyticsServiceTest extends PointsApplicationTests {
	@Mock
	private static PaymentDao dao;
	

	@Autowired
	private SalesAnalyticsServiceImpl salesService;
	
	@Test
	public void getSalesAndPointsPerHourOkResult() throws ParseException {
		List<ISalesAnalaytics> daoResult = new LinkedList<ISalesAnalaytics>();
		daoResult.add(initSalesAnalyticProjection(new Timestamp(new Date().getTime()), 50, 5000.0));
		SalesAnalyticsRequest request = new SalesAnalyticsRequest("2023-02-01T00:20:00z", "2023-02-11T00:20:00z");
		Mockito.when(dao.getSalesAndPointsByHourAndInterval(DateTimeUtil.getTimestampFromString("2023-02-01T00:20:00z", "yyyy-MM-dd'T'hh:mm:ss'z'"), 
				DateTimeUtil.getTimestampFromString("2023-02-11T00:20:00z", "yyyy-MM-dd'T'hh:mm:ss'z'"))).thenReturn(daoResult);
		List<SalesAnalyticsResponse> result = salesService.getSalesAndPointsPerHour(request);
		assertThat(result.size() == 1);
		assertThat(result.get(0).getPoints() == 50);
		assertThat(result.get(0).getSales() == Double.toString(5000.0));
	}

	private ISalesAnalaytics initSalesAnalyticProjection(Timestamp dateTime, int points, double sales) {
		ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
		ISalesAnalaytics instance = factory.createProjection(ISalesAnalaytics.class);
		instance.setDateHour(dateTime);
		instance.setPointSum(points);
		instance.setPriceSum(sales);
		return instance;
	}
}
