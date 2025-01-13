// See https://aka.ms/new-console-template for more information
//Console.WriteLine("Hello, World!");
/*
    Code challenge: write code to display the result of a coin flip
    In this challenge, you'll implement a conditional operator to simulate a "coin flip". 
    The resulting decision logic will display either heads or tails.
*/

// Random coin = new Random();
// int flip = coin.Next(0, 2);
// System.Console.WriteLine(flip == 0 ? "head" : "tail");

string permission = "Admin|Manager";
int level = 55;
if (permission.Contains("Admin")){
    if(level>55){
        System.Console.WriteLine("Welcome, Super Admin user.");
    }
    else{
        System.Console.WriteLine("Welcome, Admin user.");
    }
}
else if (permission.Contains("Manager")){
    if(level>=20){
        System.Console.WriteLine("Contact an Admin for access.");
    }
    else{
        System.Console.WriteLine("You do not have sufficient privileges.");
    }
}
else{
    System.Console.WriteLine("You do not have sufficient privileges.");
}
