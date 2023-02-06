package com.anymind.points.services.impl;

import com.anymind.points.constants.PaymentMethod;
import com.anymind.points.constants.PaymentMethodPointsPercentage;
import com.anymind.points.dao.PaymentDao;
import com.anymind.points.dtos.request.PaymentRequest;
import com.anymind.points.dtos.response.PaymentResponse;
import com.anymind.points.entities.Payment;
import com.anymind.points.services.PaymentService;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private ConversionService conversionService;

	@Override
	public PaymentResponse savePayment(PaymentRequest request) throws ParseException {
		Payment payment = conversionService.convert(request, Payment.class);
		switch (request.getPaymentMethod()) {
		case PaymentMethod.CASH:
			payment.setFinalPrice(calulateFinalPrice(request.getPrice(), request.getPriceModifier()));
			payment.setPoints(calculatePoints(request.getPrice(), PaymentMethodPointsPercentage.CASH));
			break;
		case PaymentMethod.CASH_ON_DELIVERY:
			payment.setFinalPrice(calulateFinalPrice(request.getPrice(), request.getPriceModifier()));
			payment.setPoints(calculatePoints(request.getPrice(), PaymentMethodPointsPercentage.CASH_ON_DELIVERY));
			break;
		case PaymentMethod.VISA:
			payment.setFinalPrice(calulateFinalPrice(request.getPrice(), request.getPriceModifier()));
			payment.setPoints(calculatePoints(request.getPrice(), PaymentMethodPointsPercentage.VISA));
			break;
		case PaymentMethod.MASTERCARD:
			payment.setFinalPrice(calulateFinalPrice(request.getPrice(), request.getPriceModifier()));
			payment.setPoints(calculatePoints(request.getPrice(), PaymentMethodPointsPercentage.MASTERCARD));
			break;
		case PaymentMethod.AMEX:
			payment.setFinalPrice(calulateFinalPrice(request.getPrice(), request.getPriceModifier()));
			payment.setPoints(calculatePoints(request.getPrice(), PaymentMethodPointsPercentage.AMEX));
			break;
		case PaymentMethod.JCB:
			payment.setFinalPrice(calulateFinalPrice(request.getPrice(), request.getPriceModifier()));
			payment.setPoints(calculatePoints(request.getPrice(), PaymentMethodPointsPercentage.JCB));
			break;
		default:
			break;
		}
		paymentDao.save(payment);
		return new PaymentResponse(payment.getFinalPrice(), payment.getPoints());

	}

	private double calulateFinalPrice(double price, double priceModifier) {
		return price * priceModifier;
	}

	private int calculatePoints(double price, double paymentPointPercentage) {
		return (int) Math.round(price * paymentPointPercentage);
	}

}
