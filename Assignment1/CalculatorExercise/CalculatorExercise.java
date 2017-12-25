// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

import ecs100.*;

/** Program for calculating various things
Some methods convert between two units
Other methods perform other simple calculations */
public class CalculatorExercise{

    /** Constructor: set up the user interface (already written for you) */ 
    public CalculatorExercise(){
        UI.addButton("milesToKilometers", this::doMilesToKilometers );
        UI.addButton("triangleArea", this::doTriangleArea );
        UI.addButton("gramsToOunces", this::doGramsToOunces );
        UI.addButton("surfaceAreaOfSphere", this::doSurfaceAreaOfSphere );
        UI.addButton("kelvinToCelsius", this::doKelvinToCelsius );
        UI.addButton("costOfPeppers", this::doCostOfPeppers );
        UI.addButton("Quit", UI::quit);
    }

    /**
     *   Ask for miles and convert to kilometers
     */
    public void doMilesToKilometers(){
        /*# YOUR CODE HERE */
        double miles = UI.askDouble("miles");
        double Kilometers =  miles*1.609;
        UI.println(miles + "Mi=>" + Kilometers + "km");
             
    }
    /**
     * Ask for length of base and height, then calculate area of triangle
     */
    public void doTriangleArea(){
        /*# YOUR CODE HERE */
        double Base = UI.askDouble("length of base=");
        double height = UI.askDouble("length of height=");
        double A=(Base*height)/2;
        UI.println("calculate is "+ A);
    }

    /**
     * Ask for grams then convert to ounces
     */
    public void doGramsToOunces(){
        /*# YOUR CODE HERE */

    }

    /**
     * Ask for radius then compute surface of a sphere
     */
    public void doSurfaceAreaOfSphere(){
        /*# YOUR CODE HERE */

    }

    /**
     * Ask for temperature in Kelvin then convert to Celsius
     */
    public void doKelvinToCelsius(){
        /*# YOUR CODE HERE */

    }

    /**
     * Ask how many peppers and cost per pepper, then compute total cost
     */
    public void doCostOfPeppers(){
        /*# YOUR CODE HERE */
        double result=0.764762158768;
        int
    }


}
