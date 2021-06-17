package pl.kinga.treatment.specific;

import lombok.Getter;
import lombok.Setter;
import pl.kinga.treatment.treatment_way.TreatmentWay;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Specific {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Unit unit;
    private double quantity;
    private String dosage;
    @ManyToOne
    private TreatmentWay treatmentWay;

    public Specific(String name, Unit unit, double quantity, String dosage, TreatmentWay treatmentWay) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
        this.dosage = dosage;
        this.treatmentWay = treatmentWay;
    }

    public Specific() {
    }

     @Override
    public String toString() {
        return id + name + unit + quantity + dosage + treatmentWay;
    }
}


