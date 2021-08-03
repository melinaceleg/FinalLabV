package com.example.demo.controller;

import com.example.demo.api.Clima;
import com.example.demo.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/clima")
public class ClimaController {

    private ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService=climaService;
    }

    @GetMapping("/ClimaNow")
public ResponseEntity<Clima> getClima() throws IOException, InterruptedException {

     return ResponseEntity.ok(climaService.getClimaNow());
}
}
