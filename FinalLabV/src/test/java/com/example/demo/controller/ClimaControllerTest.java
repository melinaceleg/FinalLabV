package com.example.demo.controller;

import com.example.demo.api.Clima;
import com.example.demo.service.ClimaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static com.example.demo.TestUtils.aClima;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClimaControllerTest {
    private ClimaService climaService;
    private ClimaController climaController;
    @BeforeEach
    public void SetUp()
    {
        climaService = mock(ClimaService.class);
        climaController = new ClimaController(climaService);

    }
    @Test
    public void getClimaSuccess()
    {
        try {
            when(climaService.getClimaNow()).thenReturn(aClima);
            ResponseEntity<Clima> response = climaController.getClima();
            assertEquals(HttpStatus.OK,response.getStatusCode());
            assertEquals(aClima.getCity_name(), response.getBody().getCity_name());

        } catch (IOException e) {
            Assertions.fail("No deberia arrojar exception");
        } catch (InterruptedException e) {
            Assertions.fail("No deberia arrojar exception");
        }
    }

    @Test
    public void getClimaFail() throws IOException, InterruptedException {
        when(climaService.getClimaNow()).thenThrow(Exception.class);
        assertThrows(Exception.class, ()-> climaController.getClima());
    }
}
