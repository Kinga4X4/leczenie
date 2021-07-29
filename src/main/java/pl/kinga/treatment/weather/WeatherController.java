package pl.kinga.treatment.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    @GetMapping("/weather")
    public String weather() {
        return "weather";
    }
    //kontroller musi wywolac metode, metoda zwroci response dto. to przekazuje do HTML


    @ExceptionHandler(RuntimeException.class)
    public String HandleExeption(){
        return "nodata";
    }

}
