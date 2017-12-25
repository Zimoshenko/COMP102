// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

import ecs100.*;
import java.awt.Color;

/** Draws flags of various countries.
The correct dimensions of the official flags varies from country to country.
Many flags are 2/3 as high as they are wide.
It is fine to make it 1/2 as high as they are wide.
It is also fine on the flags of Bangladesh, Japan, etc to make the circles
exactly half the height of the flags.
The exact colours of the flags will also be difficult to match;
It is fine to use the standard colours: red, green, blue, orange.
You can find lots of details, including the correct dimensions and colours, of flags from
http://www.crwflags.com/fotw/flags/    

For each flag, there is a
    do....Flag method which asks the user for the width, then calls the 
    draw...Flag method with appropriate parameters.

 */
public class FlagExercise{

    public static final double TOP = 100;
    public static final double LEFT = 100;


    /**
     * Constructor: set up the user interface and buttons (already written for you)
     */ 
    public FlagExercise(){
        UI.clearPanes();
        UI.addButton("Clear", UI::clearGraphics );
        UI.addButton("indonesiaFlag", this::doIndonesiaFlag );
        UI.addButton("austriaFlag", this::doAustriaFlag );
        UI.addButton("japanFlag", this::doJapanFlag );
        UI.addButton("bangladeshFlag", this::doBangladeshFlag );
        UI.addButton("nigerFlag", this::doNigerFlag );
        UI.addButton("Quit", UI::quit);
    }

    //-----------------------------------------------------

    /**
     * Ask for the width, then call drawIndonesiaFlag
     */
    public void doIndonesiaFlag(){
        double width = UI.askDouble("How wide");
        this.drawIndonesiaFlag(width);

    }
    
    /**
     *  Draw a flag of Indonesia at (LEFT, TOP)
     *  The flag has two horizontal stripes:
     *  The top is red and the bottom is white.
     *  Calculate
     *   The height of the flag (2/3 of the width)
     */
public void drawIndonesiaFlag(double width){
        /*# YOUR CODE HERE */

    }

    //----------------------------------------------------------

    /**
     * Ask for the width, then call drawAustriaFlag
     */
    public void doAustriaFlag(){
        /*# YOUR CODE HERE */

    }

    /**
     *  Draw a flag of Austria at (LEFT, TOP)
     *  The flag has three horizontal stripes;
     *  the top and bottom are red and the middle is white.
     *  Calculate
     *   The height of the flag (2/3 of the width)
     */
    public void drawAustriaFlag(double width){
        /*# YOUR CODE HERE */

    }

    //-----------------------------------------------------

    /**
     * Ask for the width, then call drawJapanFlag
     */
    public void doJapanFlag(){
        /*# YOUR CODE HERE */

    }
        
    /**
     * Draw a Japanese flag with the specified width at (LEFT, TOP)
     *  The flag of Japan has a white background and a red circle in the middle.
     *  Calculate
     *   the height of the flag (2.0/3.0 of the width)
     *   the circle diameter (0.6 of the height)
     *   the left of the circle (half the width - half the diameter from the LEFT)
     *   the top of the circle (half the height - half the diameter from the TOP)
     */
    public void drawJapanFlag(double width){
        double height = width*2.0/3.0;
        /*# YOUR CODE HERE */

    }

    //----------------------------------------------------------

    /**
     * Ask for the width, then call drawBangladeshFlag
     */
    public void doBangladeshFlag(){
        /*# YOUR CODE HERE */

    }

    /**
     * Draw a flag of Bangladesh at (LEFT, TOP)
     * The flag has a green background and a red circle in the middle
     * Calculate
     *  height of the flag (3.0/5.0 of the width)
     *  diameter of the circle (0.2 of the width)
     *  left of the circle (0.25 of the width from LEFT)
     *  top of the circle (0.1 of the width from TOP)
     */
    public void drawBangladeshFlag(double width){
        /*# YOUR CODE HERE */

    }

    //-------------------------------------------------------
    
    /**
     * Ask for the width, then call drawNigerFlag
     */

    public void doNigerFlag(){
        /*# YOUR CODE HERE */

    }

    /**
     * Draw a flag of Ngier at (LEFT, TOP)
     * The flag has three horizontal stripes: orange, white, green,
     *  and an orange circle in the middle of the middle stripe.
     * Calculate
     *  the height (6.0/7.0 of the width)
     *  the height of the stripes (height/3.0)
     *  the diameter of the circle (0.28 of the height)
     *  the left of the circle
     *  the top of the circle 
     */
        /*# YOUR CODE HERE */

    }


}
