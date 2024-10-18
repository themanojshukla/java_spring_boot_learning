import java.util.function.Function;

public class Test2 {
    public static void main(String[] args) {

        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> doubleIt =  x -> x * 2;

        Function<Integer,Integer> squareComposeDouble = square.compose(doubleIt);
        Function<Integer,Integer> squareThenDouble = square.andThen(doubleIt);

        System.out.println(squareComposeDouble.apply(5));
        System.out.println(squareThenDouble.apply(5));

//
//        System.out.println(calculate(square, 5));
//
//
//        square = x -> x * x * x;
//
//        System.out.println(calculate(square, 5));

    }

    private static int calculate(Function<Integer, Integer> formulae, int input){
        return formulae.apply(input);
    }

   /* private static int square(int n) {
        System.out.println("square Called: " + n);
        return n * n;
    }*/
}
