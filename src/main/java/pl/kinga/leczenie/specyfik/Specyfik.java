package pl.kinga.leczenie.specyfik;

import pl.kinga.leczenie.Jednostka;
import pl.kinga.leczenie.sposobleczenia.SposobLeczenia;

import javax.persistence.*;

@Entity
public class Specyfik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazwa;

    @Enumerated(EnumType.STRING)
    private Jednostka jednostka;
    private double ilosc;
    private String dawkowanie;
    @ManyToOne
    private SposobLeczenia sposobLeczenia;

    public Specyfik(String nazwa, Jednostka jednostka, double ilosc, String dawkowanie, SposobLeczenia sposobLeczenia) {
        this.nazwa = nazwa;
        this.jednostka = jednostka;
        this.ilosc = ilosc;
        this.dawkowanie = dawkowanie;
        this.sposobLeczenia = sposobLeczenia;
    }

    public Specyfik() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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

    @Override
    public String toString() {
        return id + nazwa +  jednostka + ilosc + dawkowanie + sposobLeczenia;
    }
}


