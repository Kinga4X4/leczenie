package pl.kinga.treatment.specific;

import pl.kinga.treatment.treatment_way.TreatmentWay;

import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public TreatmentWay getTreatmentWay() {
        return treatmentWay;
    }

    public void setTreatmentWay(TreatmentWay treatmentWay) {
        this.treatmentWay = treatmentWay;
    }

    @Override
    public String toString() {
        return id + name + unit + quantity + dosage + treatmentWay;
    }
}


