import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            choice = getIntegerInput("Enter your choice: ");

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> removeTask();
                case 4 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    private static void showMenu() {
        System.out.println("\n===== To-Do List Menu =====");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Exit");
        System.out.println("============================");
    }

    private static void addTask() {
        System.out.print("Enter task to add: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Your Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        System.out.println("Choose removal method:");
        System.out.println("1. By Index");
        System.out.println("2. By Name");
        int method = getIntegerInput("Enter your choice: ");

        switch (method) {
            case 1 -> {
                viewTasks();
                int index = getIntegerInput("Enter task index to remove: ");
                if (index >= 1 && index <= tasks.size()) {
                    tasks.remove(index - 1);
                    System.out.println("Task removed.");
                } else {
                    System.out.println("Invalid index.");
                }
            }
            case 2 -> {
                System.out.print("Enter task name to remove: ");
                String name = scanner.nextLine();
                if (tasks.remove(name)) {
                    System.out.println("Task removed.");
                } else {
                    System.out.println("Task not found.");
                }
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    private static int getIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
