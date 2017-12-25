// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a ${course} assignment.
// You may not distribute it in any other way without permission.
/* Code for ${course} - 2017T2
* Name:???
* Username:xmut_1624092211
* ID:1624092211
*/
import ecs100.*;

/** Program to create simple animated cartoon strips using the
 *  CartoonCharacter class.  
 */

public class CartoonStrip{

    /** Constructor: set up user interface */
    public CartoonStrip(){
           UI.initialise();
           UI.addButton("Clear", UI::clearGraphics );
           UI.addButton("Animate", this::doAnimate );
           UI.addButton("Three dancers", this::doThreeDancers );
           UI.addButton("Gamebook Story",this::doGameBook );
           UI.addButton("Quit", UI::quit );
           UI.setDivider(0);          // Expand the graphics area
    }

    /** doAnimate creates two cartoon characters on the window.
        *  Then animates them according to a fixed script by calling a series
        *  of methods on the characters.
        */
    public void doAnimate(){
           /*# YOUR CODE HERE */
            CartoonCharacter c1=new CartoonCharacter(100,200,"Jim");
            CartoonCharacter c2=new CartoonCharacter(250,200,"Jan");
            c1.walk(30);
            c1.speak("hey,son.Do you like dabbling ?" );
            c2.lookLeft();
            c2.speak("YES!!DADDY!" );
            c1.speak("OK.");
            c1.speak("Go and wash the bowl.");
            c2.frown();
            c2.lookRight();
            c2.walk(50);
    }

    /** doThreeDancers creates three cartoon characters on the window.
        *  Then makes each character do the same little dance in turn,
        *  by calling the dance method.
        */
    public void doThreeDancers(){
           /*# YOUR CODE HERE */
           CartoonCharacter c1=new CartoonCharacter(100,200,"Jim");
           CartoonCharacter c2=new CartoonCharacter(250,200,"Jan");
           CartoonCharacter c3=new CartoonCharacter(400,200,"Jon");
           this.Threedance(c1);
           this.Threedance(c2);
           this.Threedance(c3);
    }

    /** Makes a character do a little dance.
    Has one parameter - a CartoonCharacter object
        */
    public void Threedance(CartoonCharacter face){
         /*# YOUR CODE HERE */  
        face.walk(50);
        face.frown();
        face.lookLeft();
        face.walk(50);
        face.smile();
        face.speak("I'm the king of the world!!");
        face.think(":-)");
    }
    
    public void doGameBook(){
        CartoonCharacter c1=new CartoonCharacter(100,200,"Jim");
        CartoonCharacter c2=new CartoonCharacter(250,200,"Jan");
        CartoonCharacter c3=new CartoonCharacter(400,200,"Jon");
        c2.frown();
        c3.frown();
        c1.frown();
        c2.speak("Oh no,I broke the window!");
        c1.speak("It's fine.Just walk awway.Nobody will find you.");
        c3.speak("We need to tell our teacher!");
        String answer = UI.askString("Which friend should you agree?(Jim or Jon)");
        if(answer.equals("Jim") ){
            c1.speak("Maybe you should think again.");
        }else if (answer.equals("Jon") ){
        c3.smile();
        c3.speak("You are a good child.");        
        c2.smile();
        c1.smile();
       }
       c3.walk(100);
       c2. walk(100);
       c1. walk(100);
    }   
    

}

