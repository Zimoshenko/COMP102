// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 2 
 * Name:纪倩琳
 * Usercode:xmut_1624092211
 * ID:1624092211
 */

import ecs100.*;

/** Program for calculating properties of a voltage divider circuit */

public class CircuitCalculator{

    public static final double supplyVoltage = 20; 

    /** Constructor, sets up the user interface */
    public CircuitCalculator(){
        UI.initialise();
        UI.addButton("Core", this::calculateCircuitCore); 
        UI.addButton("Completion", this::calculateCircuitCompletion );
        UI.addButton("Challenge", this::calculateCircuitChallenge );
        UI.addButton("Quit", UI::quit);
    }

    /** Calculates and prints the following properties of a voltage divider circuit:
     *   output voltage, current, power,
     *   supply current and power
     *   efficiency of circuit
     *  Asks the user for the supply voltage, the resistors R1 and R2, and the resistance of the load.
     */
    public void calculateCircuitCore(){
        /*# YOUR CODE HERE */
        double R = UI.askDouble("R is ");
        double RL = UI.askDouble("And RL is");
        double LoadVoltage = RL*supplyVoltage/(R+RL);
        double LoadCurrent = supplyVoltage/(R+RL) ;
        double LoadPower = LoadVoltage*LoadCurrent;
        double SupplyPower = supplyVoltage*LoadCurrent;
        double Efficiency = LoadPower/SupplyPower;
        UI.println("Load voltage is " + LoadVoltage +"V");
        UI.println("Load current is " + LoadCurrent +"A");
        UI.println("Load power is "+LoadPower+"W");
        UI.println("Supply power is "+SupplyPower+"W");
        UI.println("Efficiency is "+Efficiency +"%");
    }

    /** 
     *  
     */
    public void calculateCircuitCompletion(){
        /*# YOUR CODE HERE */
       double R1 = UI.askDouble("R1 is ");
       double R2 = UI.askDouble("R2 is ");
       double RL = UI.askDouble("RL is ");
       double R3 = (R2*RL)/(R2+RL);
       double I = supplyVoltage/(R1+R3);
       double IL = (I*RL)/(R2+RL);
       double UL = IL*RL;
       double PL = IL*UL;
       double PS = supplyVoltage*IL;
       double Efficiency = PL/PS*100;
       UI.println("Load voltage is " + UL + "V");
       UI.println("Load current is " + IL +"A");
       UI.println("Load power is "+ PL +"W");
       UI.println("Supply power is " + PS +"W");
       UI.println("Efficiency is "+Efficiency +"%");
    }

    public void calculateCircuitChallenge(){
        /*# YOUR CODE HERE */
       double R1 = UI.askDouble("R1 is ");
       double R2 = UI.askDouble("R2 is ");
       double RL = UI.askDouble("RL is ");
       double iRL = 0.9*RL ,aRL = 1.1*RL;
       double iR3 = (R2*iRL)/(R2+iRL), aR3 = (R2*aRL)/(R2+aRL),R3 = (R2*RL)/(R2+RL);
       double iUL = 20*iR3/(iR3+R1),aUL = 20*aR3/(aR3+R1);
       double iPL = (iUL*iUL)/(iR3+R1),aPL = (aUL*aUL)/(aR3+R1);
       double PS = supplyVoltage*supplyVoltage/R3;
       double iEfficiency = iPL/PS*100,aEfficiency = aPL/PS*100;
       UI.println("Load voltage maybe " + iUL +"V ~ "+aUL+ "V");
       UI.println("Efficiency maybe "+ iEfficiency + "% ~ "+aEfficiency +"%");
    }




}
