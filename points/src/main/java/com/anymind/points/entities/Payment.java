package com.anymind.points.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Payment{
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private double price;
	private double priceModifier;
	private double finalPrice;
	private int points;
	private String paymentMethod;
	private Timestamp paymentDate;
	
	
	public Payment(double price, double priceModifier, double finalPrice, int points, String paymentMethod,
			Timestamp paymentDate) {
		super();
		this.price = price;
		this.priceModifier = priceModifier;
		this.finalPrice = finalPrice;
		this.points = points;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
	}
	public Payment() {

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
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	

}
