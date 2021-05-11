package pl.kinga.leczenie.sposobleczenia;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kinga.leczenie.specyfik.Specyfik;

public interface SposobLeczeniaRepository extends JpaRepository<SposobLeczenia, Long> {
}
