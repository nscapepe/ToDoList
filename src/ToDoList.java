import java.util.Scanner;

class Tasks {
    String[] tasks = new String[11];
    String[] nameTasks = new String[11];
    boolean[] completingTasks = new boolean[11];

    void showTasks() {
        for (int i = 0; i < nameTasks.length; i++) {
            if (nameTasks[0] == null) {
                System.out.print("Задач нету :( \n");
                break;
            }
            if (nameTasks[i] == null) {
                break;
            } else {
                System.out.println("Задача №" + (i + 1) + ". " + nameTasks[i] + ":\n\t" + tasks[i]);
                if (completingTasks[i] == false) {
                    System.out.println("\nСтатус задачи: В процессе.\n");
                } else {
                    System.out.println("\nСтатус задачи: Выполнена.\n");
                }
                }
        }
    }


    void newNameTasks(String newNameTask) {
        for (int i = 0; i < nameTasks.length; i++) {
            if (nameTasks[i] == null) {
                nameTasks[i] = newNameTask;
                break;
            }
        }
    }

    void newTasks(String newTask) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                tasks[i] = newTask;
                break;
            }
        }
    }

    void deleteTasks(int deleteTask) {
        boolean tempCompletedMark;
        String tempNameTasks;
        String tempTasks;
            if (nameTasks[deleteTask - 1] != null) {
                nameTasks[deleteTask - 1] = null;
                tasks[deleteTask - 1] = null;
                for (int t = 0; t < nameTasks.length - 1; t++) {
                    if (nameTasks[t] == null) {
                        tempNameTasks = nameTasks[t];
                        nameTasks[t] = nameTasks[t + 1];
                        nameTasks[t + 1] = tempNameTasks;

                        tempCompletedMark = completingTasks[t];
                        completingTasks[t] = completingTasks[t + 1];
                        completingTasks[t + 1] = tempCompletedMark;
                    }
                }
                for (int g = 0; g < tasks.length - 1; g++) {
                    if (tasks[g] == null) {
                        tempTasks = tasks[g];
                        tasks[g] = tasks[g + 1];
                        tasks[g + 1] = tempTasks;
                    }
                }
                System.out.println("Задача успешно удалена :)");
            } else {
                System.out.println("Такой задачи нету или она уже удалена :(");
            }
    }

    void markAsCompleted(int markAsCompleted) {
        if (nameTasks[markAsCompleted - 1] == null) {
            System.out.println("Такой задачи нету");
        } else {
        completingTasks[markAsCompleted - 1] = true;
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