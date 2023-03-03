
import java.util.*;

public class dz_05_02 {
       public static String data = """
            Иван Иванов
            Светлана Петрова
            Кристина Белова
            Анна Мусина
            Анна Крутова
            Иван Юрин
            Петр Лыков
            Иван Иванов
            Павел Чернов
            Петр Чернышов
            Мария Федорова
            Марина Светлова
            Мария Савина
            Иван Иванов
            Анна Мусина
            Мария Рыкова
            Марина Лугова
            Анна Владимирова
            Иван Мечников
            Анна Мусина
            Петр Петин
            Кристина Белова
            Иван Ежов""";

    public static void main(String[] args) {
        List<String> employees = new ArrayList<>(List.of(data.split("\n")));
        HashMap<String, Integer> countName = new HashMap<>();
        TreeMap<Integer, List> sortCountName = new TreeMap<>();
        for (String name : employees) {
            if (!countName.containsKey(name.split(" ")[0])) {
                countName.put(name.split(" ")[0], 1);
            } else {
                countName.put(name.split(" ")[0], countName.get(name.split(" ")[0]) + 1);
            }
        }
        for (var item : countName.entrySet()) {
            if (item.getValue() > 1) {
                if (!sortCountName.containsKey(item.getValue())) {
                    sortCountName.put(item.getValue(), List.of(item.getKey()));
                } else {
                    List<String> temp = new ArrayList<String>(sortCountName.get(item.getValue()));
                    temp.add(item.getKey());
                    sortCountName.put(item.getValue(), temp);
                }
            }
        }
        int maxLength = 0;
        for (var item :
                sortCountName.values()) {
            for (var name : item
            ) {
                if (name.toString().length() > maxLength) {
                    maxLength = name.toString().length();
                }
            }
        }
        System.out.println("=== Популярные имена ===");
        for (var item : sortCountName.descendingMap().entrySet()) {
            for (var name : item.getValue()) {
                System.out.print(" ".repeat(maxLength - name.toString().length()) + name + " ");
                System.out.println(item.getKey());
            }
        }
    }
}