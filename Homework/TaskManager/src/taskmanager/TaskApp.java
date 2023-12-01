/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class TaskApp {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        if (args.length != 1) {
            System.out.println("Usage: java TaskApp <filename>");
            System.exit(0);
        }
        String filename = args[0];
        File file = new File(filename);
        if (file.createNewFile()) {
            System.out.println("New Tasks File Created!");
        } else {
            System.out.println("Using " + filename + " - existing tasks file!");
        }

        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager(filename);

        while (true) {
            System.out.println("\nTask Manager Menu:");
            System.out.println("1. Add New Task\n2. Display all tasks\n3. Remove Task\n4. Change Task Status\n5. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("Adding new Task");
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter task status: ");
                    String status = scanner.nextLine();
                    taskManager.addTask(new Task(desc, status));
                    break;
                case 2:
                    taskManager.displayTasks();
                    break;
                case 3:
                    System.out.println("Removing the task");
                    System.out.print("Enter task index to remove: ");
                    int idx = scanner.nextInt();
                    taskManager.removeTask(idx - 1);
                    break;
                case 4:
                    System.out.println("Changing task status");
                    System.out.print("Enter task index to change status: ");
                    int idxToChange = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter task status: ");
                    String statusToChange = scanner.nextLine();
                    taskManager.changeTaskStatus(idxToChange - 1, statusToChange);
                    break;
                case 5:
                    System.out.println("Exitting Task Manager...");
                    System.exit(0);
                default:
                    System.out.println("ERROR! Invalid choice! Enter 1,2,3,4 or 5!");
            }
        }
    }

}
