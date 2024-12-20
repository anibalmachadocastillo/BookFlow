package pe.edu.cibertec.bookFlow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String title;
    private String publisheYear;
    private String  genre;
    private Double price;
    private Boolean isAvailable;

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
