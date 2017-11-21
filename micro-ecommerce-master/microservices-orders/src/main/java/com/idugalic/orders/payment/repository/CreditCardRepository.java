package com.idugalic.orders.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.idugalic.orders.payment.domain.CreditCard;
import com.idugalic.orders.payment.domain.CreditCardNumber;


@RepositoryRestResource(exported = false)
public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {


	CreditCard findByNumber(CreditCardNumber number);
}
