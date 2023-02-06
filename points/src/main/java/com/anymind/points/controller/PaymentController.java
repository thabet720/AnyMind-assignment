package com.anymind.points.controller;

import com.anymind.points.dtos.request.PaymentRequest;
import com.anymind.points.dtos.response.PaymentResponse;
import com.anymind.points.services.PaymentService;
import com.anymind.points.validation.util.BeanValidatorUtil;
import com.anymind.points.validation.util.RuleValidatorUtil;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@MutationMapping
	public PaymentResponse pay(@Argument double price, @Argument double priceModifier, @Argument String paymentMethod,@Argument String datetime) throws ParseException {
		PaymentRequest paymentRequest = new PaymentRequest(price, priceModifier, paymentMethod, datetime);
		BeanValidatorUtil.validate(paymentRequest);
		RuleValidatorUtil.validate(paymentRequest);
		return paymentService.savePayment(paymentRequest);
	}
}
