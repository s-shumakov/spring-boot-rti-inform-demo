package ru.rti.inform.pbd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table(schema = "IN_1C", name = "CMS.Persons_RTI_1C")
public class PbdPerson {
    @Id
    @Column(name = "person_id_1C")
    private Long id;

    @Column(name = "SurName")
    private String lastName;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "PatronymicName")
    private String middleName;

    @Column(name = "Sex")
    private String sex;

    @Column(name = "Assignment_Number")
    private String tabNum;

    @Column(name = "Position_Title")
    private String position;

    @Column(name = "Org_Id_R12")
    private Long orgId;

    @Column(name = "Org_Name")
    private String orgName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "Date_Hire")
    private LocalDate hireDate;

    @Column(name = "Date_Fire")
    private LocalDate fireDate;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Phone_Inner")
    private String phoneInner;

    @Column(name = "Phone_Cell")
    private String phoneCell;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "active_flag")
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTabNum() {
        return tabNum;
    }

    public void setTabNum(String tabNum) {
        this.tabNum = tabNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getPhoneInner() {
        return phoneInner;
    }

    public void setPhoneInner(String phoneInner) {
        this.phoneInner = phoneInner;
    }

    public String getPhoneCell() {
        return phoneCell;
    }

    public void setPhoneCell(String phoneCell) {
        this.phoneCell = phoneCell;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
