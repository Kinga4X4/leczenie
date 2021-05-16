package pl.kinga.leczenie.uzytkownik;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Uzytkownik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imie;
    private String nazwisko;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_urodzenia;
    private String email;
    private boolean is_newsletter;

    public Uzytkownik() {
    }

    public Uzytkownik(String imie, String nazwisko, LocalDate data_urodzenia, String email, boolean is_newsletter) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.email = email;
        this.is_newsletter = is_newsletter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public LocalDate getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(LocalDate data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_newsletter() {
        return is_newsletter;
    }

    public void setIs_newsletter(boolean is_newsletter) {
        this.is_newsletter = is_newsletter;
    }
}
