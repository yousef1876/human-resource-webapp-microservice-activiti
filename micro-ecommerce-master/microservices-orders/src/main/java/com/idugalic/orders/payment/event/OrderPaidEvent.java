package com.idugalic.orders.payment.event;

import org.springframework.context.ApplicationEvent;


public class OrderPaidEvent extends ApplicationEvent {

	private static final long serialVersionUID = -6150362015056003378L;
	private final long orderId;


	public OrderPaidEvent(long orderId, Object source) {

		super(source);
		this.orderId = orderId;
	}

	public long getOrderId() {
		return orderId;
	}

}
