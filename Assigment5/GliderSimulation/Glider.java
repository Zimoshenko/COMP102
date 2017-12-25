// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a ${course} assignment.
// You may not distribute it in any other way without permission.
/* Code for ${course} - 2017T2
* Name:???
* Username:xmut_1624092211
* ID:1624092211
*/
import ecs100.*;
import java.awt.Color;
import java.util.*;

/** Glider represents a paper glider that flies
 *  The glider must store
 *    - its current position (x and height above the floor) and
 *    - its speed (the size of the horizontal step in each move) 
 *
 *  Each time the move() method is called, it will take one step:
 * 
 *  Unlike CartoonCharacter, a Glider does NOT draw itself each time it moves.
 *  
 */

public class Glider{

    public static final double HORIZ_SIZE = 48;   // horizontal size of all gliders
    public static final double VERT_SIZE = 12;    // vertical size of all gliders
    public static final double FLOOR = 400;          // position of the floor
    public static final double MID_SPEED = 6;  // speed at which gliders neither fall nor rise
    public static final double CEILING=350;
    // Fields to store position and speed (ie, the horizontal step size)
    /*# YOUR CODE HERE */
   double height;
   private double speed;
   private double x=0;
   int success = 0;
    // Constructor
    /**
        * Construct a new Glider object.
        * Parameters are
        *  - the initial height above the ground, and
        *  - the initial speed to the right
        * Note, all gliders start at horizontal position 0
        * Stores the parameters into fields,
        */
    public Glider(double ht, double sp){
           /*# YOUR CODE HERE */
           this.height=ht;
           this.speed=sp;
    }

    // Methods
    /** Move the glider one step:
        *  - If its height is 0, then it cannot change its position at all
        *  - Otherwise, it will move forward by the amount of its speed.
        *    - If its speed equals MID_SPEED, then it doesn't rise or fall.
        *    - If it is going slower than MID_SPEED, then it will fall towards the floor.
        *    - If it is going faster than MID_SPEED, then it will rise upwards
        *  The faster it is going, the faster it should rise
        * DO NOT REDRAW THE GLIDER!!!
        */
    public void move(){
           /*# YOUR CODE HERE */

           if(this.height>=0){
            if(this.speed==MID_SPEED){
                 this.x = this.x + this.speed;
            }else if(this.speed>MID_SPEED){
                this.x=this.x+this.speed;
                this.height=this.height+this.speed*0.3;
            }else if(this.speed<MID_SPEED){
                this.x=this.x+this.speed;
                this.height=this.height-this.speed*0.3;
            }
            }else{
            this.speed=0;
            }
       }
       
   

    /**
        * Draw the glider in its current position.
        * Use  UI.drawImage("glider.png", .....) to draw the glider.
        * Note that you will need to convert the height of the glider above the floor into
        * a distance down from the top of the screen to say where to draw the image.
        */
    public void draw(){           
            /*# YOUR CODE HERE */ 
           double yPosition=Glider.FLOOR-this.height;
           UI.drawImage("glider.png",this.x,yPosition,HORIZ_SIZE, VERT_SIZE);
    }

    /** Return the current x position of the glider */
    public double getX(){
           /*# YOUR CODE HERE */           
           return this.x+HORIZ_SIZE;
    }

    /** Return the current height of the glider */
    public double getHeight(){
           /*# YOUR CODE HERE */
           return this.height+VERT_SIZE;
    }

    /** Change the speed of the glider */
    public void setSpeed(double sp){
           /*# YOUR CODE HERE */
          this.speed=sp;
    }
    
       public void GoFaster(double sp){
      speed=speed+2;
    } 

        public void GoSlower(double sp){
      speed=speed-2;
    }
    //--------- TESTING ------------------------------------------
    /** A method to help test your code: You can run it using bluej
        */
    public static void test(){
           double tooFar = 400;
           double tooHigh = 300;
           UI.clearPanes();
           double speed = Math.random()*15;
           double h = 100 +Math.random()*(tooHigh-150);
           UI.printf("Creating a glider, speed=%.2f, ht = %.2f\n",speed, h);
           Glider glider = new Glider(h, speed);
           UI.setColor(Color.black);

           UI.drawRect(0, FLOOR-tooHigh, tooFar, tooHigh);

           glider.draw();

           UI.println("Moving the glider.");

           int step=0;
           while (step<300) {
                  glider.move();

                  UI.clearGraphics();
                  glider.draw();
                  UI.drawRect(0, FLOOR-tooHigh-VERT_SIZE, tooFar, tooHigh+VERT_SIZE);

                  if (glider.getX()> tooFar){
                         UI.println("Glider TOO FAR: "+ glider.getX());
                         break;
                  }
                  if (glider.getHeight() >= tooHigh) {
                         UI.println("Too High: "+ glider.getHeight() + ", slowing down");
                         glider.setSpeed(3);
                  }
                  if (glider.getHeight() == 0) {
                         UI.println("On ground. Shouldn't move any more");
                         if (step>150) { break; }
                  }

                  UI.sleep(40);
                  step++;
           }
           UI.println("Test completed.");
    }


}
