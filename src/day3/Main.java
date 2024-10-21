package day3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var numbers = List.of(1,2,3,4); // millions of numbers

        // Problem Statement:
        // From given list of numbers, find odd numbers,
        // double them, filter out numbers less than 10,
        // square them and return the result


        // imperative style
/*
        var result = new ArrayList<>();

        for(int i=0; i<numbers.size(); i++) {
            if(isOdd(numbers.get(i))){ // odd check
                var doubleResult = doubleIt(numbers.get(i));
                if(isLessThanTen(doubleResult)) {
                    var squareResult = square(doubleResult);
                    result.add(squareResult);
                }
            }
        }

        System.out.println(result);
*/

        /*
isOdd Called: 1
doubleIt Called: 1
isLessThanTen Called: 2
square Called: 2
isOdd Called: 2
isOdd Called: 3
doubleIt Called: 3
isLessThanTen Called: 6
square Called: 6
isOdd Called: 4
4
         */

        int int2 = 2;

        // declarative style
        var result2 = numbers.stream() //  From given list of numbers
                .filter(x -> isOdd(x)) // find odd numbers
                .map(x -> doubleIt(x)) //  double them
                .filter(x -> isLessThanTen(x)) // filter out numbers less than 10
                .map(x -> square(x)) // square the
                .findFirst();
//                .toList(); //and return the result

//        result2.get(0); //
        System.out.println(result2.get());

//        System.out.println(result2.get(0));



    }

    private static boolean isOdd(int n) {
        System.out.println("isOdd Called: " + n);
        return n % 2 != 0;
    }

    private static int doubleIt(int n) {
        System.out.println("doubleIt Called: " + n);
        return n + n;
    }

    private static boolean isLessThanTen(int n) {
        System.out.println("isLessThanTen Called: " + n);
        return n < 10;
    }

    private static int square(int n) {
        System.out.println("square Called: " + n);
        return n * n;
    }

}