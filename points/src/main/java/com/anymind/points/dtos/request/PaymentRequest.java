package com.anymind.points.dtos.request;


import com.anymind.points.validation.RuleConstraint;
import com.anymind.points.validation.field.IsDateFormatValid;
import com.anymind.points.validation.type.validator.PaymentRequestValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RuleConstraint(validateBy = PaymentRequestValidator.class)
public class PaymentRequest extends BaseRequest {
	@Positive(message = "must be positive and higher than 0")
	private double price;
	@Positive(message = "must be positive and higher than 0")
	private double priceModifier;
	@NotNull(message = "must not be null")
	@NotBlank(message = "must not be empty")
	private String paymentMethod;
	@NotNull(message = "must not be null")
	@NotBlank(message = "must not be empty")
	@IsDateFormatValid(message = " has an Invalid format")
	private String datetime;
	
	

	public PaymentRequest() {
		super();
	}

	public PaymentRequest(double price, double priceModifier, String paymentMethod, String datetime) {
		super();
		this.price = price;
		this.priceModifier = priceModifier;
		this.paymentMethod = paymentMethod;
		this.datetime = datetime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceModifier() {
		return priceModifier;
	}

	public void setPriceModifier(double priceModifier) {
		this.priceModifier = priceModifier;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
