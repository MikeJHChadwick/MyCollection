/**
 *This class creates a linked list of to store card objects.
 * @Michael Chadwick
 * @4/8/2020
 */
import java.util.*;
public class CardCollection
{
    private LinkedList<Card> collection;

    /**
     * Constructor for objects of class CardCollection
     */
    public CardCollection()
    {
        collection = new LinkedList<Card>();
    }

    /**
     * Checks the collection linked list to see if a given card is in the list.
     * @param cNum - the card's collectors number.
     * @return card, null - returns the card object if it's in the linked list and null if it isn't.
     */
    public Card find(int cNum)
    {
        for(Card card : collection)
        {
            if(card.getCNum() == cNum)
            {
                return card;
            }
        }
        return null;
    }

    /**
     * Sorts the collection linked list.
     */
    public void sort()
    {
        Collections.sort(collection);
    }

    /**
     * Call the find method to check if the card that the user wishes to remove exists, then executes if it does or throwsan exception if it's false.
     * @param cNum - the card's collectors number.
     */
    public void remove(int cNum) throws Exception
    {
        Card card = find(cNum);
        if(card == null)
            throw(new Exception("Card doesn't exist."));
        collection.remove(card);
    }

    /**
     * Adds a card to the collection if its collectors number is valid.
     * @param card - checks if card object is in the linked list before adding it.
     */
    public void add(Card card) throws Exception
    {
        if(find(card.getCNum()) == null)
        {
            collection.add(card);
        }
        else
            throw(new Exception("Card with that collector's number already exists.\n"));
    }

    /**
     * Modifies a card's color and/or type in the linked list after verifying its existence.
     * @param type, color, cNum - modifies a card's type, color after checking its collectors number.
     */
    public void modifyCard(String type, char color, int cNum) throws Exception
    {
        Card card = find(cNum);
        if(card == null)
            throw(new Exception("Card doesn't exist."));
        card.setColor(color);
        card.setType(type);
    }

    /**
     * Creates a card list string by adding card objects from the collection.
     * @return cardList - returns the collection as a string.
     */
    public String toString()
    {
        String cardList = "";
        for(Card card : collection)
        {
            cardList += card.toString(); 
            cardList += "\n";
        }
        return cardList;
    }
}
