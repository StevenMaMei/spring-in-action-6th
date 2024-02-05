package taco.integration;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInChannel")
// Tells spring to generate implementation of this interface
// and all the result from calls should be snet to textInChannel
public interface FileWriterGateway {
    // @Header tells that the value of filename should be added as a header
    void writeToFile(
        @Header (FileHeaders.FILENAME) String filename,
        String data );
}
