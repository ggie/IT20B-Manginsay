import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class TodoListManager {
    private LinkedList<String> todoList = new LinkedList<>();
    private LinkedList<String> completedTasks = new LinkedList<>();
    private Stack<String> undoStack = new Stack<>();

    public static void main(String[] args) {
        TodoListManager manager = new TodoListManager();
        manager.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- To-Do List Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Undo");
            System.out.println("4. View To-Do List");
            System.out.println("5. View Completed Tasks");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    markTaskAsDone(scanner);
                    break;
                case 3:
                    undo();
                    break;
                case 4:
                    viewTodoList();
                    break;
                case 5:
                    viewCompletedTasks();
                    break;
                case 6:
                    System.out.println("Exiting the To-Do List Manager. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void addTask(Scanner scanner) {
        System.out.print("Enter a task to add: ");
        String task = scanner.nextLine();
        todoList.add(task);
        undoStack.push("add:" + task);
        System.out.println("Task added: " + task);
    }

    private void markTaskAsDone(Scanner scanner) {
        if (todoList.isEmpty()) {
            System.out.println("No tasks in the to-do list.");
            return;
        }
        System.out.println("\n--- To-Do List ---");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }

        System.out.print("Enter the number of the task to mark as done: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < todoList.size()) {
            String task = todoList.remove(index);
            completedTasks.add(task);
            undoStack.push("done:" + task);
            System.out.println("Task marked as done: " + task);
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        String lastAction = undoStack.pop();
        String[] actionParts = lastAction.split(":", 2);
        String actionType = actionParts[0];
        String task = actionParts[1];

        if (actionType.equals("add")) {
            todoList.remove(task);
            System.out.println("Undo add: Task removed - " + task);
        } else if (actionType.equals("done")) {
            completedTasks.remove(task);
            todoList.add(task);
            System.out.println("Undo mark as done: Task moved back to to-do list - " + task);
        }
    }

    private void viewTodoList() {
        System.out.println("\n--- Current To-Do List ---");
        if (todoList.isEmpty()) {
            System.out.println("No tasks in the to-do list.");
        } else {
            for (String task : todoList) {
                System.out.println("- " + task);
            }
        }
    }

    private void viewCompletedTasks() {
        System.out.println("\n--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            for (String task : completedTasks) {
                System.out.println("- " + task);
            }
        }
    }
}
