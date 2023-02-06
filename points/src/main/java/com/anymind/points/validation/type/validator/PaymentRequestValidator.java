package com.anymind.points.validation.type.validator;

import com.anymind.points.constants.PaymentMethod;
import com.anymind.points.constants.PaymentMethodPointsPercentage;
import com.anymind.points.dtos.request.PaymentRequest;
import com.anymind.points.validation.RuleValidator;
import com.anymind.points.validation.exception.ValidatorException;

import java.util.Arrays;
import java.util.List;


public class PaymentRequestValidator implements RuleValidator<PaymentRequest> {

	@Override
	public void validate(PaymentRequest t) throws ValidatorException {
		List<String> allowedpaymentMethods = Arrays.asList(
				PaymentMethod.AMEX,
				PaymentMethod.CASH,
				PaymentMethod.CASH_ON_DELIVERY,
				PaymentMethod.JCB,
				PaymentMethod.MASTERCARD,
				PaymentMethod.VISA
				);
		if(!allowedpaymentMethods.contains(t.getPaymentMethod())) {
			throw new ValidatorException(t.getPaymentMethod()+" is not allowed");
		}
		switch (t.getPaymentMethod()) {
		case PaymentMethod.CASH:
			if(t.getPriceModifier()>1 || t.getPriceModifier()<0.9) {
				throw new ValidatorException(t.getPriceModifier() + " is outside of expected range for "+t.getPaymentMethod()+" payment method");
			}
			break;
		case PaymentMethod.CASH_ON_DELIVERY:
			if(t.getPriceModifier()>1.02 || t.getPriceModifier()< 1) {
				throw new ValidatorException(t.getPriceModifier() + " is outside of expected range for "+t.getPaymentMethod()+" payment method");
			}
			
			break;
		case PaymentMethod.VISA:
			if(t.getPriceModifier()>1 || t.getPriceModifier()<0.95) {
				throw new ValidatorException(t.getPriceModifier() + " is outside of expected range for "+t.getPaymentMethod()+" payment method");
			}
			
			break;
		case PaymentMethod.MASTERCARD:
			if(t.getPriceModifier()>1 || t.getPriceModifier()<0.95) {
				throw new ValidatorException(t.getPriceModifier() + " is outside of expected range for "+t.getPaymentMethod()+" payment method");
			}
			
			break;
		case PaymentMethod.AMEX:
			if(t.getPriceModifier()> 1.01 || t.getPriceModifier()< 0.98) {
				throw new ValidatorException(t.getPriceModifier() + " is outside of expected range for "+t.getPaymentMethod()+" payment method");
			}
			
			break;
		case PaymentMethod.JCB:
			if(t.getPriceModifier()>1 || t.getPriceModifier()<0.95) {
				throw new ValidatorException(t.getPriceModifier() + " is outside of expected range for "+t.getPaymentMethod()+" payment method");
			}
			
			break;
		default:
			break;
		}
		
	}
	
}
