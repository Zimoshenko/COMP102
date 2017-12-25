/* Code for COMP 102 Assignment 3 2008
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

/** Program to create simple animated cartoon strips using the
 *  CartoonCharacter class.  
 */

public class CartoonStory{

    public CartoonStory(){
        UI.initialise();
        UI.addButton("Play", this::playStory );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(0);       // Expand the graphics area
    }



  public void playStory(){
      UI.clearGraphics();
      // YOUR CODE HERE
        CartoonCharacter face1 = new CartoonCharacter(170, 100, "blue");

        face1.lookRight();
        face1.think("Where is everyone?");
        face1.lookLeft();
        face1.frown();

        CartoonCharacter face2 = new CartoonCharacter(450, 100, "green");
        face2.smile();
        face2.lookLeft();
        face2.speak("Hello");
        face1.lookRight();
        face1.smile();
        face1.speak("Hi there, I'm Jim");
        face2.speak("I'm Jan");
        face2.walk(50);
        face1.lookLeft();
        face1.frown();
        face1.lookRight();
        face1.speak("What's that thing?");
        face2.speak("Just my robot mower!");
        face1.speak("Don't let it mow me!");
        face1.lookLeft();
        face1.speak("I'm off");
        face1.walk(80);
        face1.think("Why does she do that");
        face1.walk(80);
        face1.walk(80);
        face2.speak("Bye!");
        face1.lookRight();
        face2.speak("Come on Robby");
        face2.walk(50);
        face2.walk(50);
        face2.walk(50);
        face2.walk(50);
        face2.walk(50);
        face2.walk(50);
        face2.walk(50);
        /*# END OF YOUR CODE */
  }

  public static void main(String[] arguments){
     new CartoonStory();
  }	

}
