package OneShelterToRuleThemAll.shelter;

import OneShelterToRuleThemAll.animal.Animal;
import OneShelterToRuleThemAll.animal.AnimalService;
import OneShelterToRuleThemAll.shelter.address.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class ShelterService {

    private ShelterRepository shelterRepository;
    private AnimalService animalService;
    private AddressRepository addressRepository;

    public void addShelter(Shelter shelter){
        addressRepository.save(shelter.getAddress());
        shelterRepository.save(shelter);
    }
    public Shelter getById(Long id){
        return shelterRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Element o podanym id nie istnieje"));
    }
    public List<Shelter> getAll() {
        return shelterRepository.findAll();
    }
    public void update(Shelter shelter) {
        Shelter byId = this.getById(shelter.getId());
        // save sam podmienia obiekt -> nie musze uzywac wczesniej delete
        shelterRepository.save(shelter);
    }
    public void remove(long id) {
        shelterRepository.deleteById(id);
    }

    public void addAnimalToShelter(long shelterId, Animal animal) {
        Shelter shelter = this.getById(shelterId);
        animal.setShelter(shelter);
        shelter.addAnimal(animal);
        animalService.addAnimal(animal);
        shelterRepository.save(shelter);
    }
}
