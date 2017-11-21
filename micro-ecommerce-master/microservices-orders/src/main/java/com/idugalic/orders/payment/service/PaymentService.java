package com.idugalic.orders.payment.service;

import com.idugalic.orders.order.domain.Order;
import com.idugalic.orders.payment.domain.CreditCard;
import com.idugalic.orders.payment.domain.CreditCardNumber;
import com.idugalic.orders.payment.domain.CreditCardPayment;
import com.idugalic.orders.payment.domain.Payment;
import com.idugalic.orders.payment.domain.Payment.Receipt;


public interface PaymentService {


	CreditCardPayment pay(Order order, CreditCardNumber creditCardNumber);


	Payment getPaymentFor(Order order);


	Receipt takeReceiptFor(Order order);
}
