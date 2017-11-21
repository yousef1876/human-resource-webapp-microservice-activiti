package com.idugalic.orders.payment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import com.idugalic.orders.order.domain.Order;


@Component
class PaymentOrderResourceProcessor implements ResourceProcessor<Resource<Order>> {

	private PaymentLinks paymentLinks;

	@Autowired
	public PaymentOrderResourceProcessor(PaymentLinks paymentLinks) {
		super();
		this.paymentLinks = paymentLinks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.hateoas.ResourceProcessor#process(org.springframework
	 * .hateoas.ResourceSupport)
	 */
	@Override
	public Resource<Order> process(Resource<Order> resource) {

		Order order = resource.getContent();

		if (!order.isPaid()) {
			resource.add(paymentLinks.getPaymentLink(order));
		}

		if (order.isReady()) {
			resource.add(paymentLinks.getReceiptLink(order));
		}

		return resource;
	}

	public PaymentLinks getPaymentLinks() {
		return paymentLinks;
	}

	public void setPaymentLinks(PaymentLinks paymentLinks) {
		this.paymentLinks = paymentLinks;
	}

}
