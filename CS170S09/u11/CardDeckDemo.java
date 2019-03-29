import acm.program.*;
import acm.graphics.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Using an Deck class to represent cards.
 * 
 * @author Stephen Gilbert
 * @version Spring 2008
 */

public class CardDeckDemo extends GraphicsProgram
{
    // Cards and decks
    private int cardsRemaining;
    
    // Create Deck variable and a Deck object.
    Deck deck = new Deck();
    
    /**
     * The deck pile just shows the back of the deck.
     * Click the deck to deal a card.
     */
    private GImage deckPile;

    /**
     * The cardPile is the container that will hold the
     * cards as they are dealt on the table
     */
    private GCompound cardPile = new GCompound();
    
    
    /**
     * The newDeck() method.
     * Populate the deck of cards with 52 unshuffled cards.
     * Call removeAllCards() on your deck.
     * Use the new-style for loop.
     */
    public void newDeck()
    {

        deck.removeAllCards();
        
        for (Rank rank : Rank.values())
            for (Suit suit : Suit.values())
            {
                deck.addCard(new PlayingCard(rank, suit));
            }
    }
    
    /**
     *  shuffle(): shuffle a deck of cards.
     *  Shuffle's the deck using the Collections method.
     */
    public void shuffle()
    {
        deck.shuffle();
    }
    
 
    /**
     * Handle the button clicks
     */
    public void actionPerformed(ActionEvent e)
    {
        Object clicked = e.getSource();
        
        // Adding a new deck to the table
        if (clicked == newDeckBtn)
        {
            // Call the newDeck() method to clear the deck
            newDeck();
            
            showStatus();

            if (deckPile == null)
            {
                deckPile = new GImage("b.gif");
                GCanvas c = this.getGCanvas();
                int x = c.getWidth() / 2 - (int) (deckPile.getWidth()) - 10;
                int y = c.getHeight() / 2 - ((int) (deckPile.getHeight()) / 2);
                
                add(deckPile, x, y);
                cardPile.removeAll();
                add(cardPile, x + deckPile.getWidth() + 20, y);
            }
            
            newDeckBtn.setEnabled(false);
            shuffleDeckBtn.setEnabled(true);
        }
        else if (clicked == shuffleDeckBtn)
        {
            // Shuffle the cards
            deck.shuffle();
        }
    }
    
    
    /**
     * Deal a card from the top of the deck.
     */
    public void mouseClicked(MouseEvent e)
    {
        // Get the mouse location
        int x = e.getX();
        int y = e.getY();
        
        // Find the object under the mouse click
        GObject obj = getElementAt(x, y);
        
        // Only deal a card if clicking on the deck pile 
        if (obj == deckPile)
        {
            PlayingCard top = deck.dealCard();
            if (top != null)
            {
                top.flip();
                cardPile.add(top);
            }
            
            showStatus();

            // If we've dealt all the cards, remove the 
            // deck pile from the table.
            if (deck.getCardsRemaining() == 0)
            {
                deckPile.setImage("e.gif");
                deckPile = null;
                newDeckBtn.setEnabled(true);
            }           
        }
    }
    
   
    /**
     * The standard Java entry point. DON'T MODIFY THIS METHOD.
     */
    public static void main(String[] args)
    {
        new CardDeckDemo().start(args);
    }

    /**
     * Initialize the user interface
     */
    public void init()
    {
        // Set the table color to a dark green
        setBackground(new Color(0, 128, 0));
        
        // Initialize the GUI
        newDeckBtn = new JButton("New Deck");
        shuffleDeckBtn = new JButton("Shuffle");
        statusLbl = new JLabel("Welcome to CardDeckDemo");
        
        shuffleDeckBtn.setEnabled(false);

        add(newDeckBtn, SOUTH);
        add(shuffleDeckBtn, SOUTH);
        add(statusLbl, NORTH);

        addActionListeners();
        addMouseListeners();
    }

    /**
     *  Show the number of cards remaining. 
     */
    public void showStatus()
    {
        statusLbl.setText("Cards Left: " + deck.getCardsRemaining());
    }

    /**
     * User interface controls
     */
    private JButton newDeckBtn;         // Adding a new deck
    private JButton shuffleDeckBtn;     // Shuffling the deck
    private JLabel statusLbl;           // Display the status

    public static final int APPLICATION_WIDTH = 350;
    public static final int APPLICATION_HEIGHT = 250;
}
