package com.idugalic.orders.engine;

import java.util.Set;

import com.idugalic.orders.order.domain.Order;


public interface InProgressAware {



	Set<Order> getOrders();
}
