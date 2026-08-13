package com.devsecops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentSecurityApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void healthEndpointShouldWork() {
        String response = restTemplate.getForObject(
                "http://localhost:" + port + "/api/health",
                String.class
        );

        assertEquals("Payment service is UP", response);
    }

    @Test
    void paymentEndpointShouldWork() {
        String response = restTemplate.getForObject(
                "http://localhost:" + port + "/api/payment/123",
                String.class
        );

        assertEquals("Payment ID: 123", response);
    }

    @Test
    void customerEndpointShouldWork() {
        String response = restTemplate.getForObject(
                "http://localhost:" + port + "/api/customer/456",
                String.class
        );

        assertEquals("Customer ID: 456", response);
    }
}