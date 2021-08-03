package com.example.demo.service;

import com.example.demo.api.Clima;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

@Service
public class ClimaService {

    public Clima getClimaNow() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weatherbit-v1-mashape.p.rapidapi.com/current?lon=38.5&lat=-78.5"))
                .header("x-rapidapi-key", "5e717d77d5msh94f939a9eec7878p149711jsn284fcd9bf865")
                .header("x-rapidapi-host", "weatherbit-v1-mashape.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Clima clima = new Gson().fromJson(response.body(),Clima.class);
        clima.setHora(LocalDateTime.now().toString());
        return clima;
    }

}
