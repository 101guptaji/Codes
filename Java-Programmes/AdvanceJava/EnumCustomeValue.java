package advanceJava;

enum Laptop{
    Macbook(10000), Hp(8000), Dell, Asus(7000); // objects of Laptop class

    private int price;

    private Laptop() {
        this.price = 500; // Default price
    }

    Laptop(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}

public class EnumCustomeValue {
    
    public static void main(String[] args) {
        Laptop[] laptops = Laptop.values();

        for(Laptop lap : laptops){
            System.out.println("The price of "+lap.name()+" is "+lap.getPrice());
        }
    }
}
