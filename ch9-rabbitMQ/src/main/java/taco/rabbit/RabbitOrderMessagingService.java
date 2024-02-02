package taco.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taco.rabbit.model.TacoOrder;

@Service
public class RabbitOrderMessagingService {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitOrderMessagingService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(TacoOrder order) {
        MessageConverter converter = rabbitTemplate.getMessageConverter();
        MessageProperties props = new MessageProperties();
        props.setHeader("X_ORDER_SOURCE", "WEB");
        Message message = converter.toMessage(order,props);
        rabbitTemplate.send("tacocloud.order", message);
    }
}
