package model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "LastName", nullable = false)
    private String lastName;
    @Column(name = "FirstName", nullable = false)
    private String firstName;

    public Student(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}