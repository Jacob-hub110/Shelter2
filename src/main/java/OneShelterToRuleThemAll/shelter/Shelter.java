package OneShelterToRuleThemAll.shelter;

import OneShelterToRuleThemAll.animal.Animal;
import OneShelterToRuleThemAll.shelter.address.Address;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "shelter")
@Getter
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String telNumber;
    private String email;
    private String password;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany
    private List<Animal> animals;

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }
}
