// See https://aka.ms/new-console-template for more information
/*
    Challenge: Improve renewal rate of subscriptions
    You've been asked to add a feature to your company's software. 
    The feature is intended to improve the renewal rate of subscriptions to the software. 
    Your task is to display a renewal message when a user logs into the software system and is notified their subscription will soon end. 
    You'll need to add a couple of decision statements to properly add branching logic to the application to satisfy the requirements.
*/

Random random = new Random();
int daysUntilExpiration = random.Next(12); //number from 0 to 11
int discountPercentage = 0;

// Your code goes here
if(daysUntilExpiration == 0){
    System.Console.WriteLine("Your subscription has expired.");
}
else if(daysUntilExpiration == 1){
    System.Console.WriteLine("Your subscription expires within a day!");
    discountPercentage = 20;
}
else if (daysUntilExpiration <= 5){
    System.Console.WriteLine($"Your subscription expires in {daysUntilExpiration} days.");
    discountPercentage = 10;
}
else if (daysUntilExpiration <= 10){
    System.Console.WriteLine("Your subscription will expire soon. Renew now!");
}

if(discountPercentage > 0){
    System.Console.WriteLine($"Renew now and save {discountPercentage}%!");
}

