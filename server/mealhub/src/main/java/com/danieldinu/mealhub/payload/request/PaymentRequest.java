package com.danieldinu.mealhub.payload.request;

public record PaymentRequest(String email, String token, int amount) {
}
