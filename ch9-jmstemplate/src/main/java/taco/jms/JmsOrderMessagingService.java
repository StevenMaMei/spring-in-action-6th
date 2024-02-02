package taco.jms;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import taco.jms.model.TacoOrder;

@Service
public class JmsOrderMessagingService implements OrderMessagingService{
    private JmsTemplate jmsTemplate;

    @Autowired
    public JmsOrderMessagingService(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendOrder(final TacoOrder order) {

        // The default destination would be used (specified in the properties)
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(final Session session) throws JMSException {
                return session.createObjectMessage(order);
            }
        });
    }
}
