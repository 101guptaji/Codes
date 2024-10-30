public class RuntimeException {

    public static void main(String[] args) {
        
        // Null pointer exception ....
        String text = null;
        try{
        System.out.println(text.length());
        } 
        catch (NullPointerException e){
            System.out.println(e.toString());
        }
        
        
        
        // Arithmetic exception ... (divide by zero)
        try {
            int value = 7/0;
        } 
        catch(ArithmeticException e){
            System.out.println(e.toString());
        }

        // You can actually handle RuntimeExceptions if you want to;
        // for example, here we handle an ArrayIndexOutOfBoundsException
        String[] texts = { "one", "two", "three" };

        try {
            System.out.println(texts[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
    }
}