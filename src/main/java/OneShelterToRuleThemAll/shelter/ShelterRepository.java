package OneShelterToRuleThemAll.shelter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
    // todo stworzyc metode pozwalająca wyszukac animala po podanym shelter name
}
