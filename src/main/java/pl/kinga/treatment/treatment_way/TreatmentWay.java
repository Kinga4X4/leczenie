package pl.kinga.treatment.treatment_way;
import pl.kinga.treatment.specific.Specific;

import javax.persistence.*;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nazwa) {
        this.name = nazwa;
    }

    public List<Specific> getSpecificList() {
        return specificList;
    }

    public void setSpecificList(List<Specific> specificList) {
        this.specificList = specificList;
    }
}
