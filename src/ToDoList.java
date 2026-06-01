import java.util.Scanner;

class Tasks {
    // ПОМЕНЯТЬ НА ArrayList !!!
    String[] name = new String[11];
    String[] description = new String[11];
    boolean[] completed = new boolean[11];

    void showTasks() {
        for (int i = 0; i < name.length; i++) {
            if (name[0] == null) {
                System.out.print("Задач нету :( \n");
                break;
            }
            if (name[i] == null) {
                break;
            } else {
                System.out.println("Задача №" + (i + 1) + ". " + name[i] + ":\n\t" + description[i]);
                if (completed[i] == false) {
                    System.out.println("\nСтатус задачи: В процессе.\n");
                } else {
                    System.out.println("\nСтатус задачи: Выполнена.\n ");
                }
            }
        }
    }


    void newNameTasks(String newNameTask) {
        for (int i = 0; i < name.length; i++) {
            if (name[i] == null) {
                name[i] = newNameTask;
                break;
            }
        }
    }

    void newTasks(String newTask) {
        for (int i = 0; i < description.length; i++) {
            if (description[i] == null) {
                description[i] = newTask;
                break;
            }
        }
    }

    void deleteTasks(int deleteTask) {
        boolean tempCompletedMark;
        String tempNameTask;
        String tempTask;
            if (name[deleteTask - 1] != null) {
                name[deleteTask - 1] = null;
                description[deleteTask - 1] = null;
                for (int t = 0; t < name.length - 1; t++) {
                    if (name[t] == null) {
                        tempNameTask = name[t];
                        name[t] = name[t + 1];
                        name[t + 1] = tempNameTask;

                        tempCompletedMark = completed[t];
                        completed[t] = completed[t + 1];
                        completed[t + 1] = tempCompletedMark;
                    }
                }
                for (int g = 0; g < description.length - 1; g++) {
                    if (description[g] == null) {
                        tempTask = description[g];
                        description[g] = description[g + 1];
                        description[g + 1] = tempTask;
                    }
                }
                System.out.println("Задача успешно удалена :)");
            } else {
                System.out.println("Такой задачи нету или она уже удалена :(");
            }
    }

    void markAsCompleted(int markAsCompleted) {
        if (name[markAsCompleted - 1] == null) {
            System.out.println("Такой задачи нету");
        } else {
            completed[markAsCompleted - 1] = true;
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