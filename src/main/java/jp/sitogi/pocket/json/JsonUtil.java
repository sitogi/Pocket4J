package jp.sitogi.pocket.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private JsonUtil() {
    }

    public static <T> T toObj(final String body, final Class<T> type) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(body, type);
    }

}
