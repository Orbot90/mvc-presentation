package ru.mbkcapital.model;

import javax.persistence.*;

/**
 * Created by orbot on 02.04.16.
 */
@Entity
public class CoolEntity {
    @Id
    @SequenceGenerator(name = "cool_entity_generator", sequenceName = "seq_cool_entity")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String someValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSomeValue() {
        return someValue;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }
}
