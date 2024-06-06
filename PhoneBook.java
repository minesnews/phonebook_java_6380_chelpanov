import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.toMap;

public class PhoneBook {
    static Map<String, Set<Integer>> phoneBook = new HashMap<>();
    
    public void add(String name, int phone){ // Добавить телефон и имя абонента в справочник
        if (!phoneBook.containsKey(name))
            phoneBook.put(name, new HashSet<>());
        phoneBook.get(name).add(phone);             
    }
    public void find(String name) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (phoneBook.containsKey(name)) {
            list = new ArrayList<Integer>(phoneBook.get(name));
        }
        System.out.println(name + ":" +list);    
    }
    public void removePhone(int num){ // Удалить номер телефона
        phoneBook.get(getKey(phoneBook, num)).remove(num);
        System.out.println("Телефон " + num + " удалён");
    }
    public static String getKey(Map<String, Set<Integer>> map, Integer value) { // Получить имя по номеру телефона
        String key = null;
        for(Map.Entry<String, Set<Integer>> entry : map.entrySet()) {
            int[] sets = entry.getValue().stream().mapToInt(Integer::intValue).toArray();
            for (int i = 0; i < sets.length; i++) {
                if(sets[i] == value) {
                    key = entry.getKey();
                    break;
                }
            }
        }     
        return key;
    }
    public static Map<String, Set<Integer>> sortPhoneBook(Map<String, Set<Integer>> phonebook){ // Отсортировать справочник по количеству телефонов у пользователя по убыванию
        Map<String, Set<Integer>> sorted = phonebook.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Set<Integer>::size).reversed()))
        .collect(toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (a, b) -> { throw new AssertionError(); },
        LinkedHashMap::new
        ));
        return sorted;
    }
    public static void getPhoneBook_sorted() { // Получить отсортированный справочник
        phoneBook = sortPhoneBook(phoneBook);

        String array[] = phoneBook.keySet().toArray(new String[0]); 
        Collection<Set<Integer>> values =  phoneBook.values();

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " - "   + values.toArray()[i].toString().replaceAll("[\\[\\]]", ""));
        }
    } 
}
