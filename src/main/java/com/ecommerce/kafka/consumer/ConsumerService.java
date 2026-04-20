package com.ecommerce.kafka.consumer;

import com.ecommerce.helper.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ecommerce.kafka.event.PaymentEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConsumerService {

    private final EmailService emailService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "payment-success", groupId = "ecommerce-group")
    public void consume(String message) {
        try {
            PaymentEvent paymentEvent = objectMapper.readValue(message, PaymentEvent.class);
            log.info("kafka received: {}", paymentEvent);
            emailService.sendPaymentConfirmation(paymentEvent.getEmail(), paymentEvent.getOrderId(), paymentEvent.getAmount());
        } catch (Exception e) {
            log.error("failed to process kafka message: {}", message, e);
        }
    }
}