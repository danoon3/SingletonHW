import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();

        logger.log("Запускаем фильтрацию");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < treshold) {
                logger.log("Элемент " + "'" + list.get(i) + "' " + " не проходит фильтрацию");
            } else {
                logger.log("Элемент " + "'" + list.get(i) + "' " + " проходит фильтрацию");
                result.add(list.get(i));
            }
        }

        result = result.stream()
                .sorted()
                .collect(Collectors.toList());
        logger.log("Прошло фильтр " + result.size() + " элемента из " + list.size());

        return result;
    }
}
