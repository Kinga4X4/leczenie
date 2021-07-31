package pl.kinga.treatment.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/weather")
    public String showWeather(@RequestParam(name="city") String city, Model model) {
        model.addAttribute("city", weatherService.weatherResponse(city));
        return "weather";
    }

    @ExceptionHandler(RuntimeException.class)
    public String HandleExeption() {
        return "nodata";
    }

}
