package com.demo.knowledge.demo.testStream;

import com.demo.knowledge.demo.entity.Student;
import com.demo.knowledge.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//@Service
//@RequiredArgsConstructor
public class TestStreamServiceImpl {

//    private final StudentRepository studentRepository;


    // Stream for primitive
    void streamForPrimitive(){
        // --- <primitive>Stream.range()  : từ 1 khoảng đến 1 khoảng
        // --- <primitive>Stream.of()     : duyệt các p tử trong of
        IntStream.range(1, 4).forEach(System.out::println);
        IntStream.of(1, 2, 3, 4).forEach(System.out::println);
    }

    // Generate Streams using Stream.generate()
    public void streamUsingGenerate() {
        Stream<String> stream = Stream.generate(() -> "gpcoder").limit(3);
        String[] testStrArr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(testStrArr)); // [gpcoder, gpcoder, gpcoder]
    }

    // Generate Streams using Stream.iterate()
    public void streamUsingIterate() {
        Stream<Long> iterateNumbers = Stream.iterate(6L, n -> n + 1).limit(5);
        iterateNumbers.forEach(System.out::print); // 12345
    }

    // Generate Streams from APIs like Regex
    public void streamUsingRegex() {
        String str = "Welcome,to,gpcoder";
        Pattern.compile(",").splitAsStream(str).forEach(System.out::print);// Welcometogpcoder
    }

    // Get Collections using stream.collect(Collectors.toList())
    public void getCollectionUsingStreamCollection() {
        Stream<String> stream = Stream.of("Java", "C#", "C++", "PHP", "Javascript");
        List<String> languages = stream.collect(Collectors.toList());
        System.out.println(languages);
    }

    // Get arrays using stream.toArray(EntryType[]::new)
    public void getArrayUsingStreamToArray() {
        Stream<String> stream = Stream.of("Java", "C#", "C++", "PHP", "Javascript");
        String[] languages = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(languages));
    }

    // filter() operation helps eliminate elements based on certain criteria
    public void FilterStreamExample() {
        Stream.iterate(1, count -> count + 1) //
                .filter(number -> number % 3 == 0) //
                .limit(6) //
                .forEach(System.out::println);


        List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
        data.stream() //
                .skip(1) //
                .limit(3) //
                .forEach(System.out::print); // C#C++PHP


        // map() operation helps map elements to the corresponding results
        List<String> data1 = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
        data1.stream() //
                .map(String::toUpperCase) // convert each element to upper case
                .forEach(System.out::println);


        // sorted() operation helps sort elements based on certain criteria
        List<String> data2 = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
        // sorted according to natural order
        data2.stream() //
                .sorted() //
                .forEach(System.out::println);
        // sorted according to the provided Comparator
        data2.stream() //
                .sorted((s1, s2) -> s1.length() - s2.length()) //
                .forEach(System.out::println);
    }

    public void TerminalOperations(){
        // foreach operations helps iterate the elements of the Stream
        Stream.iterate(1, count -> count + 1) //
                .filter(number -> number % 3 == 0) //
                .limit(6) //
                .forEach(System.out::println);


        // collect() operation helps to collect the stream result in a collection like
        // list
        Stream<String> stream = Stream.of("Java", "C#", "C++", "PHP", "Javascript");
        List<String> languages = stream.collect(Collectors.toList());
        System.out.println(languages);


        // match() operation returns a boolean depending upon the condition applied on
        // stream data
        // anyMatch() trả về một boolean tùy thuộc vào điều kiện được áp dụng trên Stream dữ liệu.
                    // Phương thức này trả về true ngay khi phần tử đầu tiên thõa mãn điều kiện, những
                    // phần tử còn lại sẽ không được kiểm tra.
        // allMatch() : Phương thức này trả về true nếu tất cả phần tử đều thõa mãn điều kiện.
                    // Nếu một phần tử không thõa điều kiện, những phần tử còn lại sẽ không được kiểm tra.
        // noneMatch() : Ngược lại với allMatch(), pương thức này trả về true nếu tất cả phần tử
                    // đều không thõa mãn điều kiện. Nếu một phần tử thõa điều kiện, những phần tử còn lại sẽ không được kiểm tra.
        List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
        boolean result = data.stream().anyMatch((s) -> s.equalsIgnoreCase("Java"));
        System.out.println(result); // true


        // reduce() operation combines the stream elements into one using a
        // BinaryOperator
        int result1 = IntStream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);
        System.out.println(result1); // 10
    }

    public static void main(String[] args) {
        TestStreamServiceImpl test = new TestStreamServiceImpl();
        test.FilterStreamExample();
    }

}
