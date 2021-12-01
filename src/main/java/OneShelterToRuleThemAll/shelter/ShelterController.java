package OneShelterToRuleThemAll.shelter;

import OneShelterToRuleThemAll.animal.Animal;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping(ShelterController.PATH)
public class ShelterController {
    private ShelterService shelterService;

    public static final String PATH = "/api/shelters/";

    @PostMapping
    public ResponseEntity<Shelter> add(@RequestBody Shelter shelter) {
        shelterService.addShelter(shelter);
        return ResponseEntity
                .created(URI.create(PATH + shelter.getId()))
                .body(shelter);
    }

    @GetMapping("{id}")
    public ResponseEntity<Shelter> get(@PathVariable long id) {
        try {
            return ResponseEntity.ok(shelterService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().header("error", e.getLocalizedMessage()).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Shelter>> getAll() {
        return ResponseEntity.ok(shelterService.getAll());
    }

    @PostMapping("{id}")
    public ResponseEntity<Shelter> update(@RequestBody Shelter shelter, @PathVariable long id) {
        shelter.setId(id);
        shelterService.update(shelter);
        return ResponseEntity.ok(shelter);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        shelterService.remove(id);
        return ResponseEntity.noContent().build();
    }

    // 1. za pomocą metod add ktore juz mamy dodac animala i schronisko
    // 2. wywolac metode z sheltera ktory wiaze animala i sheltera po id
    @PostMapping("{shelterId}/animals/")
    public void addAnimalToShelter(@PathVariable long shelterId, @RequestBody Animal animal){
        shelterService.addAnimalToShelter(shelterId, animal);
    }
}
