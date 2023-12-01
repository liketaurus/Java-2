/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexa
 */
public class TaskManager {

    private List<Task> tasks;
    private static String FILE_NAME;

    public TaskManager(String filename) throws ClassNotFoundException {
        tasks = new ArrayList<>();
        FILE_NAME = filename;
        File file = new File(filename);
        if (file.length() != 0) {
            loadTasksFromFile();
        }
    }

    public void addTask(Task task) throws IOException {
        tasks.add(task);
        saveTasksToFile();
    }

    public void removeTask(int index) throws IOException {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasksToFile();
        } else {
            System.out.println("ERROR! Invalid task index (" + index + ")!");
        }
    }

    public void displayTasks() {
        System.out.println("Current tasks:");
        System.out.println("No\tDescription\t\tStatus");
        for (Task task : tasks) {
            System.out.println(tasks.indexOf(task) + 1 + "\t" + task.getDescription() + "\t\t" + task.getStatus());
        }
    }

    public void changeTaskStatus(int index, String newStatus) throws IOException {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setStatus(newStatus);
            saveTasksToFile();
        } else {
            System.out.println("ERROR! Invalid task index (" + index + ")!");
        }
    }

    private void loadTasksFromFile() throws ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("ERROR! Can't load your tasks! " + ex.getMessage());
        }
    }

    private void saveTasksToFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
        } catch (IOException ex) {
//            System.out.println("ERROR! Can't save your tasks! " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
