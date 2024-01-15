package com.devicesservicemanager.DeviceServiceManager.publisher;

import com.devicesservicemanager.DeviceServiceManager.dtos.MeasurementDeviceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.routing.device}")
    private String routingKeyDeviceId;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(MeasurementDeviceDTO measurement){
        LOGGER.info(String.format("Message sent -> %s - %s", measurement.getDeviceId(), measurement.getMaxConsumption()));
        rabbitTemplate.convertAndSend(exchange,routingKey,measurement);
    }

    public void sendMessageDeviceId(Long id){
        LOGGER.info(String.format("Message sent -> %s", id));
        rabbitTemplate.convertAndSend(exchange,routingKeyDeviceId,id);
    }
}
