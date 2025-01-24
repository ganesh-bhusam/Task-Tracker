package com.ganesh.TaskTracker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@Entity
@Table(name = "Task_Tracker")
public class TaskTrackerDb {

    @Id
    @Column(name = "Task Number")
    Long taskNum;

    @Column(name = "Task")
    String task;
    
    @Column(name = "Dead Line")
    Date deadline;

    @Column(name = "Status")
    Boolean status;


    public TaskTrackerDb(Long taskNum, String task, Date deadline, Boolean status) {
        this.taskNum = taskNum;
        this.task = task;
        this.deadline = deadline;
        this.status = status;
    }

    public TaskTrackerDb() {}

    public Long getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(Long taskNum) {
        this.taskNum = taskNum;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        
        this.deadline = deadline;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

