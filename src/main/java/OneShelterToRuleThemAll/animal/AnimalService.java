package OneShelterToRuleThemAll.animal;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class AnimalService {

    private AnimalRepo animalRepo;

    public void addAnimal(Animal animal) {
        // todo umozliwic zapis wraz z id sheltera
        animalRepo.save(animal);
    }

    public Animal getById(Long id) {
        return animalRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Element o podanym id nie istnieje"));
    }

    public List<Animal> getAll() {
        return animalRepo.findAll();
    }

    public void updateAnimal(Animal animal) {
        Animal byId = this.getById(animal.getId());
        // save sam podmienia obiekt -> nie musze uzywac wczesniej delete
        animalRepo.save(animal);
    }

    public void remove(long id) {
        animalRepo.deleteById(id);
    }

    // species, sex, minAge, maxAge, minWeight, maxWeight, minHeight, maxHeight, province, city
    public List<Animal> browse(String species, String sex, String shelterName){
        List<Animal> bySpecies = animalRepo.findBySpeciesAndSex(species, sex);
        return bySpecies;
    }
}