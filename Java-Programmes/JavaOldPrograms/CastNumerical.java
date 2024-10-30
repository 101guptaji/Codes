public class CastNumerical {
    public static void main(String[] args) {

        byte byteValue = 20; //256 value from -128 to 127
        short shortValue = 55; //16 bits for short
        int intValue = 888; //32 bit for int
        long longValue = 23355;
        
        float floatValue = 8834.8f;
        float floatValue2 = (float)99.3; //casting double to float
        double doubleValue = 32.4;
        
        System.out.println(Byte.MAX_VALUE);
        
        intValue = (int)longValue; //casting long value to integer
        
        System.out.println(intValue);
        
        doubleValue = intValue;
        System.out.println(doubleValue); 
        
        intValue = (int)floatValue; //casting float to int
        System.out.println(intValue);
    
    
        // The following won't work as we expect it to
        // 129 is too big for a byte.
        byteValue = (byte)129;
        System.out.println(byteValue);

    }

}