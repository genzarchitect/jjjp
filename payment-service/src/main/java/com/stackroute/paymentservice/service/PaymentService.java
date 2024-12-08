package com.stackroute.paymentservice.service;

import com.stackroute.paymentservice.model.PaymentDetails;

public interface PaymentService  {
    PaymentDetails saveOnePayment(PaymentDetails paymentDetails);

   // PaymentDetails updateOrderWithBookingId (String orderId, String bookingId);

    PaymentDetails findById(String orderId);
}
