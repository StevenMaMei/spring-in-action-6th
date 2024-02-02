package taco.jms;

import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import taco.jms.model.TacoOrder;

@Profile("jms-listener")
@Component
public class OrderListener {

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(TacoOrder order) {
        //process
    }
}
