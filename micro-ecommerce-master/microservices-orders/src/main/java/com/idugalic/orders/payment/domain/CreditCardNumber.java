package com.idugalic.orders.payment.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class CreditCardNumber {

	private static final String regex = "[0-9]{16}";

	@Column(unique = true)
	private String number;


	public CreditCardNumber(String number) {

		if (!isValid(number)) {
			throw new IllegalArgumentException(String.format("Invalid credit card NUMBER %s!", number));
		}

		this.number = number;
	}

	public CreditCardNumber() {
		super();
	}


	public static boolean isValid(String number) {
		return number == null ? false : number.matches(regex);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
