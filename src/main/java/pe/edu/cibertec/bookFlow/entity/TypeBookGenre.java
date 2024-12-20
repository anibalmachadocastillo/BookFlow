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
public class TypeBookGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeBookGenreId;
    private String name;

    @OneToMany(mappedBy = "typeBookGenre",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    public List<Book> books ;
}
