interface FuncInterface{
    public abstract void operations(int a, int b);

    default void print(){
        System.out.println("This is functional interface");
    }
}

public class LambdaExpressions {
    public static void main(String[] args) {
        FuncInterface add = (a,b)->System.out.printf("%d + %d = %d\n",a,b,a+b);
        
        FuncInterface multiply = (a,b)->System.out.printf("%d * %d = %d\n",a,b,a*b);
        add.operations(5, 10);

        multiply.operations(5, 10);
    }
}
