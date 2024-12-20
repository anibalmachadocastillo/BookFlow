package pe.edu.cibertec.bookFlow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personGenreId;
    private String name;
}
