package day5.src.main.java.com.learning.day5;


import org.springframework.stereotype.Component;

public class LogicalCalculator {


    public LogicalCalculator() {
        System.out.println("Constructor called [LogicalCalculator]");
    }

    public int add(int a, int b){
        return a+b;
    }

    public int sub(int a, int b){
        return a - b;
    }

}
