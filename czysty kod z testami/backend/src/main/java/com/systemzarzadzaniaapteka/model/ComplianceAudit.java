package com.systemzarzadzaniaapteka.model;
import jakarta.persistence.*;
@Entity
public class ComplianceAudit {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String auditDetails;

    @ManyToOne
    private Manager conductedBy;

    public ComplianceAudit() {
    }

    public ComplianceAudit(String auditDetails, Manager conductedBy) {
        this.auditDetails = auditDetails;
        this.conductedBy = conductedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuditDetails() {
        return auditDetails;
    }

    public void setAuditDetails(String auditDetails) {
        this.auditDetails = auditDetails;
    }

    public Manager getConductedBy() {
        return conductedBy;
    }

    public void setConductedBy(Manager conductedBy) {
        this.conductedBy = conductedBy;
    }

    public void performAudit() {
        System.out.println("Audit performed: " + auditDetails +
            (conductedBy != null ? " by " + conductedBy.getName() : ""));
    }
}