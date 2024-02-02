package taco.jms;

import taco.jms.model.TacoOrder;

public interface OrderMessagingService {
    void sendOrder(TacoOrder order);
}
