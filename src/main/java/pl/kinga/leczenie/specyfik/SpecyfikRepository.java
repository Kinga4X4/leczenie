package pl.kinga.leczenie.specyfik;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kinga.leczenie.sposobleczenia.SposobLeczenia;

import java.util.List;

public interface SpecyfikRepository extends JpaRepository<Specyfik, Long> {
    List<Specyfik> findBySposobLeczenia(SposobLeczenia sposobLeczenia);
    }
