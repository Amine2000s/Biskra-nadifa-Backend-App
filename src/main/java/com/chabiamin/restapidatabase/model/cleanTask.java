package com.chabiamin.restapidatabase.model;

import jakarta.persistence.*;

import java.sql.Driver;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name="clean-task")
public class cleanTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="assignedID")
    private driver Assigneddriver ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="assignerID")
    private systemUser AssingerSystemUser ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reportID")
    private Report report ;
    @Column(name="task-status")
    String status ;

    @Column(name="created-at")
    java.time.LocalDateTime createdAt ;

    @Column(name="finished-at")
    java.time.LocalDateTime finishedAt ;


    public cleanTask() {
    }

    public cleanTask(int reportid , int assinerid , int assignedid ) {

        /*this.report.setId(reportid);
        this.AssingerSystemUser.setId(assinerid);
        this.Assigneddriver.setId(assignedid);
*/

    }

    public cleanTask(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public driver getAssigneddriver(Optional<driver> driver1) {
        return Assigneddriver;
    }

    public void setAssigneddriver(driver assigneddriver) {
        Assigneddriver = assigneddriver;
    }
    public void setAssigneddriver(Optional<driver> assigneddriver) {
                driver driverobject = assigneddriver.get();
        Assigneddriver = driverobject;
    }

    public systemUser getAssingerSystemUser() {
        return AssingerSystemUser;
    }

    public void setAssingerSystemUser(systemUser assingerSystemUser) {
        AssingerSystemUser = assingerSystemUser;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }
}
