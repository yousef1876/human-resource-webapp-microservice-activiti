package com.idugalic.orders.order.web;

import org.joda.time.DateTime;
import org.springframework.data.rest.core.config.Projection;

import com.idugalic.orders.order.domain.Order;
import com.idugalic.orders.order.domain.Order.Status;


@Projection(name = "summary", types = Order.class)
public interface OrderProjection {


	DateTime getOrderedDate();


	Status getStatus();
}
