package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import websocket.SocketDataContainer;
import websocket.SocketClient;
import websocket.models.StatesListModel;
import websocket.models.StatesListRequestModel;

import java.io.File;

import static utility.Utility.*;

public class StatesListTest {
    private SocketClient socketClient;
    private SocketDataContainer data;

    @BeforeMethod
    public void setUpData() {
        StatesListRequestModel request = new StatesListRequestModel();
        request.setStates_list("id");

        data = new SocketDataContainer("wss://ws.derivws.com/websockets/v3?app_id=1089");
        data.setBody(serializeToString(request));
        data.setTimeout(5);
        socketClient = new SocketClient(data);
    }

    @Test(description = "States list")
    public void statesListTest() {
        socketClient.communicate();
        StatesListModel actualResponse = deserializeStringToObject(data.getMessage(), StatesListModel.class);
        StatesListModel expectedResponse = deserializeFileContentToObject(new File(RESOURCE_FOLDER + "statesList.json"), StatesListModel.class);
        Assert.assertEquals(actualResponse.getStates_list(), expectedResponse.getStates_list(), "States list is incorrect");
    }
}
