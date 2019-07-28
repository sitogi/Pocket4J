package jp.sitogi.pocket.client;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import jp.sitogi.pocket.conditions.Conditions;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PocketClient {

    private static final String BASE_URL = "https://getpocket.com/v3/get";

    private final ClientInfo clientInfo;

    public PocketClient(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public void retrieveData(final Conditions conditions) throws Exception {
        final JsonFactory jsonFactory = new JsonFactory();
        final String requestJsonStr;

        try (ByteArrayOutputStream bao = new ByteArrayOutputStream()) {
            final JsonGenerator generator = jsonFactory.createGenerator(bao);

            generator.writeStartObject();
            clientInfo.appendJson(generator);
            conditions.appendJson(generator);
            generator.writeEndObject();
            generator.flush();

            requestJsonStr = new String(bao.toByteArray());
        }

        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .headers("Content-Type", "application/json; charset=UTF-8") // TODO
                .POST(BodyPublishers.ofString(requestJsonStr, UTF_8))
                .build();

        final HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString(UTF_8));
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

}
