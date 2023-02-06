package com.anymind.points.services;

import com.anymind.points.dtos.request.PaymentRequest;
import com.anymind.points.dtos.response.PaymentResponse;

import java.text.ParseException;

public interface PaymentService extends CommonService {
	public PaymentResponse savePayment (PaymentRequest request) throws ParseException;
}
