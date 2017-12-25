
/**
 * Write a description of class Question2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import ecs100.*;
import java.awt.Color;


public class Question3
{

public void Question3(double left, double top, double height) {
    UI.setColor(Color.blue);
    UI.setFontSize(18);
    UI.drawString("Question 3.  Writing loops.", 120, 20);
    UI.setColor(Color.black);
    while (height >=20) {
        UI.drawRect(left, top, 33, height);
        left = left + 33;
        top = top + 50;
        height = height - 50;
    }
    //UI.println("  Question 3. Writing loops");
}
}
