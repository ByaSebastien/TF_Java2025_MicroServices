package be.bstorm.orderservice.services;

import be.bstorm.sharedservice.configs.RabbitMqConfig;
import be.bstorm.sharedservice.models.dtos.OrderEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final RabbitTemplate rabbitTemplate;

    public OrderService(@Qualifier("customRabbitTemplate") RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void createOrder() {

        OrderEvent orderEvent = new OrderEvent(
                12L,
                42
        );

        rabbitTemplate.convertAndSend(
                RabbitMqConfig.ORDER_PAYMENT_EXCHANGE,
                RabbitMqConfig.ORDER_TO_PAYMENT_ROUTING_KEY,
                orderEvent
        );

        System.out.println("Order Created wait payment");
    }
}
