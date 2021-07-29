package pl.kinga.treatment.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/weather")
    public String showWeather(Model model) {
        model.addAttribute("city", weatherService.weatherResponse("Warszawa"));
        return "weather";
    }

    @ExceptionHandler(RuntimeException.class)
    public String HandleExeption() {
        return "nodata";
    }

}
