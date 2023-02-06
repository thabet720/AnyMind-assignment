package com.anymind.points.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.anymind.points.PointsApplicationTests;
import com.anymind.points.constants.PaymentMethod;
import com.anymind.points.dao.PaymentDao;
import com.anymind.points.dtos.request.PaymentRequest;
import com.anymind.points.dtos.response.PaymentResponse;
import com.anymind.points.entities.Payment;
import com.anymind.points.services.impl.PaymentServiceImpl;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

public class PaymentServiceTest extends PointsApplicationTests {
	@Autowired
	private PaymentServiceImpl paymentService;
	@Mock
	private PaymentDao paymentDao;
	@Autowired
	private ConversionService conversionService;
	
	@Test
	public void addCashPaymentTest() throws ParseException {
		PaymentRequest request = new PaymentRequest(100, 0.9, PaymentMethod.CASH, "2023-02-01T00:20:00z");
		Mockito.when(paymentDao.save(Mockito.any(Payment.class))).thenReturn(conversionService.convert(request, Payment.class));
		PaymentResponse result = paymentService.savePayment(request);
		assertThat(result.getFinalPrice()==90);
		assertThat(result.getPoints()==5);
		
	}
	@Test
	public void addCashOnDeliveryPaymentTest() throws ParseException {
		PaymentRequest request = new PaymentRequest(100, 1.02, PaymentMethod.CASH_ON_DELIVERY, "2023-02-01T00:20:00z");
		Mockito.when(paymentDao.save(Mockito.any(Payment.class))).thenReturn(conversionService.convert(request, Payment.class));
		PaymentResponse result = paymentService.savePayment(request);
		assertThat(result.getFinalPrice()==102);
		assertThat(result.getPoints()==5);
		
	}
	public void addVisaPaymentTest() throws ParseException {
		PaymentRequest request = new PaymentRequest(100, 0.95, PaymentMethod.VISA, "2023-02-01T00:20:00z");
		Mockito.when(paymentDao.save(Mockito.any(Payment.class))).thenReturn(conversionService.convert(request, Payment.class));
		PaymentResponse result = paymentService.savePayment(request);
		assertThat(result.getFinalPrice()==95);
		assertThat(result.getPoints()==3);
		
	}
	public void addMasterCardPaymentTest() throws ParseException {
		PaymentRequest request = new PaymentRequest(100, 0.95, PaymentMethod.MASTERCARD, "2023-02-01T00:20:00z");
		Mockito.when(paymentDao.save(Mockito.any(Payment.class))).thenReturn(conversionService.convert(request, Payment.class));
		PaymentResponse result = paymentService.savePayment(request);
		assertThat(result.getFinalPrice()==95);
		assertThat(result.getPoints()==3);
		
	}
	public void addAmexPaymentTest() throws ParseException {
		PaymentRequest request = new PaymentRequest(100, 0.98, PaymentMethod.AMEX, "2023-02-01T00:20:00z");
		Mockito.when(paymentDao.save(Mockito.any(Payment.class))).thenReturn(conversionService.convert(request, Payment.class));
		PaymentResponse result = paymentService.savePayment(request);
		assertThat(result.getFinalPrice()==98);
		assertThat(result.getPoints()==2);
		
	}
	public void addJCBPaymentTest() throws ParseException {
		PaymentRequest request = new PaymentRequest(100, 0.95, PaymentMethod.JCB, "2023-02-01T00:20:00z");
		Mockito.when(paymentDao.save(Mockito.any(Payment.class))).thenReturn(conversionService.convert(request, Payment.class));
		PaymentResponse result = paymentService.savePayment(request);
		assertThat(result.getFinalPrice()==95);
		assertThat(result.getPoints()==5);
		
	}
}
