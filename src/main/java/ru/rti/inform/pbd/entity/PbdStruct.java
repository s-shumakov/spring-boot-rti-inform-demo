package ru.rti.inform.pbd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(schema = "IN_1C", name = "Structs_RTI")
public class PbdStruct {
    @Id
    @Column(name = "Org_Id_R12")
    private Long id;

    @Column(name = "Struct_Name")
    private String name;

    @Column(name = "Struct_root_R12")
    private Long structRoot;

    @Column(name = "Struct_Parent_R12")
    private Long structParent;

    @Column(name = "Struct_Lev")
    private Integer structLev;

    @Column(name = "Id_Manager")
    private Long managerId;

    @Column(name = "Date_From")
    private LocalDate startDate;

    @Column(name = "Date_To")
    private LocalDate endDate;

    @Column(name = "active_flag")
    private boolean active;

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
