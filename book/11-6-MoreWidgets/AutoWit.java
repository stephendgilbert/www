import acm.program.*;
import java.awt.event.*; 
import javax.swing.*;
/**
 * Using the JComboBox class.
 * 
 * @author Steve Gilbert
 * @version Fall 2011
 */
public class AutoWit extends ConsoleProgram
{ 
    private JComboBox person;
    private JComboBox verb;
    private JComboBox adverb;
    
    private JButton phrase = new JButton("Construct Phrase"); 
    
    /**
     * Create three JComboBoxes and a button
     */
    public void init() 
    { 
        // Set the font to a large font.
        setFont("Consolas-bold-22");
        
        // People
        String[] people = {
            "Fred", "Wilma", "Barney", "Betty", "BamBam", "Dino"
        };
        person = new JComboBox(people);
        
        // Verbs
        String[] verbs = {
            "dances", "dines", "sings", "draws", "whines", "drives"
        };
        verb = new JComboBox(verbs);
        verb.setSelectedIndex(2);
       
        // Adverbs
        String[] adverbs = {
            "divinely", "hungrily", "quickly", "sublimely", "awkwardly"
        };
        adverb = new JComboBox(adverbs);
        adverb.setSelectedItem("sublimely");
        
        // Add to the north panel
        add(person, NORTH);
        add(verb, NORTH);
        add(adverb, NORTH);
        add(phrase, NORTH); 
        
        // Hook up the action listeners
        addActionListeners();
    }
    
    /**
     * Construct a phrase when clicked.
     */
    public void actionPerformed(ActionEvent ae) 
    { 
        // Only take action when the phrase button is pressed
        if (ae.getSource() == phrase)
        {
            println(person.getSelectedItem()+" "+ 
                    verb.getSelectedItem() + " "+ 
                    adverb.getSelectedItem()); 
        }
    } 
    
    /**
     * Set the look and feel before starting.
     */
    public static void main(String[] args)
    {
        LAF.setSystemLAF();
        new AutoWit().start(args);
    }
} 