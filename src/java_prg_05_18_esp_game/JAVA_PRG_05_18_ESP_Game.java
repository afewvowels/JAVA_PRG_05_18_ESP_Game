/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_prg_05_18_esp_game;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author bluebackdev
 * Write a program that tests your ESP (extrasensory perception). The program
 * should randomly select the name of a color from the following list of words:
 * 
 *      Red, Green, Blue, Orange, Yellow
 * 
 * To select a word, the program can generate a random number. For example, if
 * the number is 0, the selected word is Red; if the number is 1, the selected
 * word is Green; and so forth.
 * 
 * Next, the program should ask the user to enter the color that the computer
 * has selected. After the user has entered his or her guess, the program should
 * display the name of the randomly selected color. The program should repeat
 * this 10 times and then display the number of times the user correctly
 * guessed the selected color. Be sure to modularize the program into methods
 * that perform each major task.
 */
public class JAVA_PRG_05_18_ESP_Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        final int INT_NUM_ITERATIONS = 10;
        
        int intPlayerChoice = -1;
        int intComputerChoice = -1;
        int intNumCorrect = 0;
        
        while (intPlayerChoice != 6)
        {
            for (int i = 0 ; i < INT_NUM_ITERATIONS ; i++)
            {
                intPlayerChoice = showMenu();
                
                if (intPlayerChoice == 6)
                {
                    break;
                }
                
                intComputerChoice = generateComputerSelection();
                
                if(compareSelections(intComputerChoice, intPlayerChoice) == true)
                {
                    System.out.println("That was a match!");
                    intNumCorrect++;
                }
                else if(compareSelections(intComputerChoice, intPlayerChoice) == false)
                {
                    System.out.println("That was not a match.");
                }
                else
                {
                    System.out.println("ERROR COMPARING VALUES");
                }
            }
            displayResults(INT_NUM_ITERATIONS, intNumCorrect);
        }
    }
    
    public static int showMenu()
    {
        int intMenuChoice = -1;
        
        Scanner scrKeyboard = new Scanner(System.in);
        
        while(intMenuChoice < 1 || intMenuChoice > 6)
        {
            System.out.println("Please select from the following menu options:");
            
            System.out.println("\t1. Red");
            System.out.println("\t2. Green");
            System.out.println("\t3. Blue");
            System.out.println("\t4. Orange");
            System.out.println("\t5. Yellow");
            System.out.println("\t6. Quit");
            
            intMenuChoice = scrKeyboard.nextInt();
        }
        
        
        return intMenuChoice;
    }
    
    public static int generateComputerSelection()
    {
//        String strSelection;
        
        int intSelection;
        
        Random randomGenerator = new Random();
        
        intSelection = randomGenerator.nextInt(5) + 1;
        
        return intSelection;
        
//        switch(intSelection)
//        {
//            case 1:
//                strSelection = "Red";
//                break;
//            case 2:
//                strSelection = "Green";
//                break;
//            case 3:
//                strSelection = "Blue";
//                break;
//            case 4:
//                strSelection = "Orange";
//                break;
//            case 5:
//                strSelection = "Yellow";
//                break;
//            default:
//                System.out.println("ERROR SELECTING COLOR");
//                strSelection = "NULL";
//                break;
//        }
//        
//        return strSelection;
    }
    
    public static boolean compareSelections(int intComputerChoice, int intPlayerChoice)
    {
        boolean booIsMatch = false;
        
        if (intComputerChoice == intPlayerChoice)
        {
            booIsMatch = true;
        }
        else if (intComputerChoice != intPlayerChoice)
        {
            booIsMatch = false;
        }
        else
        {
            System.out.println("ERROR COMPARING VALUES");
            booIsMatch = false;
        }
        
        return booIsMatch;
    }
    
    public static void displayResults(int intTotalNum, int intCorrectGuesses)
    {
        System.out.println("Out of a total of " + intTotalNum + " guesses, " +
                "you got " + intCorrectGuesses + " correct!");
    }
}

