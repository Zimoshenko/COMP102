// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2017T1
 * Name:纪倩琳
 * Username:
 * ID:1624092211
 */

import ecs100.*;
import java.io.*;
import java.util.*;
import java.awt.Color;

/**
 * This is related to your program from assignment 3 which analysed temperature levels
 * However, instead of reading data from the user, it reads the data from
 * a file into an ArrayList.
 * It can also cope with much larger sets of numbers.
 * The numbers are guaranteed to be integers but the values can be
 *   negative and the signal swings above and below zero.
 *
 * The methods you are to complete all focus on the ArrayList of data.
 * CORE
 *  doRead:              reads numbers into an ArrayList.
 *  doDisplay:           displays the waveform.
 *  doReportDistortion:  prints out the fraction of time the signal is distorted.
 *  doSpread:            displays the spread with two horizontal lines and returns its value.
 * COMPLETION
 *  doDisplayDistortion: shows in red the distorted part of the signal.
 *  doHighlightPeaks:    plots the peaks with small green circles.
 *  doNormalise:         normalises all the values down so there is no distortion.
 * CHALLENGE
 *  doEnvelope:          displays the upper envelope.
 *  doSave:              saves the current waveform values into a file.
 *  select and edit:     let the user select a regions of the waveform with the mouse
 *                       to remove them.  Add a save button to save the edited values.
 */

public class WaveformAnalyser{
    // Fields 
    private ArrayList<Double> waveform = new ArrayList<Double>();   // the field to hold the ArrayList of values

    // Constant: the threshold for the distortionLevel and showDistortion methods
    public static final double THRESHOLD = 200;

    // Constants: the dimensions of the graph for the displayWaveform method
    public static final int GRAPH_LEFT = 10;
    public static final int ZERO_LINE = 300;

    // Constant fields holding the size of the circles for the highlightPeaks method
    public static final int SIZE_CIRCLE = 10;
    double a;
    private ArrayList<Integer> peaks = new ArrayList<>();
    /** Constructor:
     * Set up the ten buttons and mouselistener
     */
    public WaveformAnalyser(){
        //core
        UI.addButton("Read Data", this::doRead);
        UI.addButton("Display Waveform", this::doDisplay);
        UI.addButton("Report Distortion", this::doReportDistortion);
        UI.addButton("Spread", this::doSpread);
        //completion
        UI.addButton("Display Distortion", this::doDisplayDistortion);
        UI.addButton("Peaks", this::doHighlightPeaks);
        UI.addButton("Normalise", this::doNormalise);
        //challenge
        UI.addButton("Envelope", this::doEnvelope);
        UI.addButton("Save", this::doSave);
        UI.addButton("Quit", UI::quit); 
    }

    /**
     * [CORE]
     * Clears the panes, 
     * Creates an ArrayList stored in a field, then
     * Asks user for a waveform file (eg waveform1.txt) 
     * Reads data from the file into the ArrayList
     */
    public void doRead(){
        UI.clearPanes();
        String fname = UIFileChooser.open();
        /*# YOUR CODE HERE */
        try { 
        Scanner scan = new Scanner(new File(fname));
        while (scan.hasNextDouble()){
          double a = scan.nextDouble();
          UI.println(a);
        }
      }
      catch (IOException e) { UI.println("File failure:" + e); 
      }

    }
    
    /**
     * [CORE]
     * Displays the waveform as a line graph,
     * The n'th value in waveform is displayed at
     *    x-position is GRAPH_LEFT + n
     *    y-position is ZERO_LINE - the value
     * Plots a line graph of all the points with a blue line between
     *  each pair of adjacent points
     * Draw the horizontal line representing the value zero.
     * Uses GRAPH_LEFT and ZERO_LINE for the dimensions and positions of the graph.
     * Don't worry if the lines go off the window
     */
    public void doDisplay(){
        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        UI.clearGraphics();

        // draw x axis (showing where the value 0 will be)
        UI.setColor(Color.black);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE, 99999 , ZERO_LINE); 
        // plot points: blue line between each pair of values
        /*# YOUR CODE HERE */
      try { 
        String fname = UIFileChooser.open();  
        Scanner scan = new Scanner(new File(fname));
        int n= 0;
        int m=0;
        double b=0;
        UI.setColor(Color.blue);
          while(scan.hasNextDouble()){
         double a = scan.nextDouble();
           UI.drawLine((GRAPH_LEFT + n),ZERO_LINE-a, (GRAPH_LEFT + m), ZERO_LINE-b);
          b = a;
          m=n;
          n++;
        }
      }
       catch (IOException e) { UI.println("File failure:" + e); 
      }
    }

    /**
     * [CORE]
     * Computes and prints out the fraction of time the signal is distorted. 
     * This fraction of time is defined as the number of distorted values, divided by the number of values. 
     * A distorted value is defined as one whose absolute
     * value is greater than the value of THRESHOLD 
     * [Hint] You may find Math.abs() useful for this method - it computes the absolute value
     */
    public void doReportDistortion() {
      if (this.waveform == null){ //there is no data to analyse
            UI.println("No signal to analyse and report on");
            return;
      }
        /*# YOUR CODE HERE */
      try { 
        String fname = UIFileChooser.open();  
        Scanner scan = new Scanner(new File(fname));
        double a = scan.nextDouble();
        int i;
        for( i=0;i<this.waveform.size();){
          if (Math.abs(a)>=THRESHOLD){
            i++;
          }
        }
         double f = ( i / waveform.size());
         UI.println("Fraction of time the signal is distorted: " + f);
      } catch (IOException e) { UI.println("File failure:" + e); 
      }
    }

    /**
     * [CORE]
     * The spread is the difference between the maximum and minimum values of the waveform.
     * Finds the maximum and minimum values, then
     * Displays the spread by drawing two horizontal lines on top of the waveform: 
     *   one green line for the maximum value, and
     *   one red line for the minimum value.
     */
    public void doSpread() {
        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        this.doDisplay();
        /*# YOUR CODE HERE */
        double max =  - 99999  ;
        double min =  99999  ;
         try { 
          String fname = UIFileChooser.open();  
          Scanner scan = new Scanner(new File(fname));
          double a = scan.nextDouble();
            if (a >  max) {
                max = a;
             }
        
             if (a < min) {
                min = a;
            }
        UI.setColor(Color.green);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE - max, 99999, ZERO_LINE - max);
        UI.setColor(Color.red);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE - min, 99999, ZERO_LINE - min);
        UI.println("min is " + min);
        UI.println("max is " + max);
       } catch (IOException e) { UI.println("File failure:" + e); 
      }
    }

    /**
     * [COMPLETION]  [Fancy version of doDisplay]
     * Display the waveform as a line graph. 
     * Draw a line between each pair of adjacent points
     *   * If neither of the points is distorted, the line is BLUE
     *   * If either of the two end points is distorted, the line is RED
     * Draw the horizontal lines representing the value zero and thresholds values.
     * Uses THRESHOLD to determine distorted values.
     * Uses GRAPH_LEFT and ZERO_LINE for the dimensions and positions of the graph.
     * [Hint] You may find Math.abs(int a) useful for this method.
     * You may assume that all the values are between -250 and +250.
     */
    public void doDisplayDistortion() {
        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        UI.clearGraphics();

        // draw zero axis
        UI.setColor(Color.black);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + 9999 , ZERO_LINE); 

        // draw thresholds
        /*# YOUR CODE HERE */
         try { 
        String fname = UIFileChooser.open();  
        Scanner scan = new Scanner(new File(fname));
        int n= 0;
        int m=0;
        double b=0;
        UI.setColor(Color.blue);
          while(scan.hasNextDouble()){
         double a = scan.nextDouble();
          if ((Math.abs(a) > THRESHOLD) || (Math.abs(b) > THRESHOLD)) {
                UI.setColor(Color.red);
            } else {
                UI.setColor(Color.blue);
            }
          UI.drawLine((GRAPH_LEFT + n),ZERO_LINE-a, (GRAPH_LEFT + m), ZERO_LINE-b);
          b = a;
          m=n;
          n++;
        }
      }
       catch (IOException e) { UI.println("File failure:" + e); 
      }
    }

    /**
     * [COMPLETION]
     * Plots the peaks with small green circles. 
     *    A peak is defined as a value that is greater or equals to both its
     *    neighbouring values.
     * Note the size of the circle is in the constant SIZE_CIRCLE
     * You may assume that peaks values differ from their neighbouring points.
     */
    public void doHighlightPeaks() {
        this.doDisplayDistortion(); //use doDisplay if doDisplayDistortion isn't complete
        /*# YOUR CODE HERE */
        int n = 0;
        this.peaks.clear();
        while (n < this.waveform.size() - 1) {
            if (n < 2) {
                n++;
                continue;
            }
            if ((this.waveform.get(n)) > this.waveform.get(n - 1)) {
                if (this.waveform.get(n) > this.waveform.get(n + 1)) {
                    peaks.add(n);
                }
            }
            n++;
        }
        for (int num : peaks) {
            UI.setColor(Color.green);
            UI.drawOval(GRAPH_LEFT + num - SIZE_CIRCLE / 2, ZERO_LINE - this.waveform.get(num) - SIZE_CIRCLE / 2, SIZE_CIRCLE, SIZE_CIRCLE);
        }
    }

    /**
     * [COMPLETION]
     * Finds the largest value (positive or negative) in the waveform, and
     * "normalises" all the values - multiplies them by threshold/maximum - so
     * that the largest value is now equal to the distortion threshold.
     * Then redraws the waveform.
     */
    public void doNormalise() {
        /*# YOUR CODE HERE */

        this.doDisplayDistortion(); //use doDisplay if doDisplayDistortion isn't complete
    }

    /**
     * [CHALLENGE]
     * Displays the upper envelope with GREEN lines connecting all the peaks.
     *    A peak is defined as a point that is greater or equal to *both* neighbouring points.
     */
    public void doEnvelope(){
        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        this.doDisplay();  // display the waveform,

        /*# YOUR CODE HERE */
    }

    /**
     * [CHALLENGE]
     * Saves the current waveform values into a file
     */
    public void doSave(){
        /*# YOUR CODE HERE */
        try {
            PrintStream output = new PrintStream(new File(UIFileChooser.save("Save the current waveform")));

            for (double num : waveform) {
                output.println(num);
            }

            output.close();

        } catch (IOException e) {
            UI.println("Save Error:" + e);
        }
    }

    private int index1;
    /**
     * [CHALLENGE]
     * Lets user select a region of the waveform with the mouse
     * and deletes that section of the waveform.
     */
    public void doMouse(String action, double x, double y){
        /*# YOUR CODE HERE */

    }

    // Main
    public static void main(String[] arguments){
        new WaveformAnalyser();
    }   

}
