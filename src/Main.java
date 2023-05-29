import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(120));
        }
        System.out.println(numbers);
        Stream<Integer> stream = numbers.stream();
        findMinMax(stream, Integer::compareTo, (x, y) -> System.out.println("MIN: " + x + ", MAX: " + y));
        streamer(numbers);
    }


    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (!list.isEmpty()) {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void streamer(List<Integer> list) {
        long howMuch = list.stream().filter(x -> x % 2 == 0).count();
        System.out.println("Количество четных чисел: " + howMuch);
    }
}
