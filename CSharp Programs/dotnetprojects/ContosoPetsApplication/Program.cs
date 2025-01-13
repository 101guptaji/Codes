// See https://aka.ms/new-console-template for more information
/*
    Suppose you're a developer who likes to support the local community. 
    You and some of your friends started a business that helps find new homes for stray or abandoned cats and dogs. 
    Your business started off small, with just a couple of strays, but it's starting to grow. 
    You want to create an application that will help you match the animals in your care with people looking for a pet. 
    You've found that it's important to have a detailed description of the animals to share with potential owners. 
    In addition, being able to describe the personality of the dog or cat makes them more appealing to potential owners. 
    You decide to create an application that helps you manage information about the dogs and cats you're caring for.

    The application you develop will:
        Add predefined sample data to the pets array.
        Iterate a "menu options and user selection" code block to establish the outer loop of your application.
        Implement code branches corresponding to the user's menu selections.
        Display all the information contained in the array used to store pet data (based on user's menu selection).
        Iterate an "add new animal information" code block that enables the user to add one or more new animals to the pets array (based on user's menu selection).

    Store application data in a multidimensional string array named ourAnimals.
    The ourAnimals array includes the following "pet characteristics" for each animal:
        1. Pet ID #.
        2. Pet species (cat or dog).
        3. Pet age (years).
        4. A description of the pet's physical condition/characteristics.
        5. A description of the pet's personality.
        6. The pet's nickname.

    Implement a sample dataset that represents dogs and cats currently in your care.

    Display menu options to access the main features of the application.

    The main features enable the following tasks:
    1.  List the pet information for all animals in the ourAnimals array.
    2.  Add new animals to the ourAnimals array. The following conditions apply:
        The pet species (dog or cat) must be entered when a new animal is added to the ourAnimals array.
        A pet ID must be programmatically generated when a new animal is added to the ourAnimals array.
        Some physical characteristics for a pet may be unknown until a veterinarian's examination. For example: age, breed, and neutered/spayed status.
        An animal's nickname and personality may be unknown when a pet first arrives.
    
    3. Ensure animal ages and physical descriptions are complete. This may be required after a veterinarian's examination.

    4. Ensure animal nicknames and personality descriptions are complete (this action can occur after the team gets to know a pet).

    5. Edit an animal’s age (if a pet's birth date is known and the pet has a birthday while in our care).

    6. Edit an animal’s personality description (a pet may behave differently after spending more time in our care).

    7. Display all cats that meet user specified physical characteristics.

    8. Display all dogs that meet user specified physical characteristics.

    To ensure that animal ages and physical descriptions are complete, your code must:
        Assign a valid numeric value to petAge for any animal that has been assigned data in the ourAnimals array but has not been assigned an age.
        Assign a valid string to petPhysicalDescription for any animal that has been assigned data in the ourAnimals array but has not been assigned a physical description.
        Verify that physical descriptions have an assigned value. Assigned values cannot have zero characters. Any further requirement is up to you.
    
    To ensure that animal nicknames and personality descriptions are complete, your code must:
        Assign a valid string to petNickname for any animal that has been assigned data in the ourAnimals array but has not been assigned a nickname.
        Assign a valid string to petPersonalityDescription for any animal that has been assigned data in the ourAnimals array but has not been assigned a personality description.
        Verify that nicknames and personality descriptions have an assigned value. Assigned values cannot have zero characters. Any further requirement is up to you.

    Add suggestedDonation data and display all data in a shortened format.
      Suggested donation data:
        Define suggestedDonation string
        Expand the ourAnimals array to contain suggestedDonation and populate sample data for suggestedDonation
        Ensure all usage of ourAnimals array accounts for the added suggestedDonation data
        Output suggestedDonation with regional currency symbol ($, €, ¥,... )
*/

using System;

// the ourAnimals array will store the following: 
string animalID = "";
string animalSpecies = "";
string animalAge = "";
string animalPhysicalDescription = "";
string animalPersonalityDescription = "";
string animalNickname = "";
string suggestedDonation = "";

// variables that support data entry
int maxPets = 10;
string? readResult;
string menuSelection = "";
int petAge = 0;
bool validEntry = false;
string characteristic = "";
decimal decimalDonation = 0.00m;

// to "rotating" animation with countdown
string[] searchingIcons = { " |", " /", "--", " \\", " *" };

// array used to store runtime data, there is no persisted data
string[,] ourAnimals = new string[maxPets, 7];

// create some initial ourAnimals array entries
for (int i = 0; i < maxPets; i++)
{
    switch (i)
    {
        case 0:
            animalSpecies = "dog";
            animalID = "d1";
            animalAge = "2";
            animalPhysicalDescription = "medium sized cream colored female golden retriever weighing about 45 pounds. housebroken.";
            animalPersonalityDescription = "loves to have her belly rubbed and likes to chase her tail. gives lots of kisses.";
            animalNickname = "lola";
            suggestedDonation = "85.00";
            break;

        case 1:
            animalSpecies = "dog";
            animalID = "d2";
            animalAge = "9";
            animalPhysicalDescription = "large reddish-brown male golden retriever weighing about 85 pounds. housebroken.";
            animalPersonalityDescription = "loves to have his ears rubbed when he greets you at the door, or at any time! loves to lean-in and give doggy hugs.";
            animalNickname = "gus";
            suggestedDonation = "49.99";
            break;

        case 2:
            animalSpecies = "cat";
            animalID = "c3";
            animalAge = "1";
            animalPhysicalDescription = "small white female weighing about 8 pounds. litter box trained.";
            animalPersonalityDescription = "friendly";
            animalNickname = "snow";
            suggestedDonation = "40.00";
            break;

        case 3:
            animalSpecies = "cat";
            animalID = "c4";
            animalAge = "";
            animalPhysicalDescription = "";
            animalPersonalityDescription = "";
            animalNickname = "lion";
            suggestedDonation = "";

            break;

        default:
            animalSpecies = "";
            animalID = "";
            animalAge = "";
            animalPhysicalDescription = "";
            animalPersonalityDescription = "";
            animalNickname = "";
            suggestedDonation = "";
            break;

    }

    ourAnimals[i, 0] = "ID #: " + animalID;
    ourAnimals[i, 1] = "Species: " + animalSpecies;
    ourAnimals[i, 2] = "Age: " + animalAge;
    ourAnimals[i, 3] = "Nickname: " + animalNickname;
    ourAnimals[i, 4] = "Physical description: " + animalPhysicalDescription;
    ourAnimals[i, 5] = "Personality: " + animalPersonalityDescription;

    if (!decimal.TryParse(suggestedDonation, out decimalDonation))
    {
        decimalDonation = 45.00m; // if suggestedDonation NOT a number, default to 45.00
    }
    ourAnimals[i, 6] = $"Suggested Donation: {decimalDonation:C2}";
}

do
{
    // display the top-level menu options

    Console.Clear();

    Console.WriteLine("Welcome to the Contoso PetFriends app. Your main menu options are:");
    Console.WriteLine(" 1. List all of our current pet information");
    Console.WriteLine(" 2. Add a new animal friend to the ourAnimals array");
    Console.WriteLine(" 3. Ensure animal ages and physical descriptions are complete");
    Console.WriteLine(" 4. Ensure animal nicknames and personality descriptions are complete");
    Console.WriteLine(" 5. Edit an animal’s age");
    Console.WriteLine(" 6. Edit an animal’s personality description");
    Console.WriteLine(" 7. Display all cats with a specified characteristic");
    Console.WriteLine(" 8. Display all dogs with a specified characteristic");
    Console.WriteLine();
    Console.WriteLine("Enter your selection number (or type Exit to exit the program)");

    readResult = Console.ReadLine();
    if (readResult != null)
    {
        menuSelection = readResult.ToLower();
        // NOTE: We could put a do statement around the menuSelection entry to ensure a valid entry, but we
        //  use a conditional statement below that only processes the valid entry values, so the do statement 
        //  is not required here. 
    }

    // use switch-case to process the selected menu option
    switch (menuSelection)
    {
        case "1":
            // List all of our current pet information
            for (int i = 0; i < maxPets; i++)
            {
                if (ourAnimals[i, 0] != "ID #: ")
                {
                    Console.WriteLine();
                    for (int j = 0; j < 7; j++)
                    {
                        Console.WriteLine(ourAnimals[i, j]);
                    }
                }
            }
            Console.WriteLine("\n\rPress the Enter key to continue");
            readResult = Console.ReadLine();

            break;

        case "2":
            // Add a new animal friend to the ourAnimals array
            string anotherPet = "y";
            int petCount = 0;
            for (int i = 0; i < maxPets; i++)
            {
                if (ourAnimals[i, 0] != "ID #: ")
                {
                    petCount += 1;
                }
            }

            if (petCount < maxPets)
            {
                Console.WriteLine($"We currently have {petCount} pets that need homes. We can manage {(maxPets - petCount)} more.");
            }

            while (anotherPet == "y" && petCount < maxPets)
            {
                validEntry = false;
                
                // get species (cat or dog) - string animalSpecies is a required field 
                do
                {
                    Console.WriteLine("\n\rEnter 'dog' or 'cat' to begin a new entry");
                    readResult = Console.ReadLine();
                    if (readResult != null)
                    {
                        animalSpecies = readResult.ToLower();
                        if (animalSpecies != "dog" && animalSpecies != "cat")
                        {
                            //Console.WriteLine($"You entered: {animalSpecies}.");
                            validEntry = false;
                        }
                        else
                        {
                            validEntry = true;
                        }
                    }
                } while (validEntry == false);

                // build the animal the ID number - for example C1, C2, D3 (for Cat 1, Cat 2, Dog 3)
                animalID = animalSpecies.Substring(0, 1) + (petCount + 1).ToString();

                // get the pet's age. can be ? at initial entry.
                do
                {
                    Console.WriteLine("Enter the pet's age or enter ? if unknown");
                    readResult = Console.ReadLine();
                    if (readResult != null)
                    {
                        animalAge = readResult;
                        if (animalAge != "?")
                        {
                            validEntry = int.TryParse(animalAge, out petAge);
                        }
                        else
                        {
                            validEntry = true;
                        }
                    }
                } while (validEntry == false);

                // get a description of the pet's physical appearance/condition - animalPhysicalDescription can be blank.
                do
                {
                    Console.WriteLine("Enter a physical description of the pet (size, color, gender, weight, housebroken)");
                    readResult = Console.ReadLine();
                    if (readResult != null)
                    {
                        animalPhysicalDescription = readResult.ToLower();
                        if (animalPhysicalDescription == "")
                        {
                            animalPhysicalDescription = "tbd";
                        }
                    }
                } while (animalPhysicalDescription == "");

                // get a description of the pet's personality - animalPersonalityDescription can be blank.
                do
                {
                    Console.WriteLine("Enter a description of the pet's personality (likes or dislikes, tricks, energy level)");
                    readResult = Console.ReadLine();
                    if (readResult != null)
                    {
                        animalPersonalityDescription = readResult.ToLower();
                        if (animalPersonalityDescription == "")
                        {
                            animalPersonalityDescription = "tbd";
                        }
                    }
                } while (animalPersonalityDescription == "");

                // get the pet's nickname. animalNickname can be blank.
                do
                {
                    Console.WriteLine("Enter a nickname for the pet");
                    readResult = Console.ReadLine();
                    if (readResult != null)
                    {
                        animalNickname = readResult.ToLower();
                        if (animalNickname == "")
                        {
                            animalNickname = "tbd";
                        }
                    }
                } while (animalNickname == "");

                // get the pet's donation data. can be 0 at initial entry.
                do
                {
                    Console.WriteLine("Enter the pet's suggested donation");
                    readResult = Console.ReadLine();
                    if (readResult != null)
                    {
                        suggestedDonation = readResult;
                        validEntry = decimal.TryParse(suggestedDonation, out decimalDonation);
                    }
                } while (validEntry == false);

                // store the pet information in the ourAnimals array (zero based)
                ourAnimals[petCount, 0] = "ID #: " + animalID;
                ourAnimals[petCount, 1] = "Species: " + animalSpecies;
                ourAnimals[petCount, 2] = "Age: " + animalAge;
                ourAnimals[petCount, 3] = "Nickname: " + animalNickname;
                ourAnimals[petCount, 4] = "Physical description: " + animalPhysicalDescription;
                ourAnimals[petCount, 5] = "Personality: " + animalPersonalityDescription;
                ourAnimals[petCount, 6] = $"Suggested Donation: {decimalDonation:C2}";

                // increment petCount (the array is zero-based, so we increment the counter after adding to the array)
                petCount = petCount + 1;

                // check maxPet limit
                if (petCount < maxPets)
                {
                    // another pet?
                    Console.WriteLine("Do you want to enter info for another pet (y/n)");
                    do
                    {
                        readResult = Console.ReadLine();
                        if (readResult != null)
                        {
                            anotherPet = readResult.ToLower();
                        }

                    } while (anotherPet != "y" && anotherPet != "n");
                }
            }

            if (petCount >= maxPets)
            {
                Console.WriteLine("We have reached our limit on the number of pets that we can manage.");
                Console.WriteLine("Press the Enter key to continue.");
                readResult = Console.ReadLine();
            }

            break;

        case "3":
            // Ensure animal ages and physical descriptions are complete
            for (int i = 0; i < maxPets; i++)
            {
                if (ourAnimals[i, 2] == "Age: ?" && ourAnimals[i, 0] != "ID #: ")
                {
                    do
                    {
                        Console.WriteLine($"Enter an age for {ourAnimals[i, 0]}");
                        readResult = Console.ReadLine();
                        if (readResult != null)
                        {
                            animalAge = readResult;
                            validEntry = int.TryParse(animalAge, out petAge);
                        }
                    } while (validEntry == false);
                    ourAnimals[i, 2] = "Age: " + animalAge.ToString();
                }

                if (ourAnimals[i, 4] == "Physical description: " && ourAnimals[i, 0] != "ID #: ")
                {
                    do
                    {
                        Console.WriteLine($"Enter a physical description for {ourAnimals[i, 0]} (size, color, gender, weight, housebroken)");
                        readResult = Console.ReadLine();
                        if (readResult != null)
                        {
                            animalPhysicalDescription = readResult.ToLower();
                            if (animalPhysicalDescription == "")
                            {
                                validEntry = false;
                            }
                            else
                            {
                                validEntry = true;
                            }

                        }
                    } while (validEntry == false);

                    ourAnimals[i, 4] = "Physical description: " + animalPhysicalDescription;
                }
            }
            Console.WriteLine("\n\rAge and physical description fields are complete for all of our friends. \n\rPress the Enter key to continue");
            readResult = Console.ReadLine();

            break;

        case "4":
            // Ensure animal nicknames and personality descriptions are complete
            for (int i = 0; i < maxPets; i++)
            {
                if (ourAnimals[i, 3] == "Nickname: " && ourAnimals[i, 0] != "ID #: ")
                {
                    do
                    {
                        Console.WriteLine($"Enter a nick name for {ourAnimals[i, 0]}");
                        readResult = Console.ReadLine();
                        if (readResult != null)
                        {
                            animalNickname = readResult.ToLower();
                            if (animalNickname == "")
                            {
                                validEntry = false;
                            }
                            else
                            {
                                validEntry = true;
                            }
                        }
                    } while (validEntry == false);
                    ourAnimals[i, 3] = "Nickname: " + animalNickname;
                }

                if (ourAnimals[i, 5] == "Personality: " && ourAnimals[i, 0] != "ID #: ")
                {
                    do
                    {
                        //"Enter a description of the pet's personality (likes or dislikes, tricks, energy level"
                        Console.WriteLine($"Enter a personality description for {ourAnimals[i, 0]} (likes or dislikes, tricks, energy level)");
                        readResult = Console.ReadLine();
                        if (readResult != null)
                        {
                            animalPersonalityDescription = readResult.ToLower();
                            if (animalPersonalityDescription == "")
                            {
                                validEntry = false;
                            }
                            else
                            {
                                validEntry = true;
                            }
                        }
                    } while (validEntry == false);

                    ourAnimals[i, 5] = "Personality: " + animalPersonalityDescription;
                }
            }
            Console.WriteLine("\n\rAge and physical description fields are complete for all of our friends. \n\rPress the Enter key to continue");
            readResult = Console.ReadLine();

            break;

        case "5":
            // Edit an animal’s age");
            do
            {
                Console.WriteLine("Enter id of animal (like d1, c2)");
                readResult = Console.ReadLine();
            } while (readResult == null || readResult.Length<2);

            animalID = readResult;
            for(int i = 0; i < maxPets; i++)
            {
                if (ourAnimals[i,0] == ("ID #: " + animalID))
                {
                    do
                    {
                        Console.WriteLine($"Enter an age for {ourAnimals[i, 0]}");
                        readResult = Console.ReadLine();
                        if (readResult != null)
                        {
                            animalAge = readResult;
                            validEntry = int.TryParse(animalAge, out petAge);
                        }
                    } while (validEntry == false);
                    ourAnimals[i, 2] = "Age: " + animalAge.ToString();
                    Console.WriteLine($"Age for Animal {ourAnimals[i, 0]} has updated to {ourAnimals[i, 2]}");
                    break;
                }
            }

            Console.WriteLine("Press the Enter key to continue.");
            readResult = Console.ReadLine();
            break;

        case "6":
            // Edit an animal’s personality description");
            do
            {
                Console.WriteLine("Enter id of animal (like d1, c2)");
                readResult = Console.ReadLine();
            } while (readResult == null || readResult.Length < 2);

            animalID = readResult;
            for (int i = 0; i < maxPets; i++)
            {
                if (ourAnimals[i, 0] == ("ID #: " + animalID))
                {
                    do
                    {
                        Console.WriteLine($"Enter a personality description for {ourAnimals[i, 0]} (likes or dislikes, tricks, energy level)");
                        readResult = Console.ReadLine();
                        if (readResult != null)
                        {
                            animalPersonalityDescription = readResult.ToLower();
                            if (animalPersonalityDescription == "")
                            {
                                validEntry = false;
                            }
                            else
                            {
                                validEntry = true;
                            }
                        }
                    } while (validEntry == false);

                    ourAnimals[i, 5] = "Personality: " + animalPersonalityDescription;
                    Console.WriteLine($"Personality for Animal {ourAnimals[i, 0]} has updated to {ourAnimals[i, 5]}");
                    break;
                }
            }

            Console.WriteLine("Press the Enter key to continue.");
            readResult = Console.ReadLine();
            break;
        
        case "7":
            // Display all cats with a specified characteristic
            //For each cat, combine the physical and personality descriptions to search
            do
            {
                Console.WriteLine($"\nEnter cat characteristics to search for separated by commas");
                readResult = Console.ReadLine();
            } while (readResult == null || readResult.Length < 2);

            characteristic = readResult.ToLower();

            string[] catSearches = characteristic.Split(",");
            // trim leading and trailing spaces from each search term
            for (int i = 0; i < catSearches.Length; i++)
            {
                catSearches[i] = catSearches[i].Trim();
            }

            Array.Sort(catSearches);

            bool matchesAnyCat = false;
            string catDescription = "";

            // loop through the ourAnimals array to search for matching animals
            for (int i = 0; i < maxPets; i++)
            {
                if (ourAnimals[i, 1].Contains("cat"))
                {
                    // Search combined descriptions and report results
                    catDescription = ourAnimals[i, 4] + "\n" + ourAnimals[i, 5];

                    bool matchesCurrentCat = false;

                    foreach (string term in catSearches)
                    {
                        // only search if there is a term to search for
                        if (term != null && term.Trim() != "")
                        {
                            for (int j = 2; j > -1; j--)
                            {
                                // #5 update "searching" message to show countdown
                                foreach (string icon in searchingIcons)
                                {
                                    Console.Write($"\rsearching our cat {ourAnimals[i, 3]} for {term.Trim()} {icon} {j.ToString()}");
                                    Thread.Sleep(100);
                                }

                                Console.Write($"\r{new String(' ', Console.BufferWidth)}");
                            }

                            // iterate submitted characteristic terms and search description for each term
                            if (catDescription.Contains(term.Trim()))
                            {
                                // #3b update message to reflect current search term match 

                                Console.WriteLine($"\rOur cat {ourAnimals[i, 3]} matches your search for {term.Trim()}");

                                matchesCurrentCat = true;
                                matchesAnyCat = true;
                            }
                        }
                    }

                    // if the current cat is match, display the cat's info
                    if (matchesCurrentCat)
                    {
                        Console.WriteLine($"\r{ourAnimals[i, 3]} ({ourAnimals[i, 0]})\n{catDescription}\n");
                    }
                }
            }

            if (!matchesAnyCat)
            {
                Console.WriteLine("None of our cat are a match found for: " + characteristic);
            }

            Console.WriteLine("Press the Enter key to continue.");
            readResult = Console.ReadLine();
            break;

        case "8":
            // Display all dogs with a specified characteristic
            //For each dog, combine the physical and personality descriptions to search
            do
            {
                Console.WriteLine($"\nEnter dog characteristics to search for separated by commas");
                readResult = Console.ReadLine();
            } while (readResult == null || readResult.Length < 2);

            characteristic = readResult.ToLower();

            string[] dogSearches = characteristic.Split(",");
            // trim leading and trailing spaces from each search term
            for (int i = 0; i < dogSearches.Length; i++)
            {
                dogSearches[i] = dogSearches[i].Trim();
            }

            Array.Sort(dogSearches);

            bool matchesAnyDog = false;
            string dogDescription = "";

            // loop through the ourAnimals array to search for matching animals
            for (int i = 0; i < maxPets; i++)
            {
                if (ourAnimals[i, 1].Contains("dog"))
                {
                    // Search combined descriptions and report results
                    dogDescription = ourAnimals[i, 4] + "\n" + ourAnimals[i, 5];

                    bool matchesCurrentDog = false;

                    foreach (string term in dogSearches)
                    {
                        // only search if there is a term to search for
                        if (term != null && term.Trim() != "")
                        {
                            for (int j = 2; j > -1; j--)
                            {
                                // update "searching" message to show countdown
                                foreach (string icon in searchingIcons)
                                {
                                    Console.Write($"\rsearching our dog {ourAnimals[i, 3]} for {term.Trim()} {icon} {j.ToString()}");
                                    Thread.Sleep(100);
                                }

                                Console.Write($"\r{new String(' ', Console.BufferWidth)}");
                            }

                            // iterate submitted characteristic terms and search description for each term
                            if (dogDescription.Contains(term.Trim()))
                            {
                                // update message to reflect current search term match 

                                Console.WriteLine($"\rOur dog {ourAnimals[i, 3]} matches your search for {term.Trim()}");

                                matchesCurrentDog = true;
                                matchesAnyDog = true;
                            }
                        }
                    }

                    // if the current dog is match, display the dog's info
                    if (matchesCurrentDog)
                    {
                        Console.WriteLine($"\r{ourAnimals[i, 3]} ({ourAnimals[i, 0]})\n{dogDescription}\n");
                    }
                }
            }

            if (!matchesAnyDog)
            {
                Console.WriteLine("None of our dogs are a match found for: " + characteristic);
            }

            Console.WriteLine("Press the Enter key to continue.");
            readResult = Console.ReadLine();
            break;

        default:
            break;
    }

} while (menuSelection != "exit");
