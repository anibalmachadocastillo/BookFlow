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
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    private String name;
    private String nationality;

    @OneToMany(mappedBy = "book",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    public List<Book> books ;
}
