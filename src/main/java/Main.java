import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        Logger logger = Logger.getInstance();
        Random random = new Random();

        while (true) {
            logger.log("Запускаем программу");
            logger.log("Просим пользователя ввести данные для списка");
            System.out.println("Введите размер списка: ");
            try {
                int listSize = Integer.parseInt(scanner.nextLine());
                System.out.println("Введите верхнюю границу для значений: ");
                int valueBoundary = Integer.parseInt(scanner.nextLine());
                logger.log("Создаем и наполняем список");

                for (int i = 0; i < listSize; i++) {
                    list.add(random.nextInt(valueBoundary));
                }

                System.out.println("Вот случайный список: " + list);
                logger.log("Просим пользователя ввести входные данные для фильтрации");
                System.out.println("Введите порог для фильтра: ");
                int filterBoundary = Integer.parseInt(scanner.nextLine());
                Filter filter = new Filter(filterBoundary);

                List<Integer> listAfterFilter = filter.filterOut(list);
                logger.log("Выводим результат на экран");
                System.out.println("Отфильтрованный список " + listAfterFilter);
                logger.log("Завершаем программу");
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Необходимо ввести число");
                logger.log("Было введено некорректное число");
                break;
            }
        }
    }
}
