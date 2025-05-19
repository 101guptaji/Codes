package advanceJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStream {
    public static void main(String[] args) {

        int len = 100000;
        List<Integer> list = new ArrayList<>(len);


        Random rand = new Random();
        for(int i=0;i<len;i++){
            list.add(rand.nextInt(100));
        }

        // using normal stream
        long startTime = System.currentTimeMillis();
        int sum1 = list.stream().mapToInt(i->i).sum();
        long endTime = System.currentTimeMillis();

        long startTimePar = System.currentTimeMillis();
        int sum2 = list.parallelStream().mapToInt(i->i).sum();
        long endTimePar = System.currentTimeMillis();

        System.out.println(sum1+" "+sum2);

        System.out.println("Normal Stream Time: "+(endTime-startTime));
        System.out.println("Parallel Stream Time: "+(endTimePar-startTimePar));

    }
}
