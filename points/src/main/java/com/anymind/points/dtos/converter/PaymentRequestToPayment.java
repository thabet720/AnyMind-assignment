package com.anymind.points.dtos.converter;

import com.anymind.points.dtos.request.PaymentRequest;
import com.anymind.points.entities.Payment;
import com.anymind.points.utils.DateTimeUtil;

import java.text.ParseException;

import org.springframework.core.convert.converter.Converter;

public class PaymentRequestToPayment implements Converter<PaymentRequest, Payment> {

	@Override
	public Payment convert(PaymentRequest source) {
		
		Payment to = new Payment();
		try {
			to.setPaymentDate(DateTimeUtil.getTimestampFromString(source.getDatetime(), "yyyy-MM-dd'T'hh:mm:ss'z'"));
			to.setPaymentMethod(source.getPaymentMethod());
			to.setPrice(source.getPrice());
			to.setPriceModifier(source.getPriceModifier());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return to;
		
	}

}
