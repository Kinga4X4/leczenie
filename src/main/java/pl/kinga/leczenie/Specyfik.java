package pl.kinga.leczenie;

import javax.persistence.*;

import java.util.List;

@Entity
public class Specyfik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Jednostka jednostka;
    private double ilosc;
    private String dawkowanie;
    @ManyToOne
    private SposobLeczenia sposobLeczenia;

    public Specyfik(long id, String name, Jednostka jednostka, double ilosc, String dawkowanie, SposobLeczenia sposobLeczenia) {
        this.id = id;
        this.name = name;
        this.jednostka = jednostka;
        this.ilosc = ilosc;
        this.dawkowanie = dawkowanie;
        this.sposobLeczenia = sposobLeczenia;
    }

    public Specyfik() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Jednostka getJednostka() {
        return jednostka;
    }

    public void setJednostka(Jednostka jednostka) {
        this.jednostka = jednostka;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    public String getDawkowanie() {
        return dawkowanie;
    }

    public void setDawkowanie(String dawkowanie) {
        this.dawkowanie = dawkowanie;
    }

    public SposobLeczenia getSposobLeczenia() {
        return sposobLeczenia;
    }

    public void setSposobLeczenia(SposobLeczenia sposobLeczenia) {
        this.sposobLeczenia = sposobLeczenia;
    }
}


