// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for Assignment 1
 * Name:纪倩琳
 * ID:1624092211
 */

import ecs100.*;
import java.awt.Color;

/**
 * Draws various flags
 *
 */
public class FlagDrawer{

    public static final double TOP = 100;
    public static final double LEFT = 50;

    /** Constructor, sets up the user interface */
    public FlagDrawer(){
        UI.initialise();

        // CORE
        UI.addButton("Core: Flag of Denmark", this::doDenmarkFlag);
        UI.addButton("Core: Flag of Greece", this::doGreeceFlag);

        // COMPLETION
        UI.addButton("Completion: Pacman Flag", this::doPacmanFlag);

        // CHALLENGE
        UI.addButton("Challenge: Flag of China", this::doChinaFlag);

        UI.addButton("Clear", UI::clearGraphics);
        UI.addButton("Quit", UI::quit);
    }

    /**
     * Core: The flag for Denmark
     */
    public void doDenmarkFlag() {
        /*# YOUR CODE HERE */
       double width = UI.askDouble("Your wide = "); 
       this.drawDenmarkFlag(width);
    }

    public void drawDenmarkFlag(double width){
        /*# YOUR CODE HERE */
        double hight= 28*width/37;
        UI.setColor(Color.red.darker());
        UI.fillRect(LEFT,TOP,width,hight);
        double a = hight/7; 
        UI.setColor(Color.white);
        UI.fillRect(LEFT+3*a,TOP,a,hight);
        UI.fillRect(LEFT,TOP+3*a,width,a);
    }

    //-------------------------------------------------------

    /**
     * Core: The flag for Greece
     */
    public void doGreeceFlag() {
        /*# YOUR CODE HERE */
       double width = UI.askDouble("Your wide = "); 
       this.drawGreeceFlag(width);
    }

    public void drawGreeceFlag(double width){
        /*# YOUR CODE HERE */
        double hight=2*width/3;
        UI.setColor(Color.white);
        UI.fillRect(LEFT,TOP,width,hight);
        UI.setColor(Color.blue);
        double b = hight/9;
        UI.fillRect(LEFT,TOP,width,b);
        UI.fillRect(LEFT,TOP+b*2,width,b);
        UI.fillRect(LEFT,TOP+b*4,width,b);
        UI.fillRect(LEFT,TOP+b*6,width,b);
        UI.fillRect(LEFT,TOP+b*8,width,b);
        UI.fillRect(LEFT,TOP,5*b,5*b);
        UI.setColor(Color.white);
        UI.fillRect(LEFT+2*b,TOP,b,5*b);
        UI.fillRect(LEFT,TOP+2*b,5*b,b);
    }

    //-------------------------------------------------------
    /**
     * Completion: pacman
     * A red pacman on a black background chasing blue, green, and white dots.
     */
    public  void doPacmanFlag() {
        /*# YOUR CODE HERE */
        double width = UI.askDouble("Your wide = "); 
       this.drawPacmanFlag(width);
    }

    public void drawPacmanFlag(double width){
        /*# YOUR CODE HERE */
        double hight=2*width/3;
        UI.setColor(Color.black);
        UI.fillRect(LEFT,TOP,width,hight);
        UI.setColor(Color.blue);
        UI.fillOval(LEFT+width/7,TOP+hight/2,width/25,width/25);
        UI.setColor(Color.pink);
        UI.fillOval(LEFT+2.5*width/7,TOP+hight/2,width/25,width/25);
        UI.setColor(Color.orange);
        UI.fillOval(LEFT+4*width/7,TOP+hight/2,width/25,width/25);
        UI.setColor(Color.yellow);
        UI.fillOval(LEFT+5*width/7,TOP+2*hight/5,width/5,width/5);
        UI.setColor(Color.black);
        UI.fillArc(LEFT+5*width/7,TOP+2*hight/5, width/5,width/5, 135,80);
    }
    
    /**
     * Challenge: China
     * Five yellow stars on a red background
     */
    public  void doChinaFlag() {
        /*# YOUR CODE HERE */
        UI.setColor(Color.red);
        UI.fillRect(LEFT,TOP,600,400);
        UI.setColor(Color.yellow);
        UI.fillOval(LEFT+50,TOP+50,85,85);
        UI.setColor(Color.red);
        UI.fillArc(LEFT+45,TOP+45,70,70,74,108);
        UI.fillArc(LEFT+40,TOP+65,70,70,145,108);
        UI.fillArc(LEFT+55,TOP+75,70,70,218,108);
        UI.fillArc(LEFT+70,TOP+65,70,70,291,108);
        UI.fillArc(LEFT+65,TOP+45,70,70,0,108);
        UI.setColor(Color.yellow);
        UI.fillOval(LEFT+187,TOP+33,43,43);
        UI.setColor(Color.red);
        UI.fillArc(LEFT+186,TOP+31,35,35,75,108);
        UI.fillArc(LEFT+184,TOP+39,35,35,145,108);
        UI.fillArc(LEFT+190,TOP+43,35,35,218,108);
        UI.fillArc(LEFT+196,TOP+39,35,35,291,108);
        UI.fillArc(LEFT+194,TOP+31,35,35,0,108);
        UI.setColor(Color.yellow);
        UI.fillOval(LEFT+173,TOP+123,43,43);
        UI.setColor(Color.red);
        UI.fillArc(LEFT+172,TOP+121,35,35,75,108);
        UI.fillArc(LEFT+170,TOP+129,35,35,145,108);
        UI.fillArc(LEFT+176,TOP+133,35,35,218,108);
        UI.fillArc(LEFT+182,TOP+129,35,35,291,108);
        UI.fillArc(LEFT+180,TOP+121,35,35,0,108);
        UI.setColor(Color.yellow);
        UI.fillOval(LEFT+130,TOP+160,43,43);
        UI.setColor(Color.red);
        UI.fillArc(LEFT+129,TOP+158,35,35,75,108);
        UI.fillArc(LEFT+127,TOP+166,35,35,145,108);
        UI.fillArc(LEFT+133,TOP+170,35,35,218,108);
        UI.fillArc(LEFT+139,TOP+166,35,35,291,108);
        UI.fillArc(LEFT+137,TOP+158,35,35,0,108);
        UI.setColor(Color.yellow);
        UI.fillOval(LEFT+187,TOP+75,43,43);
        UI.setColor(Color.red);
        UI.fillArc(LEFT+186,TOP+73,35,35,75,108);
        UI.fillArc(LEFT+184,TOP+81,35,35,145,108);
        UI.fillArc(LEFT+190,TOP+85,35,35,218,108);
        UI.fillArc(LEFT+196,TOP+81,35,35,291,108);
        UI.fillArc(LEFT+194,TOP+73,35,35,0,108);
    }


    




}
