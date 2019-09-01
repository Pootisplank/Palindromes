
/**
* Class: CSE 11 Introduction to Computer Science: Object Oriented
* Programming (Java)
* Instructor: Dr. Robert August
* Description: Takes a text file from the user and computes the number of palindromes per line in the text file
* Due: 05/13/2019
* Author: Alex Lin
* Student ID: A15571460
* 
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class Palindrome
{
  public static void main(String[] args) throws IOException
  {

    checkPalindrome();
  }

  /**
   * Prompts the user for a text file and outputs the number of lines read and
   * number of palindromes in the file
   * 
   * @throws IOException
   */
  public static void checkPalindrome() throws IOException
  {
    int palindromeCount;
    int lineCount;
    String fileToCheck;
    Scanner scnr;
    Scanner file;
    Scanner fileLineCounter;
    FileInputStream fileStream1 = null;
    FileInputStream fileStream2 = null;

    // Gets the name of the text file to analyze
    System.out.println("Please enter the name of the file to process");
    scnr = new Scanner(System.in);
    fileToCheck = scnr.nextLine();
    scnr.close();

    // Creating one file stream for counting the number of palindromes
    fileStream1 = new FileInputStream(fileToCheck);
    // Creating a second file stream for counting the number of lines
    fileStream2 = new FileInputStream(fileToCheck);

    // Creating a scanner for each file stream
    file = new Scanner(fileStream1);
    fileLineCounter = new Scanner(fileStream2);

    // Calls methods to compute palindrome and line count and assigns them to
    // variables
    palindromeCount = checkPalindrome(fileLineCounter);
    lineCount = countLines(file);

    file.close();
    fileLineCounter.close();

    // Outputs the results to the console
    System.out.println("The program read " + lineCount + " lines.");
    System.out.print("There were " + palindromeCount + " palindromes.");
    System.out.close();
  }

  /**
   * Counts the number of palindromes in the text file
   * @param file The scanner containing the file to analyze for palindromes
   * @return The int value of the number of palindromes in the text
   * @see https://stackoverflow.com/questions/11149759/remove-all-non-alphabetic-characters-from-a-string-array-in-java
   *      for use of regex in formatting the string before analyzing it
   */
  public static int checkPalindrome(Scanner file)
  {
    String textToAnalyze;
    boolean charMatch = false;
    int palindromeCounter = 0;

    while (file.hasNext())
    {
      textToAnalyze = file.nextLine();
      // Uses regex [^a-z] and the replaceAll method to remove any non-lowercase
      // letter from the string.
      textToAnalyze = textToAnalyze.toLowerCase().replaceAll("[^a-z]", "");

      // Counts a blank line as a palindrome
      if (textToAnalyze.length() == 0)
      {
        palindromeCounter++;
        continue;
      }

      // Determines if the given string is a palindrome and increments
      // palindromeCounter if it is a palindrome
      for (int textChar = 0; textChar < textToAnalyze.length(); textChar++)
      {
        if (textToAnalyze.charAt(textChar) == textToAnalyze.charAt(textToAnalyze.length() - textChar - 1))
        {
          charMatch = true;
        } else
        {
          charMatch = false;
          break;
        }
      }
      if (charMatch)
      {

        palindromeCounter++;
      }
    }
    return palindromeCounter;
  }

  /**
   * Counts the number of lines read in the text file
   * @param file The scanner containing the file to analyze
   * @return The int value of the number of lines read in the file
   * 
   */
  public static int countLines(Scanner file)
  {
    int lineCounter = 0;
    String fileText;
    while (file.hasNext())
    {
      fileText = file.nextLine();
      lineCounter++;
    }
    return lineCounter;
  }

}
