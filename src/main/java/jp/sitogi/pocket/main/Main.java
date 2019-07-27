package jp.sitogi.pocket.main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws Exception {
        final ClientInfo clientInfo;
        try {
            clientInfo = ClientInfo.createClientInfo(Path.of(".", "accessInfo.properties"));
        } catch (Exception e) {
            throw new Exception("Failed to create client info.", e);
        }

        final HttpClient httpClient = HttpClient.newHttpClient();

        final String url = "https://getpocket.com/v3/get?consumer_key=" + clientInfo.getConsumerKey() + "&access_token="
                + clientInfo.getAccessToken() + "&state=all";

        final HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
                .headers("Content-Type", "application/json; charset=UTF-8", "X-Accept", "application/json").GET()
                .build();

        final HttpResponse<String> response = httpClient
                .send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

}
