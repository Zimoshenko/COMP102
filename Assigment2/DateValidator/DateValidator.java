// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a ${course} assignment.
// You may not distribute it in any other way without permission.
/* Code for ${course} - 2017T2
* Name:???
* Username:xmut_1624092211
* ID:1624092211
*/
import ecs100.*;
import java.awt.Color;

/**
 * Reads a date from the user as three integers, and then checks that the date is valid
 */

public class DateValidator {

    /** Constructor: set up the user interface (already written for you) */ 
    public DateValidator(){
           UI.initialise();
           UI.addButton("Clear", UI::clearText );
           UI.addButton("Validate Date Core", this::doCore );
           UI.addButton("Validate Date Completion", this::doCompletion );
           UI.addButton("Validate Date Challenge", this::doChallenge );
           UI.addButton("Quit", UI::quit );
           UI.setDivider(1);          // Expand the text area
    }

    /**
        * Asks user for a date, then determines whether the date
        *    specified by the three integers is a valid date.
        */
    public void doCore(){
           int yr = UI.askInt("Year: ");
           int mnth = UI.askInt("Month: ");
           int day = UI.askInt("Day: ");
           this.validateDateCore(yr, mnth, day);
    }

    /**
        * Checks the date:
        * - the day must be between 1 and 31
        * - The month must be between 1 and 12
        * - The year must be a positive number
        */
    public void validateDateCore(int year, int month, int day){
           /*# YOUR CODE HERE */
           if(year>=1 && month<=12 && month>=1 && day<=31 && day>=1){
               UI.println("Year"+ year +" Month"+ month+" Day" + day+" is valid.");
            }
            else{UI.println("Year"+ year +" Month"+ month +" Day" + day+ " is not valid.");
            }
    }

    /**
        * Asks user for a date, then determines whether the date
        *    specified by the three integers is a valid date.
        */
    public void doCompletion(){
           int year = UI.askInt("Year (4 digits): ");
           int month = UI.askInt("Month: ");
           int day = UI.askInt("Day: ");
           this.validateDateCompletion(day, month, year);
    }

    /**
        * For the Completion, you should also check that the day is valid for the month
        * some months don't have a day 31
        * February doesn't have a day 30 or 31
        * On non-leap years, February doesnt have a day 29
        *    A year is a leap year if:
        *          - The year can be evenly divided by 4 but not 100,  OR
        *          - The year can be evenly divided by 400 
        */
    public void validateDateCompletion(int day, int month, int year){
           /*# YOUR CODE HERE */
       if(year>=1 && month<=12 && month>=1 && day<=31 && day>=1){
        if(month==1|| month==3|| month==5|| month==7||month==8 ||month==10||month==12&&day<=31){
                UI.println("Year"+ year +" Month"+ month+" Day" + day+" is valid.");  
        }else if (month==4|| month==6|| month==9|| month==11 && day<=30){
                UI.println("Year"+ year +" Month"+ month+" Day" + day+" is valid.");
        }else if (month==2 && day<= 28){
                UI.println("Year"+ year +" Month"+ month +" Day" + day+ " is  valid.");
        }
        else if((year%4==0 && year%100!=0)||year%400==0 && day<=29){//leap yeaar
               UI.println("Year"+ year +" Month"+ month +" Day" + day+ " is valid.");
        }else{
               UI.println("Year"+ year +" Month"+ month +" Day" + day+ " is not valid.");
        }        
    }else{
        UI.println("Year"+ year +" Month"+ month +" Day" + day+ " is not valid.");  
       }              
    }


    /**
        * For the challenge, your program should also check whether the date is
        * part of the Chinese national holiday or the Chinese new year and should print a
        * message in either case.
        */
    public void doChallenge(){
           int year = UI.askInt("Year (4 digits): ");
           int month = UI.askInt("Month: ");
           int day = UI.askInt("Day: ");
           this.validateDateChallenge(day, month, year);
    }   
    public void  validateDateChallenge(int day, int month, int year){
           /*# YOUR CODE HERE */
           if(year>=1 && month<=12 && month>=1 && day<=31 && day>=1){
        if(month==1|| month==3|| month==5|| month==7||month==8 ||month==10||month==12&&day<=31){
             if(month==10&&day<=7&&day>=1){
                 UI.println("HAPPY NATIONAL HOLIDAY !!!!");
            }else{UI.println("Year"+ year +" Month"+ month+" Day" + day+" is valid.");
            }  
        }else if (month==4|| month==6|| month==9|| month==11 && day<=30){
                UI.println("Year"+ year +" Month"+ month+" Day" + day+" is valid.");
        }else if (month==2 && day<= 28){
            if(day>=15&&day<=21){
                UI.println("HAPPY SPRING FESTIVAL !!!!");
            }else{
                UI.println("Year"+ year +" Month"+ month +" Day" + day+ " is  valid.");
            }       
        }else if((year%4==0 && year%100!=0)||year%400==0 && day<=29){//leap yeaar
               UI.println("Year"+ year +" Month"+ month +" Day" + day+ " is valid.");
        }else{
               UI.println("Year"+ year +" Month"+ month +" Day" + day+ " is not valid.");
        }        
       }else{
        UI.println("Year"+ year +" Month"+ month +" Day" + day+ " is not valid.");  
       } 
    }
    

}


