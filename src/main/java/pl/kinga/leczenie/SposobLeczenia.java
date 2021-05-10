package pl.kinga.leczenie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class SposobLeczenia {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany
    private List<Specyfik> specyfikList;

    public SposobLeczenia() {
    }

    public SposobLeczenia(long id, String name, List<Specyfik> specyfikList) {
        this.id = id;
        this.name = name;
        this.specyfikList = specyfikList;
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

    public List<Specyfik> getSpecyfikList() {
        return specyfikList;
    }

    public void setSpecyfikList(List<Specyfik> specyfikList) {
        this.specyfikList = specyfikList;
    }
}
