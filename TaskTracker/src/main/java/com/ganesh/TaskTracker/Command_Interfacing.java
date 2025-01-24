package com.ganesh.TaskTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.sql.Date;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Command_Interfacing implements CommandLineRunner {

    @Autowired
    TaskTrackService servent;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Namaskaram Mowa :)");

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Em kaval Mowa");
            System.out.println("1. Add a Task ");
            System.out.println("2. Remove a Task");
            System.out.println("3. Update a Task ");
            System.out.println("4. Search a Task");
            System.out.println("5. Status of Task");
            System.out.println("6. Exit");

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    // Add a task
                    System.out.println("Enter Task Number:");
                    Long num = sc.nextLong();
                    sc.nextLine();  // Consume the newline
                    System.out.println("Enter Task Name:");
                    String task = sc.nextLine();
                    System.out.println("Enter Deadline (YYYY-MM-DD):");
                    String deadlineInput = sc.nextLine();
                    Date deadline = Date.valueOf(deadlineInput);
                    System.out.println("Enter Task Status (true for completed, false for not completed):");
                    Boolean status = sc.nextBoolean();
                    servent.addTask(num, task, deadline, status);
                    break;

                case 2:
                    // Remove a task
                    System.out.println("Enter Task Number to remove:");
                    Long taskNumToRemove = sc.nextLong();
                    System.out.println(servent.deleteTask(taskNumToRemove));
                    break;

                case 3:
                    // Update a task
                    System.out.println("Enter Task Number to update:");
                    Long taskNumToUpdate = sc.nextLong();
                    sc.nextLine();  // Consume newline
                    System.out.println("Enter new Task Name:");
                    String newTask = sc.nextLine();
                    System.out.println("Enter new Deadline (YYYY-MM-DD):");
                    String newDeadlineInput = sc.nextLine();
                    Date newDeadline = Date.valueOf(newDeadlineInput);
                    System.out.println("Enter new Task Status (true for completed, false for not completed):");
                    Boolean newStatus = sc.nextBoolean();
                    System.out.println(servent.updateTask(taskNumToUpdate, newTask, newDeadline, newStatus));
                    break;

                case 4:
                    // Search a task
                    System.out.println("Enter Task Number to search:");
                    Long taskNumToSearch = sc.nextLong();
                    TaskTrackerDb taskFound = servent.getATask(taskNumToSearch);
                    if (taskFound != null) {
                        System.out.println(taskFound);
                    } else {
                        System.out.println("Task not found!");
                    }
                    break;

                case 5:
                    // Status of Task
                    System.out.println("Enter Task Number to check status:");
                    Long taskNumToCheckStatus = sc.nextLong();
                    System.out.println(servent.taskstatus(taskNumToCheckStatus));
                    break;

                case 6:
                    // Exit
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close(); // Close the scanner to prevent memory leak
    }
}
