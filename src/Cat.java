import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Cat {
     static void main() {
//          ArrayList<String> name = new ArrayList<>(); // Создание list в котором только будут значения String (<String>).
//          name.add("Andrey"); // Добавление элемента по порядку.
//          name.add("Masha");
//          name.add(0,"Kirill"); // Добавление элемента но в начале можно выбрать индекс в котором он будет стоять.
//          System.out.println(name);
//          String showList = name.get(0); // Получение элемента под индексом 0.
//          System.out.println(showList);
//          name.set(2, "Aleksey"); // Изменение элементов в списке.
//          name.remove(1); // Удаление элемента под индексом 1.
//          System.out.println(name.size()); // Вывод размера списка.
//          System.out.println(name.isEmpty()); // Проверка на пустоту списка (false т.к список не пустой).
//          System.out.println(name.contains("Aleksey")); // Проверка на наличие элемента (true).
////          name.clear(); // Очистка списка.
//          ArrayList<Integer> list = new ArrayList<>(100); // Создали список на 100 мест сразу.
//          for (int i = 0; i < name.size(); i++) {
//               System.out.print(name.get(i));
//          }
//          int a = 1;
//          System.out.println(name.get(a));
//     }
          Scanner scanner = new Scanner(System.in);
          int number = 0;

          // В блок try заключаем код, в котором может произойти исключение
          // Scanner может выбросить InputMismatchException, если введено не число
          try {
               System.out.print("Введите число: ");
               number = scanner.nextInt();

               // Проверяем валидность введенного числа
               if (number < 0) {
                    throw new ("Число не может быть отрицательным!");
               }

          } catch (InputMismatchException e) {
               // Обрабатываем ситуацию, когда введено не число
               System.out.println("Ошибка: введено не число!");
               throw new InvalidInputException("Некорректный ввод данных");

          } finally {
               // Блок finally выполняется всегда
               scanner.close();
               System.out.println("Ввод данных завершен");
          }

          return number;
}
