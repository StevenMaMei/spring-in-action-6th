package taco.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import taco.kafka.model.TacoOrder;

@Component
public class OrderListener {
    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(TacoOrder tacoOrder, ConsumerRecord<String, TacoOrder> record) {
        // Record is for metadata or you could Also receive a Message to get the headers
        //process
    }

}
