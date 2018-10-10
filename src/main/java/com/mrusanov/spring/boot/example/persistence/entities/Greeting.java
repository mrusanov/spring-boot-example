package com.mrusanov.spring.boot.example.persistence.entities;

import javax.persistence.*;
import java.util.Objects;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greeting greeting = (Greeting) o;
        return Objects.equals(id, greeting.id) &&
                Objects.equals(name, greeting.name) &&
                Objects.equals(message, greeting.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, message);
    }

}
