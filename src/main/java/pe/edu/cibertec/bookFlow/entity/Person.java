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
    private String address;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "type_document_id")
    @ToString.Exclude
    private TypeDocument typeDocument;

    @OneToMany(mappedBy = "person")
    @ToString.Exclude
    private List<Loan> loans;

}
