package OneShelterToRuleThemAll.animal;

import OneShelterToRuleThemAll.shelter.Shelter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "animals")
@Getter
@Setter
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String species;
    private String race;
    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String sex;
    private Double weight;
    private Double height;
    private String description;
    @ManyToOne
    private Shelter shelter;

    @PersistenceConstructor
    Animal() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", species='" + species + '\'' +
                ", race='" + race + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id.equals(animal.id) && name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
