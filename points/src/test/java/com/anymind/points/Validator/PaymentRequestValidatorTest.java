package com.anymind.points.Validator;

import com.anymind.points.PointsApplicationTests;
import com.anymind.points.constants.PaymentMethod;
import com.anymind.points.dtos.request.PaymentRequest;
import com.anymind.points.validation.exception.ValidatorException;
import com.anymind.points.validation.type.validator.PaymentRequestValidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaymentRequestValidatorTest extends PointsApplicationTests {
	
	private PaymentRequestValidator validator = new PaymentRequestValidator();
	
	@Test
	public void cashPaymentPriceModifierOverRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,1.02,PaymentMethod.CASH,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}
	@Test
	public void cashPaymentPriceModifierUnderRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,0.89,PaymentMethod.CASH,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}

	@Test
	public void cODPaymentPriceModifierOverRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,1.03,PaymentMethod.CASH_ON_DELIVERY,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}
	@Test
	public void cODPaymentPriceModifierUnderRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,0.9,PaymentMethod.CASH_ON_DELIVERY,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}
	@Test
	public void visaPaymentPriceModifierOverRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,1.03,PaymentMethod.VISA,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}
	@Test
	public void visaPaymentPriceModifierUnderRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,0.9,PaymentMethod.VISA,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}
	
	@Test
	public void masterCardPaymentPriceModifierOverRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,1.03,PaymentMethod.MASTERCARD,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}
	@Test
	public void masterCardPaymentPriceModifierUnderRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,0.9,PaymentMethod.MASTERCARD,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}
	@Test
	public void amexCardPaymentPriceModifierOverRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,1.02,PaymentMethod.AMEX,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}
	@Test
	public void amexCardPaymentPriceModifierUnderRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,0.97,PaymentMethod.AMEX,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}
	
	@Test
	public void jcbCardPaymentPriceModifierOverRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,1.01,PaymentMethod.JCB,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}
	@Test
	public void jcbCardPaymentPriceModifierUnderRangeTest() {
		final PaymentRequest  request = new PaymentRequest(100,0.94,PaymentMethod.JCB,"");
		ValidatorException ex= Assertions.assertThrows(ValidatorException.class, ()->{
		validator.validate(request);
		});
		Assertions.assertEquals(request.getPriceModifier() + " is outside of expected range for "+request.getPaymentMethod()+" payment method", ex.getMessage());
	}

}
