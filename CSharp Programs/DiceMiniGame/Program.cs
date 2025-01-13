// See https://aka.ms/new-console-template for more information
/*
 * Dice mini-game challenge
    Your challenge is to design a mini-game. 
    The game should select a target number that is a random number between one and five (inclusive). 
    The player must roll a six-sided dice. To win, the player must roll a number greater than the target number. 
    At the end of each round, the player should be asked if they would like to play again, and the game should continue or terminate accordingly.
*/
Random random = new Random();

Console.WriteLine("Would you like to play? (Y/N)");
if (ShouldPlay())
{
    PlayGame();
}

void PlayGame()
{
    var play = true;

    while (play)
    {
        var target = random.Next(1,6);
        var roll = random.Next(1,7);

        Console.WriteLine($"Roll a number greater than {target} to win!");
        Console.WriteLine($"You rolled a {roll}");
        Console.WriteLine(WinOrLose(target, roll));
        Console.WriteLine("\nPlay again? (Y/N)");

        play = ShouldPlay();
    }
}

bool ShouldPlay()
{
    string? result = Console.ReadLine();
    if(result != null)
    {
        if(result.ToLower().Equals("y"))
        {
            return true;
        }
    }
    return false;
}

string WinOrLose(int tar, int roll)
{
    if (roll > tar)
    {
        return "You win!";
    }
    else
    {
        return "You lose!";
    }
}