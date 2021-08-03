package com.example.demo.api;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clima {
    private String hora;
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("alerts")
    private List<String> alerts;
    @SerializedName("city_name")
    private String city_name;
}
