package ru.rti.inform.pbd.entity;

import javax.persistence.*;

@Entity
@Table(schema = "IN_1C", name = "Assignments_RTI")
public class PbdAssignment {
    @Id
    @Column(name = "assignment_id")
    private Long id;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "position_id")
    private Long positionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }
}
