/**
 * This program tests the Card and CardCollection classes
 * @Michael Chadwick
 * @4/8/2020
 */
import java.util.Scanner;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.lang.String;
public class TestProgram
{
    /**
     * Creates a initial linked list of card objects. Prompts the user with the options to add, remove, find, modify, sort the linked list. As well as exit the program.
     */
    public static void main(String[] args)
    {
        CardCollection myCollection = new CardCollection();
        Scanner myScanner = new Scanner(System.in);
        try
        {
            myCollection.add(new Card("Creature", 'W', 1));
            myCollection.add(new Card("Enchantment", 'U', 2));
            myCollection.add(new Card("Sorcery", 'B', 3));
            myCollection.add(new Card("Instant", 'R', 4));
            myCollection.add(new Card("Planeswalker", 'G', 5));
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        boolean run = true;
        while(run)
        {
            System.out.printf("%-8s %-15s %-8s \n", "ID", "Type", "Color"); 
            System.out.println(myCollection.toString());
            System.out.println("Choose from the options below: ");
            System.out.println("\n 1 - add card \n 2 - remove card \n 3 - find card \n 4 - sort collection \n 5 - change \n 6 - exit program");
            String choice = myScanner.nextLine();
            try
            {
                switch(choice)
                {
                    case "1": 
                    System.out.println("What type of card is it?");
                    String type = myScanner.nextLine();
                    if(type.length() == 0)
                    {
                        throw(new IOException("You must enter a type."));
                    }
                    System.out.println("What is the color of the card? \n W - White, U - Blue, B - Black, R - Red, or G - Green");
                    String colorString = myScanner.nextLine();
                    char color;
                    if(colorString.equals("W") || colorString.equals("w") || colorString.equals("U") || colorString.equals("u") || colorString.equals("B") || colorString.equals("b") 
                    || colorString.equals("R") || colorString.equals("r") || colorString.equals("G") ||colorString.equals("g"))
                    {
                        color = colorString.charAt(0);
                        color = Character.toUpperCase(color);
                    }  
                    else
                    {
                        throw(new IOException("Color can only be W, U, B, R, or G."));
                    }
                    System.out.println("What is it's collector's number?");
                    int cNum= myScanner.nextInt();
                    myScanner.nextLine();
                    Card card = new Card(type, color, cNum);
                    myCollection.add(card);
                    System.out.print('\u000C');
                    break;

                    case "2":
                    System.out.println("What's the cards collector number you wish to remove?");
                    cNum = myScanner.nextInt();
                    myScanner.nextLine();
                    myCollection.remove(cNum);
                    System.out.print('\u000C');
                    break;

                    case "3":
                    System.out.println("What's the collector number of the card you wish to find?");
                    cNum = myScanner.nextInt();
                    myScanner.nextLine();
                    if(myCollection.find(cNum) == null)
                        throw(new Exception("Card doesn't exist."));
                    System.out.print('\u000C');
                    System.out.println("The card with that collector's number is: \n" + myCollection.find(cNum) + "\n");
                    break;

                    case "4":
                    System.out.println("The sorted collection is: \n");
                    myCollection.sort();
                    System.out.print('\u000C');
                    break;

                    case "5":
                    System.out.println("What's the collector number of the card you wish to change?");
                    cNum = myScanner.nextInt();
                    myScanner.nextLine();
                    if(myCollection.find(cNum) == null)
                        throw(new Exception("Card doesn't exist."));
                    System.out.println("Cards current values: \n" + myCollection.find(cNum));
                    System.out.println("What do you wish to change the type of the card to?");
                    type = myScanner.nextLine();
                    if(type.length() == 0)
                    {
                        throw(new IOException("You must enter a type."));
                    }
                    System.out.println("What color do you wish to change the card to? \n W - White, U - Blue, B - Black, R - Red, or G - Green");
                    colorString = myScanner.nextLine();
                    if(colorString.equals("W") || colorString.equals("w") || colorString.equals("U") || colorString.equals("u") || colorString.equals("B") || colorString.equals("b") || colorString.equals("R") ||
                    colorString.equals("r") || colorString.equals("G") ||colorString.equals("g"))
                    {
                        color = colorString.charAt(0);
                        color = Character.toUpperCase(color);
                    }  
                    else
                    {
                        throw(new IOException("Color can only be W, U, B, R, or G."));
                    }
                    myCollection.modifyCard(type, color, cNum);
                    System.out.print('\u000C');
                    break;

                    case "6":
                    System.out.print('\u000C');
                    System.out.printf("%-8s %-15s %-8s \n", "ID", "Type", "Color"); 
                    System.out.println(myCollection.toString());
                    System.out.println("Choose from the options below: ");
                    System.out.println("\n 1 - add card \n 2 - remove card \n 3 - find card \n 4 - sort collection \n 5 - change \n 6 - exit program");
                    run = false;
                    break;

                }
            }
            catch(Exception ex)
            {
                System.out.print('\u000C');
                System.out.println(ex.getMessage());
            }
        }
    }
}