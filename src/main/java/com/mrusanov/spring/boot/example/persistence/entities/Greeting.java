package com.mrusanov.spring.boot.example.persistence.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Version
    private Long version;

    @Column
    private String name;

    @Column
    private String message;

    public Greeting() {
        super();
    }

    public Greeting(String name, String message) {
        super();
        setName(name);
        setMessage(message);
    }

}
