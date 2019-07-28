package jp.sitogi.pocket.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.sitogi.pocket.client.ClientInfo;
import jp.sitogi.pocket.conditions.Conditions;

public class JsonUtil {

    private JsonUtil() {
    }

    public static String clientInfoToJson(ClientInfo clientInfo) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(clientInfo);
    }

    public static String conditionsToJson(Conditions conditions) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(conditions);
    }




}
