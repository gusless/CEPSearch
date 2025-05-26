package br.com.gus.functions;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnect {
    private final HttpResponse<String> response;

    public ApiConnect(String cep) throws IOException, InterruptedException {
            String cepURL = String.format("https://viacep.com.br/ws/%s/json/", cep);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(cepURL))
                    .build();
            this.response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> getResponse() {
        return response;
    }
}
