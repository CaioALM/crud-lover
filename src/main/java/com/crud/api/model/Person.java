package com.crud.api.model;

import java.util.Date;

import com.crud.api.dto.PersonDTO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Person {
    
    public Person(PersonDTO data ) {
        this.name = data.name();
        this.lastname = data.lastname();
        this.bithdate = data.birthdate();
        this.email = data.email();
        this.phone = data.phone();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Date bithdate;

    @Column(length = 100, nullable = false)
    private String email;
}
