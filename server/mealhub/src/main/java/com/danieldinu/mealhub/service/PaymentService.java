package com.danieldinu.mealhub.service;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Coupon;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@NoArgsConstructor
public class PaymentService {
    @Value("${stripe.keys.secret}")
    private String API_SECRET_KEY;

    public String createCustomer(String email, String token) {
        String id = null;

        try {
            Stripe.apiKey = API_SECRET_KEY;
            Map<String, Object> customerParams = new HashMap<>();

            customerParams.put("description", "Customer for " + email);
            customerParams.put("email", email);

            customerParams.put("source", token);
            Customer customer = Customer.create(customerParams);

            id = customer.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public String createSubscription(String customerId, String plan, String coupon) {
        String id = null;

        try {
            Stripe.apiKey = API_SECRET_KEY;
            Map<String, Object> item = new HashMap<>();
            item.put("plan", plan);

            Map<String, Object> items = new HashMap<>();
            items.put("0", item);

            Map<String, Object> params = new HashMap<>();
            params.put("customer", customerId);
            params.put("items", items);

            if (!coupon.isEmpty()) {
                params.put("coupon", coupon);
            }

            Subscription subscription = Subscription.create(params);
            id = subscription.getId();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public boolean cancelSubscription(String subscriptionId) {
        boolean status;
        try {
            Stripe.apiKey = API_SECRET_KEY;
            Subscription subscription = Subscription.retrieve(subscriptionId);
            subscription.cancel();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }

    public Coupon retrieveCoupon(String code) {
        try {
            Stripe.apiKey = API_SECRET_KEY;
            return  Coupon.retrieve(code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String createCharge(String email, String token, int amount) {
        String id = null;

        try {
            Stripe.apiKey = API_SECRET_KEY;
            Map<String, Object> chargeParams = new HashMap<>();

            chargeParams.put("amount", amount);
            chargeParams.put("currency", "ron");
            chargeParams.put("description", "Charge for " + email);
            chargeParams.put("source", token);

            Charge charge = Charge.create(chargeParams);
            id = charge.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
}
