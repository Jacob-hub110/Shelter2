package OneShelterToRuleThemAll.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {
    List<Animal> findBySpeciesAndSex(String species, String sex);
}
