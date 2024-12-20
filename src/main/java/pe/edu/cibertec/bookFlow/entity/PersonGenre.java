package pe.edu.cibertec.bookFlow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personGenreId;
    private String name;

    @OneToMany(mappedBy = "personGenre")
    @ToString.Exclude
    private List<Person> persons;
}
