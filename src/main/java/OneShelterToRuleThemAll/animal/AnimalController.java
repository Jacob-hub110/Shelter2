package OneShelterToRuleThemAll.animal;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/animals/")
public class AnimalController {

    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
        animalService.addAnimal(animal);
        return ResponseEntity
                .created(URI.create("/api/animals/" + animal.getId()))
                .body(animal);
    }

    @GetMapping("{id}")
    public ResponseEntity<Animal> getById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(animalService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().header("error", e.getLocalizedMessage()).build();
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<Animal> updateAnimal(@RequestBody Animal animal, @PathVariable long id) {
        animal.setId(id);
        animalService.updateAnimal(animal);
        return ResponseEntity.ok(animal);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animalService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Animal>> browse(String species, String sex, String shelterName) {
        return ResponseEntity.ok(animalService.browse(species, sex, shelterName));
    }
}
