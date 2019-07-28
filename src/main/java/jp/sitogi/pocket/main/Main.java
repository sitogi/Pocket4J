package jp.sitogi.pocket.main;

import jp.sitogi.pocket.conditions.Conditions;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;
import static jp.sitogi.pocket.conditions.Count.to;
import static jp.sitogi.pocket.conditions.Domain.of;

public class Main {

    private static final String BASE_URL = "https://getpocket.com/v3/get";

    public static void main(String[] args) throws Exception {
        final ClientInfo clientInfo = ClientInfo.createClientInfo(Path.of(".", "accessInfo.properties"));

        final Conditions conditions = Conditions.defaultConditions()
                .domain(of("publickey"))
                .count(to(1));

        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + clientInfo.toQueryStr() + conditions.toQueryStr()))
                .headers("Content-Type", "application/json; charset=UTF-8", "X-Accept", "application/json")
                .GET()
                .build();

        final HttpClient httpClient = HttpClient.newHttpClient();
        final HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString(UTF_8));

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

}
