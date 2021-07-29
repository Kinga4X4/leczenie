package pl.kinga.treatment.weather;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Weather {

    private String name;
    private String degrees;
}
