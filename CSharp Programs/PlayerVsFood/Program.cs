// See https://aka.ms/new-console-template for more information
/*
 * Suppose you want to create your own game. 
 * You might not be ready to develop a fully featured game, so you decide to start as small as possible. 
 * You want to move a character across the screen and make it consume an object. 
 * The object consume can affect the state of the player. 
 * To keep the game going, you wanted to regenerate the object in a new location once it has been consumed. 
 * You decide that you'll need to use methods to keep your game code organized.

    In this module, you'll develop the following features of a mini-game application:
        A feature to determine if the player consumed the food
        A feature that updates player status depending on the food consumed
        A feature that pauses movement speed depending on the food consumed
        A feature to regenerate food in a new location
        An option to terminate the game if an unsupported character is pressed
        A feature to terminate the game if the Terminal window was resized

    You need the game to end if the user resized the Console window the game is running in. 
    You also want to add an option for the game to end if the user enters any nondirectional character.

    The mini-game displays food that the player can consume. 
    You need to detect if the player has successfully consumed the food, and if so, redisplay the food. 
    You also want to change the player appearance depending on what food was consumed.

    you need to create a method that determines if the player has consumed the food that affects their movement. 
    When the player consumes the food string with value #####, the appearance is updated to (X_X). 
    You'll add a feature to detect if the player appearance is (X_X), and if so, temporarily prevent the player from moving.
    You also want to add an optional feature that detects if the player appearance is (^-^) and if so, 
    increase or decrease the right and left movement speeds by a value of 3 while that appearance is active. 
    When the player state is ('-'), you want the speed to return to normal. 
    You want to make this feature optional since consuming food in this state requires more collision detection than you want to develop for now.
*/

using System;

Random random = new Random();
Console.CursorVisible = false;
bool shouldExit = false;

// Console position of the player
int playerX = 0;
int playerY = 0;

// Console position of the food
int foodX = 0;
int foodY = 0;

// Available player and food strings
string[] states = { "('-')", "(^-^)", "(X_X)" };
string[] foods = { "@@@@@", "$$$$$", "#####" };

// Current player string displayed in the Console
string player = states[0];

int height = Console.WindowHeight - 1;
int width = Console.WindowWidth - player.Length;

// Index of the current food
int food = 0;

InitializeGame();
while (!shouldExit)
{
    if (TerminalResized())
    {
        Console.Clear();
        Console.Write("Console was resized. Program exiting.");
        shouldExit = true;
    }
    else
    {
        if (PlayerIsFaster())
        {
            Move(1, false);
        }
        else if (PlayerIsSick())
        {
            FreezePlayer();
        }
        else
        {
            Move(otherKeysExit: false);
        }
        if (GotFood())
        {
            ChangePlayer();
            ShowFood();
        }
    }
}

// Returns true if the Terminal was resized 
bool TerminalResized()
{
    return height != Console.WindowHeight - 1 || width != Console.WindowWidth - player.Length;
}

// Displays random food at a random location
void ShowFood()
{
    // Update food to a random index
    food = random.Next(0, foods.Length);

    // Update food position to a random location
    foodX = random.Next(0, width - player.Length);
    foodY = random.Next(0, height - 1);

    // Display the food at the location
    Console.SetCursorPosition(foodX, foodY);
    Console.Write(foods[food]);
}

// Returns true if the player location matches the food location
bool GotFood()
{
    return playerX == foodX && playerY == foodY;
}

// Returns true if the player appearance represents a sick state
bool PlayerIsSick()
{
    return player.Equals(states[2]);
}

// Returns true if the player appearance represents a fast state
bool PlayerIsFaster()
{
    return player.Equals(states[1]);
}

// Changes the player to match the food consumed
void ChangePlayer()
{
    player = states[food];
    Console.SetCursorPosition(playerX, playerY);
    Console.Write(player);
}

// Temporarily stops the player from moving
void FreezePlayer()
{
    System.Threading.Thread.Sleep(1000);
    player = states[0];
}

// Reads directional input from the Console and moves the player
void Move(int speed = 1, bool otherKeysExit = false)
{
    int lastX = playerX;
    int lastY = playerY;

    switch (Console.ReadKey(true).Key)
    {
        case ConsoleKey.UpArrow:
            playerY--;
            break;
        case ConsoleKey.DownArrow:
            playerY++;
            break;
        case ConsoleKey.LeftArrow:
            playerX -= speed;
            break;
        case ConsoleKey.RightArrow:
            playerX += speed;
            break;
        case ConsoleKey.Escape:
            shouldExit = true;
            break;
        default:
            // Exit if any other keys are pressed
            shouldExit = otherKeysExit;
            break;
    }

    // Clear the characters at the previous position
    Console.SetCursorPosition(lastX, lastY);
    for (int i = 0; i < player.Length; i++)
    {
        Console.Write(" ");
    }

    // Keep player position within the bounds of the Terminal window
    playerX = (playerX < 0) ? 0 : (playerX >= width ? width : playerX);
    playerY = (playerY < 0) ? 0 : (playerY >= height ? height : playerY);

    // Draw the player at the new location
    Console.SetCursorPosition(playerX, playerY);
    Console.Write(player);
}

// Clears the console, displays the food and player
void InitializeGame()
{
    Console.Clear();
    ShowFood();
    Console.SetCursorPosition(0, 0);
    Console.Write(player);
}
