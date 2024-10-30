class family{
    String name;
    int age;
     void greet() //simple method
     {
        System.out.println("Hello " +name+ ".");
     }
     int workTime() //method with return value
     {
        int work = 60 - age;
        
        return work;
    }
    void friend(String frnd) //method with parameter
    {
        System.out.println(frnd+" is you best friend");
    }
    String helper(String name, int age) //method with parameter and return value
    {
        return name +" of "+age+" years";
    }

}
class classExample{  
        public static void main(String args[]){ 
            family f1=new family();
            f1.name="Anushka";
            f1.age=30;
            f1.greet();
            System.out.printf("you are %d years old. \n", f1.age);
            int timeLeft=f1.workTime();
            System.out.printf("You need to work for %d years more.\n", timeLeft);
            f1.friend("Raghu");
            String help=f1.helper("Candy", 18);
            System.out.println(help+ " can help you");
        }  
    }  
