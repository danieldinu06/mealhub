package com.danieldinu.mealhub.controller;

import com.danieldinu.mealhub.payload.request.PaymentRequest;
import com.danieldinu.mealhub.service.PaymentService;
import com.stripe.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/payment")
@CrossOrigin
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/coupon-validator")
    @ResponseBody
    public ResponseEntity<String> couponValidator(String code) {
        Coupon coupon = paymentService.retrieveCoupon(code);
        if (coupon != null && coupon.getValid()) {
            String details = (coupon.getPercentOff() == null ? "$" + (coupon.getAmountOff() / 100) : coupon.getPercentOff() + "%") +
                    " OFF " + coupon.getDuration();
            return new ResponseEntity<>(details, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("This coupon code is not available. This may be because it has expired or has " +
                    "already been applied to your account.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create-charge")
    @ResponseBody
    public ResponseEntity<String> createCharge(@RequestBody PaymentRequest paymentRequest) {
        if (paymentRequest.token() == null) {
            return new ResponseEntity<>("Stripe payment token is missing. Please, try again later.", HttpStatus.NOT_FOUND);
        }

        String chargeId = paymentService.createCharge(paymentRequest.email(), paymentRequest.token(), paymentRequest.amount() * 100);
        if (chargeId == null) {
            return new ResponseEntity<>("An error occurred while trying to create a charge.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Success! Your charge id is " + chargeId, HttpStatus.OK);
    }
}
