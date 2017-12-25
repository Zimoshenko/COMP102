// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a ${course} assignment.
// You may not distribute it in any other way without permission.
/* Code for ${course} - 2017T2
* Name:纪倩琳
* Username:xmut-1624092211
* ID:1624092211
*/
import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** Renders plain ppm images onto the graphics panel
 *  ppm images are the simplest possible colour image format.
 */

public class ImageRenderer{
    public static final int TOP = 20;   // top edge of the image
    public static final int LEFT = 20;  // left edge of the image
    public static final int PIXEL_SIZE = 2;  

    // Constructor
    public ImageRenderer() {
           UI.initialise();
           UI.addButton("Clear", UI::clearGraphics );
           UI.addButton("Render (core)", this::doRenderImageCore );
           UI.addButton("Render (compl)", this::doRenderAnimatedImage );
           UI.addButton("Render (chall)", this::doChallenge );
           UI.addButton("Quit", UI::quit );
           UI.setWindowSize(850, 700);
           UI.setDivider(0.0);
    }

    /** Core:
        * Renders a ppm image file.
        * Asks for the name of the file, then calls renderImageHelper.
        */
    public void doRenderImageCore(){
           /*# YOUR CODE HERE */
           String fileName = UIFileChooser.open("What's name of the file:");
         try {
           Scanner scan = new Scanner(new File (fileName));
           this.renderImageHelper(scan);
          } catch(IOException e){
          UI.println("File reading failed");}
    }

    /** Core:
        * Renders a ppm image file.
        * Renders the image at position (LEFT, TOP).
        * Each pixel of the image  is rendered by a square of size PIXEL_SIZE
        * Assumes that
        * - the colour depth is 255,
        * - there is just one image in the file (not "animated"), and
        * - there are no comments in the file.
        * The first four tokens are "P3", number of columns, number of rows, 255
        * The remaining tokens are the pixel values (red, green, blue for each pixel)
        */
    public void renderImageHelper(Scanner sc){
           /*# YOUR CODE HERE */
         //  do{
         String F =sc.next();
           int col = sc.nextInt();
           int row = sc.nextInt();
           int d = sc.nextInt();
           int dep;
       if(d!=255){
             dep = 255/d;
        }else{
        dep =1;
       }
           int a=0;
           int c=0;
        if(F.equals("P3")){    
            for(c=0;c<row;c++){
              for (a=0;a<col;a++){
              int r = sc.nextInt() * dep;
              int g = sc.nextInt() *dep;
              int b = sc.nextInt() *dep;
              UI.setColor( new Color (r, g, b) );
              UI.fillRect(LEFT+a*PIXEL_SIZE,TOP+c*PIXEL_SIZE,PIXEL_SIZE,PIXEL_SIZE);
            }
          }
      }else if(F.equals("P2")){
        for(c=0;c<row;c++){
          for (a=0;a<col;a++){
             int gray= sc.nextInt(); 
             UI.setColor(new Color( gray, gray, gray));
              UI.fillRect(LEFT+a*PIXEL_SIZE,TOP+c*PIXEL_SIZE,PIXEL_SIZE,PIXEL_SIZE);        
          }
        }
        }else {
          UI.println("File is not a ppm image");
           return;
         }
     
      }
     /**     public String commentRemover(File file){
        String filename = file + "clear.txt";
       try {
           Scanner scan = new Scanner(file);            
              while (scan.hasNext()) {
           }
       }catch (Exception e) {
            UI.println("File error:" + e); }
         return ;
       */ 
     
       /** Completion
        * Renders a ppm image file which may be animated (multiple images in the file)
        * Asks for the name of the file, then renders the image at position (LEFT, TOP).
        * Each pixel of the image  is rendered by a square of size PIXEL_SIZE
        * Renders each image in the file in turn with 200 mSec delay.
        * Repeats the sequence 3 times.
        */
      public void doRenderAnimatedImage(){
           /*# YOUR CODE HERE */
         String fileName = UIFileChooser.open("What's name of the file:");
         int count = 0;
         while (count<3){
           try{
            Scanner scan= new Scanner(new File(fileName));
            while(scan.hasNext()){
              this.renderImageHelper(scan);
              UI.sleep(200);
            }
            count ++;
            scan.close();
            }catch(IOException e){
              UI.println("File reading failed");}
            }
      }
      
         /**Challenge
       * handle comments (by noticing them and throwing them away).
      handle the colour depth properly: if the colour depth is 15, for example, 
      it should scale up all the values by 255/15 before setting the color.
     Recognise and render plain pgm images also (use the first token to determine
     which version to render).
     */
       public void doChallenge(){
         String fileName = UIFileChooser.open("What's name of the file:");
         try{        
            Scanner scan= new Scanner(new File(fileName));
         while(scan.hasNext()){
             this.renderImageHelper(scan);
            }
        }catch(IOException e){
          UI.println("File reading failed");}
      }
       
}
     
