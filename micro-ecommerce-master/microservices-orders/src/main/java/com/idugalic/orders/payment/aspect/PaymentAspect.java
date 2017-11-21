package com.idugalic.orders.payment.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import com.idugalic.orders.order.domain.Order;
import com.idugalic.orders.payment.event.OrderPaidEvent;
import com.idugalic.orders.payment.service.PaymentService;


@Aspect
@Service
class PaymentAspect implements ApplicationEventPublisherAware, Ordered {

	private ApplicationEventPublisher publisher;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.ApplicationEventPublisherAware#
	 * setApplicationEventPublisher(org.springframework.context.
	 * ApplicationEventPublisher)
	 */
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE - 10;
	}

	/**
	 * Publishes an {@link OrderPaidEvent} for the given {@link Order}.
	 * 
	 * @param order
	 */
	@AfterReturning(value = "execution(* com.idugalic.orders.payment.service.PaymentService.pay(com.idugalic.orders.order.domain.Order, ..)) && args(order, ..)")
	public void triggerPaymentEvent(Order order) {

		if (order == null) {
			return;
		}

		this.publisher.publishEvent(new OrderPaidEvent(order.getId(), this));
	}
}
