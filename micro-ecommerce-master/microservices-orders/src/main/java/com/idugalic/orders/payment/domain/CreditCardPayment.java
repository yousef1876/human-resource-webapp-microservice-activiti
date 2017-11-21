package com.idugalic.orders.payment.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.util.Assert;

import com.idugalic.orders.order.domain.Order;


@Entity
public class CreditCardPayment extends Payment {

	@ManyToOne
	private CreditCard creditCard;

	public CreditCardPayment() {
		super();
	}


	public CreditCardPayment(CreditCard creditCard, Order order) {

		super(order);
		Assert.notNull(creditCard);
		this.creditCard = creditCard;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

}
