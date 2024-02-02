package taco.jms;

import jakarta.jms.Destination;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import taco.jms.model.TacoOrder;

import java.util.Map;

public class MessagingConfig {
    @Bean
    public Destination orderQueue() {
        // This will create a destination, but usually you just need the destination name
        return new ActiveMQQueue("tacocloud.order.queue");
    }

    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTypeIdPropertyName("_typeId");
        Map<String, Class<?>> typeIdMappings = Map.of("order", TacoOrder.class);
        converter.setTypeIdMappings(typeIdMappings);
        return converter;
    }
}
