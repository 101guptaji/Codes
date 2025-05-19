package advanceJava;

import java.util.Scanner;

public class EnumExample {
    enum Status{
        Passed, Pending, Failed, Running
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a status");
        Status[] allStatus = Status.values();
        for(Status s : allStatus){
            System.out.print(s+", ");
        }
        System.out.println();

        Status sin = Status.valueOf(sc.nextLine());

        switch (sin) {
            case Passed:
                System.out.println("200: All Ok");
                break;
            case Pending:
                System.out.println("301: Please wait");
                break;
            case Running:
                System.out.println("201: Created");
                break;
            default:
                System.out.println("400: Try Again");
                break;
        }

        sc.close();
    }
}
