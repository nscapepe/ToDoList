import java.util.Scanner;

class Tasks {
    String[] tasks = new String[11];
    String[] nameTasks = new String[11];
    int countNameTasks = 0;
    int countTasks = 0;

    void showTasks() {
        for (int i = 0; i < nameTasks.length - 9; i++) {
//            if (nameTasks[i] == null) {
//                System.out.print(" ");
//            } else {
                System.out.println((i + 1) + ". " + nameTasks[i] + ":\n\t" + tasks[i]);
//            }
        }
        System.out.println("ПРОВЕРКА!");
        for (int j = 0; j < nameTasks.length - 9; j++) {
            System.out.println(nameTasks[j] + ": ");
            System.out.println(tasks[j] + "\n");
        }
    }


    void newNameTasks(String newNameTask) {
        for (int i = 0; i < nameTasks.length; i++) {
            if (nameTasks[i] == null) {
                nameTasks[i] = newNameTask;
            }
        }
    }

    void newTasks(String newTask) {
            tasks[countTasks] = newTask;
            countTasks++;
            if (countTasks >= 10) {
                System.out.println("Это последняя задача которую вы можете написать.");
            }
    }

    void deleteTasks(int deleteTask) {
        for (int i = 0; i < nameTasks.length; i++) {
            if (deleteTask == (i + 1)) {
                nameTasks[i] = null;
                tasks[i] = null;
                for (int t = 0; t < nameTasks.length - 1; t++) {
                    if (nameTasks[t] == null) {
                        nameTasks[t] = nameTasks[t + 1];
                    }
                }
                for (int g = 0; g < tasks.length - 1; g++) {
                    if (tasks[g] == null) {
                        tasks[g] = tasks[g + 1];
                    }
                }
                System.out.println("Задача успешно удалена :)");
                break;
            } else {
                System.out.println("Такой задачи нету или она уже удалена :(");
                break;
            }
        }
    }
}


public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tasks callTasks = new Tasks();
        for (; ; ) {
            System.out.println("\n\t Заметки.");
            System.out.println("Действия: \n 1.  Посмотреть текущие задачи. \n 2.  Создать новую задачу. \n 3.  Удалить задачу. \n 4.  Выход. ");
            System.out.print("Введите действие: ");
            int action = Integer.parseInt(scanner.nextLine());
            switch (action) {
                case 1:
                    System.out.println("Текущие задачи:");
                    callTasks.showTasks();
                    break;
                case 2:
                    System.out.print("Напишите название для новой задачи: ");
                    String newNameTask = scanner.nextLine();
                    callTasks.newNameTasks(newNameTask);
                    System.out.print("Напишите задачу: ");
                    String newTask = scanner.nextLine();
                    callTasks.newTasks(newTask);
                    break;
                case 3:
                    System.out.print("Напишите номер задачи которую хотите удалить: ");
                    int deleteTask = Integer.parseInt(scanner.nextLine());
                    callTasks.deleteTasks(deleteTask);
                    break;
                case 4:
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