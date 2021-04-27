import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dictionary {
    //использование интерфейса Function
    public interface Function<T, R> {
        R apply(T t);
    }
    //чистая функция
    protected static String toSortDictionary(String message) {
        return Arrays
                .asList(message.split(" "))
                .stream()
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));//монады
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите сообщение: ");
        final String message = in.nextLine();

        Function<String, String> makeDictionary = item -> toSortDictionary(item);//акцент на том "что", а не "как"

        System.out.println("Словарь: " + makeDictionary.apply(message));
    }
}
