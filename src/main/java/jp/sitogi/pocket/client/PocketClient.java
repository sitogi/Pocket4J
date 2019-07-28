package jp.sitogi.pocket.client;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import jp.sitogi.pocket.conditions.Conditions;
import jp.sitogi.pocket.json.JsonUtil;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static java.nio.charset.StandardCharsets.UTF_8;
import static jp.sitogi.pocket.client.HTTPConstants.CONTENT_TYPE_JSON;
import static jp.sitogi.pocket.client.HTTPConstants.HTTP_OK;
import static jp.sitogi.pocket.client.HTTPConstants.KEY_CONTENT_TYPE;

public class PocketClient {

    private static final String BASE_URL = "https://getpocket.com/v3/get";

    private final ClientInfo clientInfo;

    public PocketClient(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public RetrievedResult retrieveData(final Conditions conditions) throws Exception {
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
                .headers(KEY_CONTENT_TYPE, CONTENT_TYPE_JSON)
                .POST(BodyPublishers.ofString(requestJsonStr, UTF_8))
                .build();

        final HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString(UTF_8));

        if (response.statusCode() != HTTP_OK) {
            throw new Exception("HTTP Status Code: " + response.statusCode());
        }

        return JsonUtil.toObj(response.body(), RetrievedResult.class);
    }

}
