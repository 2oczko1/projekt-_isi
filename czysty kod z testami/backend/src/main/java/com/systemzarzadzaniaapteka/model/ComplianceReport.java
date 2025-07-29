
package com.systemzarzadzaniaapteka.model;
import jakarta.persistence.*;

@Entity
public class ComplianceReport {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issue;

    @ManyToOne
    private Pharmacist reportedBy;

    public ComplianceReport() {
    }

    public ComplianceReport(String issue, Pharmacist reportedBy) {
        this.issue = issue;
        this.reportedBy = reportedBy;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Pharmacist getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(Pharmacist reportedBy) {
        this.reportedBy = reportedBy;
    }

    public void submitReport() {
        System.out.println("Compliance report submitted: " + issue +
            (reportedBy != null ? " by " + reportedBy.getName() : ""));
    }
}