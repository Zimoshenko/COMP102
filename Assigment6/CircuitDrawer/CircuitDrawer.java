// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2017T1
 * Name:???
 * Username:
 * ID:1624092211
 */

import ecs100.*;
import java.awt.Color;

public class CircuitDrawer{

    // fields to store data:
    //  - the tool that the user has selected (which control what component will be
    //    drawn by the mouse)
    //    The tools are "resistor", "wire", "capacitor", "source", "label", or "eraser"
    //  - the mode: whether the component should be horizontal or vertical
    //  - the contents of the label
    //  - the position the mouse was pressed, 
    /*# YOUR CODE HERE */
    private boolean HoriDirec = true;
    private boolean WireFirstPoint = true;
    private String LabelText;
    private double x1, x2, y1, y2;
    private String operation = " ";
    //Constructor
    /** Sets up the user interface - mouselistener, buttons, and (completion only) textField */
    public CircuitDrawer(){
        UI.setMouseListener( this::doMouse );
        UI.addButton("Clear", UI::clearGraphics); 
        /*# YOUR CODE HERE */
        UI.addButton("Wire", this::doSetWire);
        UI.addButton("Resistor", this::doSetResistor);
        UI.addButton("Capacitor", this::doSetCapacitor);
        UI.addButton("Source", this::doSetSource);
        UI.addTextField("Label", this::doSetLabel);
        UI.addButton("Eraser", this::doSetEraser);
        UI.addButton("Horizontal/Vertical", this::doSwitchDirection);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.0);  // Hide the text area.
    }

    // Methods to change the tool that controls what will be drawn next
    // These methods just save information to the fields.
    /** Respond to the resistor button */
    public void doSetResistor(){  //??
        /*# YOUR CODE HERE */
        this.operation = "Resistor";
        this.showCurrentTool();
    }

    /** Respond to the wire button */
    public void doSetWire(){  //??
        /*# YOUR CODE HERE */
        this.operation = "Wire";
        this.showCurrentTool();
    }

    /** Respond to the capacitor button */
    public void doSetCapacitor(){  //??
        /*# YOUR CODE HERE */
        this.operation = "Capacitor";
        this.showCurrentTool();
    }

    /** Respond to the source button */
    public void doSetSource(){  //??
        /*# YOUR CODE HERE */
        this.operation = "Source";
        this.showCurrentTool();
    }

    /** Respond to the eraser button */
    public void doSetEraser(){  //??
        /*# YOUR CODE HERE */
        this.operation = "Eraser";
        this.showCurrentTool();
    }

    /** Respond to the text field (completion only) */
    public void doSetLabel(String v){   //??
        /*# YOUR CODE HERE */
         this.LabelText = v;
         this.operation = "Label";
         this.showCurrentTool();
    }

    /**
     * Respond to the horiz/vert button (completion only)
     * Switches the mode from horizontal to vertical, or back
     * Ideally, (Challenge) it should show the user what the current state is,
     * eg by drawing a horizonal/vertical bar in the top left corner,
     * or by calling setText on the button to change the label
     */
    public void doSwitchDirection(){ //???
        /*# YOUR CODE HERE */
          if (this.HoriDirec) {
            this.HoriDirec = false;
        } else {
            this.HoriDirec = true;
        }
        this.showCurrentTool();
    }

    /**
     * Respond to mouse events
     * When pressed, remember the position.
     * When released, draw what is specified by current tool
     * Uses the value stored in the field to determine which kind of component to draw (or to erase)
     *  It should call the drawWire, drawResistor, drawCapacitor, drawSource, drawLabel, 
     *  or doErase, methods passing the x and y where the mouse was released.
     */
    public void doMouse(String action, double x, double y) { 
        /*# YOUR CODE HERE */
        if (this.operation.equals("Wire")) {
            if (action.equals("pressed")) {
                this.drawWire(x, y);
            }
        }
         if (action.equals("released")){
            if (this.operation.equals("Resistor")) {
                this.drawResistor(x, y);
            } else if (this.operation.equals("Wire")) {
                this.drawWire(x, y);
            } else if (this.operation.equals("Capacitor")) {
                this.drawCapacitor(x, y);
            } else if (this.operation.equals("Source")) {
                this.drawSource(x, y);
            } else if (this.operation.equals("Eraser")) {
                this.doErase(x, y);
            } else if (this.operation.equals("Label")) {
                this.drawLabel(x, y);
            }
            }
    }

    public void showCurrentTool() {
        if (this.operation.equals("Resistor")) {
            if(this.HoriDirec){
             UI.println("Now using horizonal resister.");
            }else{UI.println("Now using vertial resister.");
            }
        }else if (this.operation.equals("Wire")) {     
             UI.println("Now using wire.");
        }else if (this.operation.equals("Capacitor")) {
            if(this.HoriDirec){
             UI.println("Now using horizonal capacitor.");
            }else{UI.println("Now using vertial capacitor.");
            }
        } else if (this.operation.equals("Source")) {
           if(this.HoriDirec){
             UI.println("Now using horizonal Source.");
            }else{UI.println("Now using vertial Source.");
            }
        } else if (this.operation.equals("Eraser")) {     
             UI.println("");
        }
    }
    /**
     * Draw a resistor centered at the point x, y.
     * (either a thin rectangle with short wires, or a zig-zag.)
     * Core: only horizontal required
     * Completion: horizontal or vertical depending on the mode.
     */
    public void drawResistor(double x, double y){
        double length = 31;    // size in the longer  dimension
        double width = 11;     // size in the shorter dimension 
        double stub = 10;      // the length of the wires on each end
        /*# YOUR CODE HERE */
         if (HoriDirec) {
            UI.eraseRect(x - length / 2, y - width / 2, length, width);
            UI.drawRect(x - length / 2, y - width / 2, length, width);
            UI.drawLine(x - length / 2, y, x - length / 2 - stub, y);
            UI.drawLine(x + length / 2, y, x + length / 2 + stub, y);
        } else {
            UI.eraseRect(x - width / 2, y - width / 2, width, length);
            UI.drawRect(x - width / 2, y - width / 2, width, length);
            UI.drawLine(x, y + (length / 2) + stub, x, y + (length / 2) + stub * 2);
            UI.drawLine(x, y - length / 4, x, y - length / 4 - stub);//uppper line
        }
    }

    /**
     * Draw a wire from the point where the user pressed the mouse to the point x,y.
     * Core: may be a straight line.
     * Completion: The wire should have a horizontal part followed by a vertical part
     * If the distance between the two points is very small, it just puts a circle at (x y)
     */
    public void drawWire(double x, double y){
        /*# YOUR CODE HERE */
         if (this.WireFirstPoint) {
            x1 = x;
            y1 = y;
            this.WireFirstPoint = false;
        } else {
            x2 = x;
            y2 = y;
            if((Math.abs(x2-x1)<4)||(Math.abs(y2-y1)<4)){
             UI.fillOval(x-2, y-2, 4, 4);
            if (x1 != x2 && y1 != y2) {
                UI.drawLine(x1, y1, x2, y1);
                UI.drawLine(x2, y1, x2, y2);
            } else {
                UI.drawLine(x1, y1, x2, y2);
            }
          }
            this.WireFirstPoint = true;
        }
    }

    /**
     * Draw a capacitor centered at the point x, y.
     *  (Two parallel lines with wires on each side)
     * Core: only horizontal required
     * Completion: horizontal or a vertical, depending on the mode.
     */
    public void drawCapacitor(double x, double y){
        /*# YOUR CODE HERE */
         if (HoriDirec) {
            UI.eraseRect(x - 5, y - 10, 10, 20);
            UI.drawLine(x - 30, y, x - 5, y);
            UI.drawLine(x + 30, y, x + 5, y);
            UI.drawLine(x - 5, y - 10, x - 5, y + 10);
            UI.drawLine(x + 5, y - 10, x + 5, y + 10);
        } else {
            UI.eraseRect(x - 10, y - 5, 20, 10);
            UI.drawLine(x, y - 30, x, y - 5);
            UI.drawLine(x, y + 30, x, y + 5);
            UI.drawLine(x - 10, y - 5, x + 10, y - 5);
            UI.drawLine(x - 10, y + 5, x + 10, y + 5);
        }
    }

    /**
     * Draw a source centered at the point x, y.
     *  (Circle with wires on each side)
     * Core: only horizontal required
     * Completion: horizontal or vertical, depending on the mode.
     */
    public void drawSource(double x, double y){
        /*# YOUR CODE HERE */
        if (HoriDirec) {
            UI.eraseOval(x - 10, y - 10, 20, 20);
            UI.drawOval(x - 10, y - 10, 20, 20);
            UI.drawLine(x - 10, y, x - 10 - 10, y);
            UI.drawLine(x + 10, y, x + 10 + 10, y);
        } else {
            UI.eraseOval(x -10, y - 10, 20, 20);
            UI.drawOval(x - 10, y - 10, 20, 20);
            UI.drawLine(x, y - 10 - 10, x, y - 10);
            UI.drawLine(x, y + 10 + 10, x, y + 10);
        }

    }

    /**
     * Erase a circular region around the position x, y
     * Should be big enough to erase a single component.
     */
    public void doErase(double x, double y){
        /*# YOUR CODE HERE */
        UI.eraseRect(x - 25, y - 25, 40, 40);
    }

    /**
     * Draw a label at position x, y.  Always horizontal.
     * Uses the label that was stored in a field.
     * Completion only.
     */
    public void drawLabel(double x, double y){
        /*# YOUR CODE HERE */
        UI.drawString(LabelText, x, y);
    }

    // Main:  constructs a new CircuitDrawer object
    public static void main(String[] arguments){
        new CircuitDrawer();
    }   

}
