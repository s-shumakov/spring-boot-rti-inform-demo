package ru.rti.inform.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Struct {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long structId1c;

    private String name;

    private Long structRoot;

    private Long structParent;

    private Integer structLev;

    private Long managerId;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStructId1c() {
        return structId1c;
    }

    public void setStructId1c(Long structId1c) {
        this.structId1c = structId1c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStructRoot() {
        return structRoot;
    }

    public void setStructRoot(Long structRoot) {
        this.structRoot = structRoot;
    }

    public Long getStructParent() {
        return structParent;
    }

    public void setStructParent(Long structParent) {
        this.structParent = structParent;
    }

    public Integer getStructLev() {
        return structLev;
    }

    public void setStructLev(Integer structLev) {
        this.structLev = structLev;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
