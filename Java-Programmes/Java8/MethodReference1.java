import java.util.Arrays;

public class MethodReference1 {
    static void print(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        String[] names = {"Gupta","Sinha", "Rahul"};

        Arrays.stream(names).forEach(MethodReference1::print);
    }
}
