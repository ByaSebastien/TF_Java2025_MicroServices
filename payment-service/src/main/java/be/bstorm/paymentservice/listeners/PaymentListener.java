package be.bstorm.paymentservice.listeners;

import be.bstorm.sharedservice.configs.RabbitMqConfig;
import be.bstorm.sharedservice.models.dtos.OrderEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentListener {

    @RabbitListener(queues = {RabbitMqConfig.ORDER_QUEUE})
    public void processPayment(OrderEvent orderEvent) {

        System.out.println("Payment for " + orderEvent);
    }
}
