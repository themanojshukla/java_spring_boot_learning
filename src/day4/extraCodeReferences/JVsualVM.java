package day4.extraCodeReferences;

import java.util.List;
import java.util.stream.IntStream;

public class JVsualVM {

    private String[] strRef = new String[5000] ;

    public JVsualVM(int a) {
        if(a > 0){
            strRef = new String[a*strRef.length];
            System.out.println(strRef.length);
            IntStream.range(0, strRef.length)
                    .forEach(i -> strRef[i] = "Hello"+i);
            System.out.println(strRef[89]);
        }
    }

    public JVsualVM() {
    }


    /*
    Run the code, open JVisual VM
    create heapdump before program fnishes
    try to earch your class i.e JVsualVM in heapdump
    count how many instances are there, compare with your code,
     match the count that you created using new keyword.

     This excersie helps you to be awareof jvisual vmfeatures, heapdum search & fiter.
     */
    public static void main(String[] args) {
        try {
            var j = List.of(
                    new JVsualVM(),
                    new JVsualVM(),
                    new JVsualVM(4),
                    new JVsualVM(),
                    new JVsualVM(),
                    new JVsualVM());
            Thread.sleep(60000);
            j = null;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

