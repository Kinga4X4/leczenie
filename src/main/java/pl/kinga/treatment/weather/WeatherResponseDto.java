package pl.kinga.treatment.weather;

import lombok.Data;

@Data
public class WeatherResponseDto {

    private String name;
    private Main main;

}
