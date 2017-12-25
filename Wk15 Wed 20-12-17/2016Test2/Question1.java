
/**
 * Write a description of class Question2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import ecs100.*;
import java.awt.Color;

public class Question1
{

    public Question1(double a, double b, double c)
    {
        // initialise instance variables;
         UI.setColor(Color.blue);
         UI.setFontSize(18);
        UI.drawString("Question 1.  Understanding if.", 120, 20);
        UI.setColor(Color.black);
       UI.println();
        UI.println("Question 1.  Understanding if.");
        UI.println("-----------  -----------------");
        UI.println();
        
        if (a<=b && a<=c) {
            UI.println("Minimum = " +a);
        }
        else if (b<=a && b<=a){
            UI.println("Minimum = " +b);
        }
        else
            UI.println("Minimum = " +c);
        }
}
