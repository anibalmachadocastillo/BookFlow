package pe.edu.cibertec.bookFlow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;
    private String firstName;
    private String lastName;
    private String documentNumber;
    private String district;
    private String address;
    private String phone;
    private Date birthDate;
    private String email;

    @ManyToOne
    @JoinColumn(name = "type_document_id")
    @ToString.Exclude
    private TypeDocument typeDocument;

    @ManyToOne
    @JoinColumn(name = "person_genre_id")
    @ToString.Exclude
    private PersonGenre personGenre;

    @OneToOne(mappedBy = "person",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = "person",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    private List<Loan> loans;

}
