package pl.kinga.treatment.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?id=524901&lang=fr&appid=70de00867971d25bc4aefc9f49919255";

    private WeatherResponseDto getWeather() {

        RestTemplate restTemplate = new RestTemplate();

        try {
            WeatherResponseDto response = restTemplate.getForObject(URL, WeatherResponseDto.class);
            return response;

        } catch (Exception e) {
            throw new RuntimeException("Nie udało się pobrać aktualnej pogody");
        }

    }
}