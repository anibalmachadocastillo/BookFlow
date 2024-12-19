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
public class TypeDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeDocumentId;
    private String name;

    @OneToOne(mappedBy = "type_document",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    private Person person;
}
