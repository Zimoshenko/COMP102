// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a ${course} assignment.
// You may not distribute it in any other way without permission.
/* Code for ${course} - 2017T2
* Name:
* Username:
* ID:
*/
import ecs100.*;
import java.awt.Color;

/** A PartyBalloon object represents a small round balloon on the graphics pane.
 *   It remembers its current position and its color.
 *   Its initial position and its color are set when it is constructed
 *   The diameter of a balloon should be 30.
 *   It has three methods:
 *        draw(),         which draws the balloon at its current position
 *        riseLeft(),  which makes the balloon rise up by 20, and move 5 to the left
 *        riseRight(), which makes the balloon rise up by 20, and move 5 to the right
 */
public class PartyBalloon{

    //fields
    /*# YOUR CODE HERE */
    private Color color;
    private double xPos;
    private double yPos;
    private double size = 30;
    /** Constructor: passed the intial position and color.
        * Initialises the fields
        */
    public PartyBalloon(double x, double y, Color col){
    /*# YOUR CODE HERE */
    this.xPos=x;
    this.yPos=y;
    this.color=col;
    }

    /** draw method (no parameters):
        * draws the balloon at its current position, of the right colour.
        */
    public void draw(){
    /*# YOUR CODE HERE */
     UI.setColor(this.color);
     UI.fillOval(this.xPos,this.yPos,this.size,this.size);
     
    }	

    /** riseLeft method (no parameters):
        * changes the position of the balloon up and to the left
        * Does not erase or redraw!!
        */
    public void riseLeft(){
    /*# YOUR CODE HERE */
     this.xPos = this.xPos - 5;
     this.yPos = this.yPos - 20;
     
    }	

    /** riseRight method (no parameters):
        * Makes balloon move up and to the right
        * Does not erase or redraw
        */
    public void riseRight(){
    /*# YOUR CODE HERE */
      this.xPos = this.xPos + 5;
      this.yPos = this.yPos - 20;
    }	
}
