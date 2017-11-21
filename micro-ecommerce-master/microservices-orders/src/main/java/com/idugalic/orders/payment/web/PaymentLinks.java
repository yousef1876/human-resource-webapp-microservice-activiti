package com.idugalic.orders.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.idugalic.orders.order.domain.Order;
import com.idugalic.orders.payment.domain.Payment;
import com.idugalic.orders.payment.domain.Payment.Receipt;


@Component
class PaymentLinks {

	static final String PAYMENT = "/payment";
	static final String RECEIPT = "/receipt";
	static final String PAYMENT_REL = "payment";
	static final String RECEIPT_REL = "receipt";

	private EntityLinks entityLinks;

	@Autowired
	public PaymentLinks(EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}


	Link getPaymentLink(Order order) {
		return entityLinks.linkForSingleResource(order).slash(PAYMENT).withRel(PAYMENT_REL);
	}


	Link getReceiptLink(Order order) {
		return entityLinks.linkForSingleResource(order).slash(RECEIPT).withRel(RECEIPT_REL);
	}
}
