// This program is copyright VUW.
// You may not distribute it in any way without permission.

/* Code for COMP102 - 2017T1, Assignment 6
 * Name:
 * Username:
 * ID:
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
    private ArrayList<Double> waveform;   // the field to hold the ArrayList of values

    // Constant: the threshold for the distortionLevel and showDistortion methods
    public static final double THRESHOLD = 200;

    // Constants: the dimensions of the graph for the displayWaveform method
    public static final int GRAPH_LEFT = 10;
    public static final int ZERO_LINE = 300;

    // Constant fields holding the size of the circles for the highlightPeaks method
    public static final int SIZE_CIRCLE = 10;

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
        UI.setMouseListener(this::doMouse);   // only for challenge
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
            Scanner input = new Scanner(new File(fname));
            UI.println("Reading data from " + fname);
            this.waveform = new ArrayList<Double>();
            while (input.hasNext()) {
                this.waveform.add(input.nextDouble());
            }
            input.close();
        } catch (IOException e) {UI.println("Error: Can't open file " + fname);}
        /*# END OF YOUR CODE */

        UI.println("Read "+ this.waveform.size()+" data points from " + fname);
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
        UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size() , ZERO_LINE); 

        // plot points: blue line between each pair of values
        /*# YOUR CODE HERE */
        UI.setColor(Color.blue);
        for (int i=1; i<this.waveform.size(); i++){
            double x1 = GRAPH_LEFT + i-1;
            double x2 = GRAPH_LEFT + i;
            double y1 = ZERO_LINE - this.waveform.get(i-1);
            double y2 = ZERO_LINE - this.waveform.get(i);
            UI.drawLine(x1, y1, x2, y2);
        }
        /*# END OF YOUR CODE */

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
        double count = 0;
        for (int i=0; i<this.waveform.size(); i++){
            if (Math.abs(this.waveform.get(i)) > THRESHOLD) {
                count = count + 1;
            }
        }
        double fraction = count * 100 / this.waveform.size();
        UI.printf("Fraction of time the signal is distorted %4.1f%%\n", fraction);
        /*# END OF YOUR CODE */

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
        double minValue = this.waveform.get(0);
        double maxValue = this.waveform.get(0);
        for (int i=1; i<this.waveform.size(); i++) {
            if ( this.waveform.get(i)<minValue ) {
                minValue = this.waveform.get(i);
            }
            if ( this.waveform.get(i)>maxValue ) {
                maxValue = this.waveform.get(i);
            }
        }
        UI.setColor(Color.green);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE-maxValue, GRAPH_LEFT + this.waveform.size() , ZERO_LINE-maxValue); 
        UI.setColor(Color.red);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE-minValue, GRAPH_LEFT + this.waveform.size() , ZERO_LINE-minValue); 

        /*# END OF YOUR CODE */

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
        UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size() , ZERO_LINE); 

        // draw thresholds
        /*# YOUR CODE HERE */
        UI.setColor(Color.green);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE-THRESHOLD, GRAPH_LEFT + this.waveform.size() , ZERO_LINE-THRESHOLD); 
        UI.drawLine(GRAPH_LEFT, ZERO_LINE+THRESHOLD, GRAPH_LEFT + this.waveform.size() , ZERO_LINE+THRESHOLD); 

        // plot points: line between each pair of values
        for (int i=1; i<this.waveform.size(); i++){
            double x1 = GRAPH_LEFT + i-1;
            double   x2 = GRAPH_LEFT + i;
            double y1 = ZERO_LINE - this.waveform.get(i-1);
            double y2 = ZERO_LINE - this.waveform.get(i);
            if (Math.abs(this.waveform.get(i-1)) > THRESHOLD || Math.abs(this.waveform.get(i)) > THRESHOLD)
                UI.setColor(Color.red);
            else
                UI.setColor(Color.blue);
            UI.drawLine(x1, y1, x2, y2);
        }
        /*# END OF YOUR CODE */

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
        UI.setColor(Color.green);
        for (int i=1; i<this.waveform.size()-1; i++){
            if (this.waveform.get(i)>this.waveform.get(i-1) && this.waveform.get(i)>this.waveform.get(i+1)) {
                double left = GRAPH_LEFT + i - SIZE_CIRCLE/2;
                double top = ZERO_LINE - this.waveform.get(i) - SIZE_CIRCLE/2;
                UI.drawOval(left,top,SIZE_CIRCLE,SIZE_CIRCLE);
            }
        }
        /*# END OF YOUR CODE */

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
        double max = 0;
        for (double num : this.waveform){
            if (Math.abs(num)>max){
                max = Math.abs(num);
            }
        }
        for (int i=0; i<this.waveform.size(); i++){
            this.waveform.set(i, this.waveform.get(i)* THRESHOLD / max);
        }
        /*# END OF YOUR CODE */

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
        UI.setColor(Color.green);
        int index = this.waveform.size()-1;
        double x1 = 0;
        double y1 = 0;
        // Find the first peak
        for (int i=1; i<this.waveform.size()-1; i++){
            if (this.waveform.get(i)>=this.waveform.get(i-1) && this.waveform.get(i)>=this.waveform.get(i+1)) {
                x1 = GRAPH_LEFT + i;
                y1 = ZERO_LINE - this.waveform.get(i);
                index = i;
                break;
            }
        }

        // Find the other peaks
        for (int i=index; i<this.waveform.size()-1; i++){
            if (this.waveform.get(i)>=this.waveform.get(i-1) && this.waveform.get(i)>=this.waveform.get(i+1)) {
                // Found a second peak, join it to the first peak
                double x2 = GRAPH_LEFT + i;
                double y2 = ZERO_LINE - this.waveform.get(i);
                UI.drawLine(x1,y1,x2,y2);

                // Make this second point the first point of the next line
                x1=x2;
                y1=y2;
            }
        }
        /*# END OF YOUR CODE */
    }

    /**
     * [CHALLENGE]
     * Saves the current waveform values into a file
     */
    public void doSave(){
        /*# YOUR CODE HERE */
        if (this.waveform == null){ 
            UI.println("No waveform to save");
            return;
        }
        try{
            PrintStream out = new PrintStream(new File(UIFileChooser.save()));
            for (double v : this.waveform){
                out.println(v);
            }
            out.close();
        }
        catch(IOException e){UI.println("Fail: " + e);}
        /*# END OF YOUR CODE */

    }

    private int index1;
    /**
     * [CHALLENGE]
     * Lets user select a region of the waveform with the mouse
     * and deletes that section of the waveform.
     */
    public void doMouse(String action, double x, double y){
        /*# YOUR CODE HERE */
        if (action.equals("pressed")){
            this.index1 = (int)(x-GRAPH_LEFT);;
            UI.setColor(Color.green);
            UI.drawLine(x, ZERO_LINE+20, x, ZERO_LINE-20);
        }
        else if (action.equals("released")){
            UI.setColor(Color.green);
            UI.drawLine(x, ZERO_LINE+20, x, ZERO_LINE-20);
            UI.sleep(200);
            int index2 = (int)(x-GRAPH_LEFT);
            for (int i = Math.max(index1, index2); i >= Math.min(index1, index2); i--){
                if (i>=0 && i<this.waveform.size()){
                    this.waveform.remove(i);
                }
            }
            this.doDisplayDistortion();
        }
        /*# END OF YOUR CODE */

    }

    // Main
    public static void main(String[] arguments){
        new WaveformAnalyser();
    }   

}
