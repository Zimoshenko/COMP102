
/**
 * Write a description of class Question2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import ecs100.*;

public class Question2
{



public void Question2(int num) {
    UI.println("  List:");
    int n = 3;
    while (n < num) {
        UI.println("  n: " + n);
        n = n + 2;
    }
    UI.println("  Done");
}
}
