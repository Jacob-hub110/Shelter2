package OneShelterToRuleThemAll.shelter;

import OneShelterToRuleThemAll.animal.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
    // todo przetestować
    List<Animal> findByShelterName(String species, String sex);
}
