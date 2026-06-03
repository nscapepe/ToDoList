import java.util.ArrayList;
import java.util.Scanner;

class Tasks {
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();
    ArrayList<Integer> completed = new ArrayList<>();

    void showTasks() {
        if (name.isEmpty()) {
            System.out.println("Задач нету :( \n");
        } else {
            for (int i = 0; i < name.size(); i++) {
                System.out.println("Задача №" + (i + 1) + ". " + name.get(i) + ":\n\t" + description.get(i));
                if (completed.get(i) == 0) {
                    System.out.println("Статус задачи: В процессе.\n");
                } else {
                    System.out.println("Статус задачи: Выполнена.\n ");
                }
            }
        }
    }


    void addNameTask(String newNameTask) {
        name.add(newNameTask);
        completed.add(0);
    }

    void addTask(String newTask) {
        description.add(newTask);
    }

    void deleteTask(int deleteTask) {
        if (name.get(deleteTask - 1).isEmpty()) {
            System.out.println("Такой задачи нету.");
        } else {
            name.remove(deleteTask - 1);
            description.remove(deleteTask - 1);
            completed.remove(deleteTask - 1);
            System.out.println("Задача успешно удалена :)");
        }
    }

    void markAsCompleted(int markAsCompleted) {
        if (name.get(markAsCompleted - 1).isEmpty()) {
            System.out.println("Такой задачи нету");
        } else {
            completed.set(markAsCompleted - 1, 1);
            System.out.println("Теперь " + markAsCompleted + " задача отмечена выполненной." );
        }
    }
}


public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tasks callTasks = new Tasks();
        for (; ; ) {
            System.out.println("\n\t Заметки.");
            System.out.println("Действия: \n 1.  Посмотреть текущие задачи. \n 2.  Создать новую задачу. \n 3.  Удалить задачу. \n 4.  Отметить задачу выполненной. \n 5.  Выход. ");
            System.out.print("Введите действие: ");
            // СДЕЛАТЬ TRY\CATCH !!!
            int action = Integer.parseInt(scanner.nextLine());
            switch (action) {
                case 1:
                    System.out.println("Текущие задачи:");
                    callTasks.showTasks();
                    break;
                case 2:
                    System.out.print("Напишите название для новой задачи: ");
                    String newNameTask = scanner.nextLine();
                    callTasks.addNameTask(newNameTask);
                    System.out.print("Напишите задачу: ");
                    String newTask = scanner.nextLine();
                    callTasks.addTask(newTask);
                    break;
                case 3:
                    System.out.print("Напишите номер задачи которую хотите удалить: ");
                    int deleteTask = Integer.parseInt(scanner.nextLine());
                    callTasks.deleteTask(deleteTask);
                    break;
                case 4:
                    System.out.print("Напишите номер задачи которую хотите отметить выполненной: ");
                    int markAsCompleted = Integer.parseInt(scanner.nextLine());
                    callTasks.markAsCompleted(markAsCompleted);
                    break;
                case 5:
                    System.out.println("Закрываем приложение...");
                    break;
                default:
                    System.out.println("Такого выбора нету, попробуйте еще раз");
            }
            if (action == 5) {
                break;
            }
        }
    }
}