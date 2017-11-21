package com.idugalic.orders.payment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.idugalic.orders.order.domain.Order;
import com.idugalic.orders.payment.domain.Payment;


@RepositoryRestResource(exported = false)
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {


	Payment findByOrder(Order order);
}
