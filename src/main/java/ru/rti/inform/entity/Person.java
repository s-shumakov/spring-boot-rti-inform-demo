package ru.rti.inform.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long personId1c;

    private String lastName;

    private String firstName;

    private String midlleName;

    private String tabNum;

    @Email
    private String email;

    private LocalDate birthDate;

    private LocalDate hireDate;

    private LocalDate fireDate;

    private String phone;

    @ManyToOne()
    @JoinColumn(name = "gradeId")
    private Grade grade;

    @ManyToOne()
    @JoinColumn(name = "structId")
    private Struct struct;

    @ManyToOne()
    @JoinColumn(name = "positionId")
    private Position position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTabNum() {
        return tabNum;
    }

    public void setTabNum(String tabNum) {
        this.tabNum = tabNum;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidlleName() {
        return midlleName;
    }

    public void setMidlleName(String midlleName) {
        this.midlleName = midlleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getFireDate() {
        return fireDate;
    }

    public void setFireDate(LocalDate fireDate) {
        this.fireDate = fireDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getPersonId1c() {
        return personId1c;
    }

    public void setPersonId1c(Long personId1c) {
        this.personId1c = personId1c;
    }
}
