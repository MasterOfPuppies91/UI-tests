package websocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.util.Date;

public class Client extends WebSocketClient {
    private SocketDataContainer data;
    private Date openTime;

    public Client(SocketDataContainer data) {
        super(data.getUri());
        this.data = data;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Connection opened to " + data.getUri() + ".");
        openTime = new Date();
    }

    @Override
    public void onMessage(String s) {
        System.out.println("Message received: " + s);
        data.setMessage(s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("Connection closed. Duration: " + getConnectionDuration() + " seconds.");
    }

    @Override
    public void onError(Exception e) {
    }

    public int getConnectionDuration() {
        Date currentTime = new Date();
        return Long.valueOf((currentTime.getTime() - openTime.getTime())/1000).intValue();
    }
}
