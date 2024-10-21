package day3;

import java.util.function.Predicate;

public class PredicatesExample {

    public static void main(String[] args) {

        Predicate<String> checkIfLengthGreaterThanZero = s -> {
            // do Some calls
            // print
            System.out.println("Input was: " + s);
            return s.length() > 0;
        };


        Predicate<String> testing = checkIfLengthGreaterThanZero.and(s -> s.equalsIgnoreCase("testing"));

        System.out.println(testing.negate().test("testing3"));
        System.out.println(testing.test("Testing"));
    }

}
