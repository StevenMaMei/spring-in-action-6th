package taco.email;

import org.springframework.integration.core.GenericHandler;
import org.springframework.messaging.MessageHeaders;

public class OrderSubmitMessageHandler implements GenericHandler<EmailOrder> {
    @Override
    public Object handle(final EmailOrder payload, final MessageHeaders headers) {
        // if returns null, then it means that this handler is the end of the flow
        return null;
    }
}
