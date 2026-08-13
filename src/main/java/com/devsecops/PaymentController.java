package com.devsecops;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @GetMapping("/health")
    public String health() {
        return "Payment service is UP";
    }

    @GetMapping("/payment/{id}")
    public String getPayment(@PathVariable String id) {
        return "Payment ID: " + id;
    }

    @GetMapping("/customer/{id}")
    public String getCustomer(@PathVariable String id) {
        return "Customer ID: " + id;
    }
}