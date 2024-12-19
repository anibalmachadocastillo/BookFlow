package pe.edu.cibertec.bookFlow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

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

    @OneToOne(mappedBy = "type_document",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    private TypeDocument typeDocument;

    @OneToOne(mappedBy = "book",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    private User user;

}
