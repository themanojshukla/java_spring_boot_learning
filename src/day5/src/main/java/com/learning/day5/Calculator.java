package day5.src.main.java.com.learning.day5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    // Dependency
    @Autowired
    private LogicalCalculator logicalCalc;

    public Calculator() {
        System.out.println("Constructor Crated  [Calculator]");
    }

    public int add(int a, int b) {
        return logicalCalc.add(a,b); // using the object (or Bean) named 'logicalCalc'
    }

    public int subtract(int a, int b) {
        return logicalCalc.sub(a, b);
    }

}



