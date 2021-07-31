package pl.kinga.treatment.weather;

import lombok.Data;

@Data
public class OpenWeatherDto {
    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;

}
