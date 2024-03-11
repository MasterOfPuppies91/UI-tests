package websocket;

import lombok.Data;

import java.net.URI;
import java.net.URISyntaxException;

@Data
public class SocketDataContainer {
    private URI uri;
    private String message;
    private String body;
    private int timeout;

    public SocketDataContainer(String uri) {
        try {
            this.uri = new URI(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
