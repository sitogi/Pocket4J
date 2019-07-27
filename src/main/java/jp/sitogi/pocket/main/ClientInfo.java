package jp.sitogi.pocket.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class ClientInfo {

    private final String consumerKey;
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
        System.out.println();
        try (InputStream in = new FileInputStream(path.toFile())) {
            props.load(in);
        }
        System.out.println(props);
        return new ClientInfo(props.getProperty("consumerKey"), props.getProperty("accessToken"));
    }

}
