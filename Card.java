/**
 * This class creates card objects.
 * @Michael Chadwick
 * @4/8/2020
 */

import java.util.*;
public class Card implements Comparable<Card>
{
    private String type;
    private char color;
    private int cNum;

    /**
     * Default constructor for objects of class Card.
     */
    public Card()
    {

    }

    /**
     * Constructs a new card object with the passed values
     * @param type, color, cNum - the card's type, color, and collectors number.
     */
    public Card(String type, char color, int cNum)
    {
        this.type = type;
        this.color = color;
        this.cNum = cNum;
    }
    
    /**
     * Gets the cards type.
     * @return type - returns the card's type.
     */
    public String getType()
    {
        return this.type;
    }
    
    /**
     * Sets the cards type.
     * @param type - sets the cards type.
     */
    public void setType(String type)
    {
        this.type = type;
    }
    
    /**
     * Gets the cards color.
     * @return color - returns the card's color.
     */
    public char getColor()
    {
        return this.color;
    }
    
    /**
     * Sets the cards color.
     * @param color - sets the cards color.
     */
    public void setColor(char color)
    {
        this.color = color;
    }
    
    /**
     * Gets the card's collectors number.
     * @return cNum - returns the card's collectors number.
     */
    public int getCNum()
    {
        return this.cNum;
    }
    
    /**
     * Sets the card's collectors number.
     * @param cNum - sets the cards collectors number.
     */
    public void setCNum(int cNum)
    {
        this.cNum = cNum;
    }
    
    /**
     * Compares a two cards in the linked list for validity.
     * @param otherCard - copmares it's collectors number with the other cards.
     * @return cNum - returns the card's collectors number minus the compared card.
     */
    @Override
    public int compareTo(Card otherCard)
    {
        return cNum - otherCard.cNum;
    }
    
    /**
     * Formats a card'd values in columnar form.
     * @return String - formats and returns the card's values.
     */
    public String toString()
    {
        return String.format("%8d %-15s %-8c",cNum, type, color); 
    }
}
