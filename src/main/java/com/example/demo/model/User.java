package com.example.demo.model;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(	name = "User", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username should not be null ")
    @Column(name = "username" )
    private String username;

    @Email(message = "Please enter the valid email adress")
    @Column(name = "email", unique=true )
    private String email;

    @NotNull(message = "Age should not be null")
    @Column(name = "age")
    private int age;

    @NotNull(message = "password should not be null")
    @Column(name = "password")
    private String password;
}