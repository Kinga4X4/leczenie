package pl.kinga.treatment.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

    @Bean
    @Autowired
    @Qualifier("weather")
    public RestTemplate restTemplate(@Value("http://api.openweathermap.org") String address) {
        return new RestTemplateBuilder()
                .rootUri(address)
                .build();
    }
}

