/* Code for COMP102
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;

/** Lets the user place colored words on the window using the mouse.
 *  The program has a textfield where the user can enter a word, and the
 *   program will store the word in a field
 *   (Note: it doesn't draw anything yet).
 *  When the user clicks the mouse, the program draws the word in the field
 *   at the position the mouse was released, using UI.drawString(...)
 *  The program has a button to let the user change the color. It uses JColorChooser
 *   and UI.setColor(...)
 */
public class WordsExercise{

    // Fields to remember the current word
    private String word = "---";

    /** Set up the user interface: set mouse listener, textfield and buttons.
     */
    public WordsExercise(){
        UI.setMouseListener( this::doMouse );
        UI.addButton("Clear", UI::clearGraphics);
        UI.addTextField("Set Word", this::doSetWord );
        UI.addButton("Set Color", this::setColor);
        UI.addButton("Set FontSize = 24", this::setSize1);
        UI.addButton("Set FontSize = 36", this::setSize2);
        UI.addButton("Quit", UI::quit);
    }

    public void doSetWord(String v){
	/*# YOUR CODE HERE */
        this.word = v;
	/*# END OF YOUR CODE */

    }

    /* Set the UI color to the value chosen by the user */
    public void setColor(){
	/*# YOUR CODE HERE */
        UI.setColor(JColorChooser.showDialog(null, "Choose Color", null));
	/*# END OF YOUR CODE */

    }
    public void setSize1(){
        UI.setFontSize(24);
        
    }
    
    public void setSize2(){
        UI.setFontSize(36);
        
    }
    // ANS CODE HERE
    /* Alternative buttons for the constructor, which doesn't need the helper methods.
    UI.addButton("Set Center", () -> { this.choosingCenter = true; } );
    UI.addButton("Set Points", () -> { this.choosingCenter = false; } );
    UI.addButton("Set Color", () -> {UI.setColor(JColorChooser.showDialog(null, "Choose Color", null)); } );
     */
    // END OF ANS CODE

    /** Respond to mouse released events.
     * Draw the current word If currently choosing a center, then remember the position and draw a small
    circle at the point.
    Othewise, draw a line from the current center to this point
     */
    public void doMouse(String action, double x, double y){
	/*# YOUR CODE HERE */
        if (action.equals("released")){
	    UI.drawString(this.word, x, y);
	}
	/*# END OF YOUR CODE */

    }

    public static void main(String[] args){
        new WordsExercise();
    }	

}
