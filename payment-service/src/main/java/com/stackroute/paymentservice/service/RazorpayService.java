package com.stackroute.paymentservice.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.exception.OrderCreationFailedException;
import com.stackroute.paymentservice.model.PaymentDetails;
import com.stackroute.paymentservice.repository.RazorpayDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RazorpayService implements PaymentService {

    @Autowired
    RazorpayDetailsRepository paymentDetailsRepository;

    @Override
    public PaymentDetails saveOnePayment(PaymentDetails paymentDetails) {
        return paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public PaymentDetails findById(String orderId) {
        Optional<PaymentDetails> findById= paymentDetailsRepository.findById(orderId);
        PaymentDetails paymentDetails=findById.get();
        return paymentDetails;
    }


//    @Override
//    public PaymentDetails updateOrderWithBookingId(String orderId, String bookingId) {
//        PaymentDetails payment= findById(orderId);
//        payment.setBookingId(bookingId);
//        return paymentDetailsRepository.save(payment);
//    }

}
