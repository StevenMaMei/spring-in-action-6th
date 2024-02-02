package taco.jms;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import taco.jms.model.TacoOrder;

@Component
public class JmsOrderReceiver {

    private JmsTemplate jmsTemplate;
    private MessageConverter converter;

    @Autowired
    public JmsOrderReceiver(final JmsTemplate jmsTemplate, final MessageConverter converter) {
        this.jmsTemplate = jmsTemplate;
        this.converter = converter;
    }

    public TacoOrder receiveOrder() throws JMSException {
        Message message = jmsTemplate.receive("tacocloud.order.queue");
        return (TacoOrder) converter.fromMessage(message);
    }
}
