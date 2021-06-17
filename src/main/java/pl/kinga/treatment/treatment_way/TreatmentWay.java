package pl.kinga.treatment.treatment_way;

import lombok.Getter;
import lombok.Setter;
import pl.kinga.treatment.specific.Specific;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class TreatmentWay {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "treatmentWay", cascade = CascadeType.REMOVE)
    private List<Specific> specificList;

    public TreatmentWay() {
    }

    public TreatmentWay(String name, List<Specific> specificList) {
        this.name = name;
        this.specificList = specificList;
    }

}
