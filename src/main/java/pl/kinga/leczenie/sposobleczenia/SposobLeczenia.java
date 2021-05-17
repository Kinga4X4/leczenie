package pl.kinga.leczenie.sposobleczenia;
import pl.kinga.leczenie.specyfik.Specyfik;
import javax.persistence.*;
import java.util.List;

@Entity
public class SposobLeczenia {
    @Id
    @GeneratedValue
    private Long id;
    private String nazwa;
    @OneToMany(mappedBy = "sposobLeczenia", cascade = CascadeType.REMOVE)
    private List<Specyfik> specyfikList;

    public SposobLeczenia() {
    }

    public SposobLeczenia(String nazwa, List<Specyfik> specyfikList) {
        this.nazwa = nazwa;
        this.specyfikList = specyfikList;
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

    public List<Specyfik> getSpecyfikList() {
        return specyfikList;
    }

    public void setSpecyfikList(List<Specyfik> specyfikList) {
        this.specyfikList = specyfikList;
    }
}
