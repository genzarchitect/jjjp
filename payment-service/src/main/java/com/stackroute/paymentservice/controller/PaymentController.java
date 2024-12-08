package com.stackroute.paymentservice.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.model.PaymentDetails;
import com.stackroute.paymentservice.repository.RazorpayDetailsRepository;
import com.stackroute.paymentservice.service.RazorpayService;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v2")
//@CrossOrigin(origins = "*")
public class PaymentController {

    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecret;

    ResponseEntity<?> responseEntity;

    @Autowired
    RazorpayService paymentService;

    @Autowired
    RazorpayDetailsRepository razorpayDetailsRepository;



    @PostMapping(value = "/payment/{amount}", produces = "application/json")
    public ResponseEntity<String> createPayment(@PathVariable String amount) throws RazorpayException {
        int amt = Integer.parseInt(amount) * 100;
        RazorpayClient client = new RazorpayClient(apiKey, apiSecret);
        String receipt = RandomStringUtils.randomNumeric(6);
        JSONObject ob = new JSONObject();

        ob.put("amount", amt);
        ob.put("currency", "INR");
        ob.put("receipt", receipt);

        Order order = client.orders.create(ob);

        return ResponseEntity.ok(order.toString());
    }

    // For getting payment by order-id
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getonePayment(@PathVariable String id) {
        return new ResponseEntity<>(paymentService.findById(id), HttpStatus.OK);

    }

//    @PatchMapping("/updateorder")
//    public ResponseEntity<?> updateOrderWithBookingId(@RequestParam String id,@RequestParam String bookingId ){
//        return new ResponseEntity<>(paymentService.updateOrderWithBookingId(id, bookingId), HttpStatus.OK);
//
//    }

    @PostMapping("/savepaymentresponse")
    public ResponseEntity<?> savePaymentResponse(@RequestBody PaymentDetails paymentDetails) {
        paymentService.saveOnePayment(paymentDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/createOrder")
//    public String createOrder(@RequestBody PaymentDetails paymentDetails) {
//        String orderId = razorpayService.createOrder(paymentDetails.getAmount());
//        paymentDetails.setId(orderId);
//        razorpayDetailsRepository.save(paymentDetails);
//        return orderId;
//    }
}
