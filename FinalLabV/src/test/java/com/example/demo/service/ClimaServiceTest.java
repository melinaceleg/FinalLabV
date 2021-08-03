package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.net.URI;

public class ClimaServiceTest {
    private ClimaService climaService;

    @BeforeEach
    public void SetUp()
    {
        climaService = new ClimaService();
    }

    @Test
    public void getClimaSuccess()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("https://weatherbit-v1-mashape.p.rapidapi.com/current?lon=38.5&lat=-78.5");


    }
}
