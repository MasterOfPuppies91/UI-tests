package websocket;

public class SocketClient {
    private final Client client;
    private final SocketDataContainer data;

    public SocketClient(SocketDataContainer data) {
        this.data = data;
        client = new Client(data);
    }

    public void communicate() {
        boolean isBodySent = false;
        try {
            client.connectBlocking();
            while(!client.isClosed()) {
                if(client.getConnectionDuration() >= data.getTimeout()) {
                    client.closeConnection(1000, "Timeout.");
                }
                if(data.getBody() != null && !isBodySent) {
                    client.send(data.getBody());
                    isBodySent = true;
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
