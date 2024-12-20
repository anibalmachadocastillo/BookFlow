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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String title;
    private String publishedYear;
    private Boolean isAvailable;

    @OneToMany(mappedBy = "book",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    private List<Loan> loans ;

    @ManyToOne
    @ToString.Exclude
    private Author author;

    @ManyToOne
    @ToString.Exclude
    private Editorial editorial;

    @ManyToOne
    @ToString.Exclude
    private TypeBookGenre typeBookGenre;

}
