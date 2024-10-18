import javax.security.auth.Subject;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {
        var students = List.of(
            new Student("John", 30, List.of("Maths", "Science")),
            new Student("Jane", 31, List.of("Maths", "Physics")),
            new Student("Joe", 32, List.of("Chemistry", "Biology")),
            new Student("Jill", 33, List.of("Maths", "Science"))
        );

        students.stream()
                .flatMap(x -> x.subject().stream())
                .distinct()
                .forEach(System.out::println);



    }

}

record Student(String name, int age, List<String> subject) {}
