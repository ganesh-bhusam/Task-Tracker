package com.ganesh.TaskTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskTrackService {
    @Autowired
    TaskTrackRepository dbconnecter;

    public TaskTrackerDb addTask(Long num, String task, Date dl, Boolean status) {
        TaskTrackerDb addedtask = new TaskTrackerDb(num, task, dl, status);
        return dbconnecter.save(addedtask);
    }

    public List<TaskTrackerDb> getAllTasks() {
        return dbconnecter.findAll();
    }

    // Added the missing task status logic
    public String taskstatus(Long taskNum) {
        Optional<TaskTrackerDb> taskOptional = dbconnecter.findById(taskNum);
        if (taskOptional.isPresent()) {
            TaskTrackerDb task = taskOptional.get();
            return task.getStatus() ? "Task Completed :)" : "Task Not Completed Yet! :(";
        }
        return "Task not found!";
    }

    // New method to get a specific task
    public TaskTrackerDb getATask(Long taskNum) {
        Optional<TaskTrackerDb> taskOptional = dbconnecter.findById(taskNum);
        return taskOptional.orElse(null);  // Returns null if task not found
    }

    // Implementing the update task method
    public String updateTask(Long taskNum, String task, Date deadline, Boolean status) {
        Optional<TaskTrackerDb> taskOptional = dbconnecter.findById(taskNum);
        if (taskOptional.isPresent()) {
            TaskTrackerDb taskToUpdate = taskOptional.get();
            taskToUpdate.setTask(task);
            taskToUpdate.setDeadline(deadline);
            taskToUpdate.setStatus(status);
            dbconnecter.save(taskToUpdate);
            return "Updated Successfully :)";
        }
        return "Task not found!";
    }

    // Implementing the delete task method
    public String deleteTask(Long taskNum) {
        if (dbconnecter.existsById(taskNum)) {
            dbconnecter.deleteById(taskNum);
            return "Deleted Successfully :)";
        }
        return "Task not found!";
    }
}
