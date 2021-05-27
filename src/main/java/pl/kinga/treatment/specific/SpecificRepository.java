package pl.kinga.treatment.specific;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kinga.treatment.treatment_way.TreatmentWay;

import java.util.List;

public interface SpecificRepository extends JpaRepository<Specific, Long> {
    List<Specific> findByTreatmentWay(TreatmentWay treatmentWay);
    }
