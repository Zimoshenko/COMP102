/* Code for COMP 102    
 * Name:
 * ID:
 */

import ecs100.*;
import java.awt.Color;


/** BouncingBall represents a ball that falls towards the ground and bounces up again.
 *  Each time the move() method is called, it will take one step.  
 *  The ball must store its current position and the state, and the canvas it is drawn on.
 *  The state must include the current position, and its current speed
 *  (ie, the size of step in horizontal and vertical directions that it will take in each move) 
 *  For the extension, it needs to store its colour, size, or whatever you choose to change each time.
 *
 *  It has a method to make it move from its current position.
 *  For the extension, every time it moves, it will change its size,
 *  shape, or colour a little
 */

public class BouncingBall{

    public static final int RADIUS = 15;   // Radius of all the balls.

    // Fields to store
    //   the state of the ball:        position and speed
    //   other values for the ball: colour, size
    /*# YOUR CODE HERE */
    private double x = RADIUS;     // x position of the center of the ball
    private double height;    // height of the center of the ball above the ground
                          // (not the same as the y coordinate of where to draw the ball!!!)
    private double stepHoriz;    //size of the horizontal step (positive to the right)
    private double stepV = 0;  // size of the vertical step (positive upwards, negative downwards)

    private Color col;
    private double bounce;    // bounciness of the ball.
    /*# END OF YOUR CODE */

    // Constructor
    /**
     * Construct a new BouncingBall object.
     * Parameters are the initial horizontal position and height above the ground, and
     * the initial speed (ie, the horizontal step size). Positive is to the right
     * Stores the parameters into fields,
     * and initialises the other fields. 
    */
    public BouncingBall(double x, double h, double sp){
        /*# YOUR CODE HERE */
        this.x = x;
        this.height = h;
        this.stepHoriz = sp;
        this.col = Color.getHSBColor((float)Math.random(),1,1);
	this.bounce = 0.5+Math.random()*0.5;   //anywhere from .5 to .999
        /*# END OF YOUR CODE */
 
    }


    // Methods

    /** Move the shape one step:
     * Change its height and x position using the vertical and horizonal steps
     * Decrease the vertical step size by 0.3 (this is the effect of gravity)
     * If it has gone below the floor, then "bounce":
     *   sets its height so the ball is on the floor, and
     *   invert the vertical step size (to make it go upwards).
     *   Completion: reduce the vertical step size by some amount to represent the lost energy
     *       (even better, give each ball a different bounciness)
     * DO NOT ERASE OR DRAW THE BALL!!! - just change the values in the fields. 
    */
    public void move(){
        /*# YOUR CODE HERE */

        this.height = this.height + this.stepV;
        this.x = this.x + this.stepHoriz;
        this.stepV = this.stepV - 0.3;

        if (this.height < RADIUS){
            this.height = RADIUS;
            this.stepV = - (this.stepV * this.bounce);
        }
        /*# END OF YOUR CODE */

    }

    /**
     * Draw the ball in its current position.
     * Note that you will need to convert from the height of the ball above the floor into
     * a distance down from the top of the screen. 
    */
    public void draw(){
        double y = Bouncer.FLOOR - this.height;  // work out the position of the center on the window.
        /*# YOUR CODE HERE */
        UI.setColor(this.col);
        UI.fillOval(this.x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
        /*# END OF YOUR CODE */

    }


    /**
     * Make the ball bounce in the horizontal direction by
     * moving it backwards one step and then reversing its horizontal speed
    */
    public void bounceHoriz(){
        /*# YOUR CODE HERE */
        this.x = this.x - this.stepHoriz;
        this.stepHoriz = this.stepHoriz * -0.9;
        /*# END OF YOUR CODE */

    }

    /** Return the current x position of the ball */
    public double getX(){
	// DRAFT CODE HERE
        if (true)   // just to make it compile
	// END OF DRAFT CODE 
        /*# YOUR CODE HERE */
	return this.x;
        /*# END OF YOUR CODE */

        return 10;   //This is wrong!! but it will make the code compile until you replace it.
    }


//--------- TESTING ------------------------------------------

    /** A method to help test your code: Use right click on the BouncingBall class in BlueJ
    */
    public static void test(){
        BouncingBall ball = new BouncingBall(200, 150, 2);
        ball.draw();
        UI.setColor(Color.black);
        UI.drawString("x position = "+ ball.getX(), 10, 20);
        UI.drawLine(0, Bouncer.FLOOR, Bouncer.RIGHT, Bouncer.FLOOR);
        UI.println("Ball should be on the window\n x position should = 200.0");
        UI.askBoolean("Now move it?");
        
        for (int i=0; i<10; i++){
            ball.move();
            UI.clearGraphics();
            ball.draw();
            UI.drawLine(0, Bouncer.FLOOR, 600, Bouncer.FLOOR);
            UI.sleep(50);
        }
        UI.setColor(Color.black);
        UI.drawString("x position = "+ ball.getX(), 10, 20);
        UI.println("Ball should have moved down and to the right\n\nx position should = 220.0");
        UI.askBoolean("Now make it bounce?");
        for (int i=0; i<70; i++){
            ball.move();
            UI.clearGraphics();
            ball.draw();
            UI.drawLine(0, Bouncer.FLOOR, 600, Bouncer.FLOOR);
            UI.sleep(50);
        }
        UI.println("Ball should have bounced on the ground \n at least once and be falling again|");
        UI.askBoolean("Now make it bounce to the left?");
        ball.bounceHoriz();
        for (int i=0; i<180; i++){
            ball.move();
            UI.clearGraphics();
            ball.draw();
            UI.drawLine(0, Bouncer.FLOOR, 600, Bouncer.FLOOR);
            UI.sleep(50);
        }
        UI.println("Ball should have bounced towards the left side");
        UI.askString("Test completed.");
    }

    // DRAFT CODE HERE
    public static void main(String[] args){
        test();
	new Bouncer();
    }
    // END OF DRAFT CODE 


}
