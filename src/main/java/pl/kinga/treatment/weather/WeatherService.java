package pl.kinga.treatment.weather;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("70de00867971d25bc4aefc9f49919255")
    private String API_KEY;
    private RestTemplate weatherRestTemplate;

    public WeatherService(@Qualifier("weather") RestTemplate restTemplate) {
        this.weatherRestTemplate = restTemplate;
    }

    public OpenWeatherDto weatherResponse(String city) {
        String url = "/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&lang=pl&units=metric";
        return weatherRestTemplate.getForObject(url, OpenWeatherDto.class);
    }
}
