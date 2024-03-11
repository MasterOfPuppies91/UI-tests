package websocket.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatesListModel {
    private StatesListRequestModel echo_req;
    private String msg_type;
    private List<State> states_list;

    @Data
    public static class State {
        private String text;
        private String value;
    }
}
