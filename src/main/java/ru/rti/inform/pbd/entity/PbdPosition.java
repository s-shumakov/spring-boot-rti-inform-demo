package ru.rti.inform.pbd.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "IN_1C", name = "Positions_RTI")
public class PbdPosition {
    @Id
    @Column(name = "position_id")
    private Long id;

    @Column(name = "position_title")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

