package pl.kinga.leczenie.sposobleczenia;

import pl.kinga.leczenie.specyfik.Specyfik;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class SposobLeczenia {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "sposobLeczenia")
    private List<Specyfik> specyfikList;

    public SposobLeczenia() {
    }

    public SposobLeczenia(Long id, String name, List<Specyfik> specyfikList) {
        this.id = id;
        this.name = name;
        this.specyfikList = specyfikList;
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

    public List<Specyfik> getSpecyfikList() {
        return specyfikList;
    }

    public void setSpecyfikList(List<Specyfik> specyfikList) {
        this.specyfikList = specyfikList;
    }
}
