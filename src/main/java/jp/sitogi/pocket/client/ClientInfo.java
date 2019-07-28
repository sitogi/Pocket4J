package jp.sitogi.pocket.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class ClientInfo {

    @JsonProperty("consumer_key")
    private final String consumerKey;

    @JsonProperty("access_token")
    private final String accessToken;

    private ClientInfo(final String consumerKey, final String accessToken) {
        this.consumerKey = consumerKey;
        this.accessToken = accessToken;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public static ClientInfo createClientInfo(final Path path) throws IOException {
        final Properties props = new Properties();
        try (InputStream in = new FileInputStream(path.toFile())) {
            props.load(in);
        }
        return new ClientInfo(props.getProperty("consumerKey"), props.getProperty("accessToken"));
    }

    public void appendJson(JsonGenerator generator) throws IOException {
        generator.writeStringField("consumer_key", consumerKey);
        generator.writeStringField("access_token",accessToken);
    }

}
