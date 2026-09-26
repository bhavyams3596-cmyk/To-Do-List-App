import java.util.ArrayList;
import java.util.Scanner;

// Task class - oka single task ni represent chestundi
class Task {
    String name;
    boolean isCompleted;

    Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }
}

public class TodoListApp {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== TO-DO LIST APP =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // buffer clear cheyadam kosam

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    tasks.add(new Task(taskName));
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\n--- Your Tasks ---");
                        for (int i = 0; i < tasks.size(); i++) {
                            Task t = tasks.get(i);
                            String status = t.isCompleted ? "[Completed]" : "[Pending]";
                            System.out.println((i + 1) + ". " + t.name + " " + status);
                        }
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to mark complete.");
                    } else {
                        System.out.print("Enter task number to mark as complete: ");
                        int completeIndex = scanner.nextInt() - 1;
                        if (completeIndex >= 0 && completeIndex < tasks.size()) {
                            tasks.get(completeIndex).isCompleted = true;
                            System.out.println("Task marked as complete!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to delete.");
                    } else {
                        System.out.print("Enter task number to delete: ");
                        int deleteIndex = scanner.nextInt() - 1;
                        if (deleteIndex >= 0 && deleteIndex < tasks.size()) {
                            tasks.remove(deleteIndex);
                            System.out.println("Task deleted successfully!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you for using To-Do List App!");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         