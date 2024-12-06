package project;

import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
* Class containing the main method.
*
* @author Adriana Solis
* @author Kevin Lee
* @author Gabe Schwartz
*/
public class CipherProgram {

  // add your implementation of the main method

  /**
  * @param args
  */
  public static void main(String[] args) {

    final int valueLowerLimit = 1;
    final int valueMiddleLimit = 2;
    final int valueUpperLimit = 3;

    System.out.println("Welcome to \"Useful Tool for Spies\", a Cipher program!\n");
    System.out.println("Please choose your desired cipher from the available options below.\n");
    System.out.println("Cipher 1: Caesarian Cipher");
    System.out.println("Cipher 2: Vigenere Cipher");
    System.out.println("Cipher 3: Java Cipher\n");
    Scanner scanChoice = new Scanner(System.in);
    System.out.println("Enter \"1\", \"2\" or \"3\": \n");
    int choiceEntry = scanChoice.nextInt();
    if (choiceEntry == valueLowerLimit) {
      System.out.println("\nYou have chosen the Caesarian Cipher!\n");
      Scanner scanner = new Scanner(System.in);
      File inputFile = null;
      char password[] = null;
      try {
        password = PasswordField.getPassword(System.in, "Please enter your message: \n");
      } catch(IOException ioe) {
        ioe.printStackTrace();
      }
      if (password == null) {
        System.out.println("\nNo message was entered.");
      } else {
        System.out.println("\nPlease enter a shift value from 0-26: \n");
        int shiftedValue = scanner.nextInt();
        System.out.println("\nEncrypting your message...");
        CaesarianCipher encrypt = new CaesarianCipher();
        String userInput = String.valueOf(password);
        String encryptedMessages = encrypt.encryptedMessage(userInput, shiftedValue);
        System.out.println("\nEncrypted Text: \n");
        System.out.println(encryptedMessages);
        System.out.println("\nPress any character to view your decrypted message. \n");
        String dval = scanner.nextLine();
        String userInput2 = scanner.nextLine();
        CaesarianCipher decrypt = new CaesarianCipher();
        String decryptedMessages = decrypt.decryptedMessage(encryptedMessages, shiftedValue);
        System.out.println("\nDecrypted Text: \n");
        System.out.println(decryptedMessages);
        System.out.println("\nPrinting out the results of running the Caesarian Cipher.\n");
        String value2341 = scanner.nextLine();
        // declare the starting file and scanner
        File inputFile2 = null;
        Scanner scann = null;
        // connect the scanner to the input file
        try {
          inputFile2 = new File("input/numbers30000.csv");
          scann = new Scanner(inputFile2);
        } catch (FileNotFoundException noFile) {
          System.out.println("Unable to locate the input file");
        }
        int[] numbers = new int[30000]; // needs to be changed per input file
        for (int count = 0; count < numbers.length; count++) {
          numbers[count] = scann.nextInt();
        }
        System.out.println("Size of the array is: " + numbers.length);
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("Running Time: " + elapsed);
        String value2340 = scanner.nextLine();
        System.out.println("\nThank you for using \"Useful Tool for Spies\", a Cipher Program!");
        System.out.println("Have a nice day!");
      }
    } else if (choiceEntry == valueMiddleLimit) {
      System.out.println("\nYou have chosen the Vigenere Cipher!\n");
      Scanner scanner = new Scanner(System.in);
      char password2[] = null;
      try {
        password2 = PasswordField.getPassword(System.in, "Please enter your message: \n");
      } catch(IOException ioe) {
        ioe.printStackTrace();
      }
      if (password2 == null) {
        System.out.println("\nNo message was entered.");
      } else {
        System.out.println("\nPlease enter your desired word to use as your key.\n");
        String key2 = scanner.nextLine();
        System.out.println("\nEncrypting your message...");
        VigenereCipher vigenereMessage = new VigenereCipher();
        String messageFromUser = String.valueOf(password2);
        String encryptionOfMessage = vigenereMessage.encryptInput(messageFromUser, key2);
        System.out.println("\nEncrypted Text: \n");
        System.out.println(encryptionOfMessage);
        System.out.println("\nPress any character to view your decrypted message.\n");
        String dval = scanner.nextLine();
        VigenereCipher vigenereMessage2 = new VigenereCipher();
        String decryptionMessage = vigenereMessage2.decryptOutput(encryptionOfMessage, key2);
        System.out.println("\nDecrypted Message: \n");
        System.out.println(decryptionMessage);
        String value234 = scanner.nextLine();
        System.out.println("\nPrinting out the results of running the Vigenere Cipher.\n");
        String value23488 = scanner.nextLine();
        // declare the starting file and scanner
        File inputFile3 = null;
        Scanner scann1 = null;
        // connect the scanner to the input file
        try {
          inputFile3 = new File("input/numbers30000.csv");
          scann1 = new Scanner(inputFile3);
        } catch (FileNotFoundException noFile) {
          System.out.println("Unable to locate the input file");
        }
        int[] numbers1 = new int[30000]; // needs to be changed per input file
        for (int count1 = 0; count1 < numbers1.length; count1++) {
          numbers1[count1] = scann1.nextInt();
        }
        System.out.println("Size of the array is: " + numbers1.length);
        long startTime1 = System.currentTimeMillis();
        long endTime1 = System.currentTimeMillis();
        long elapsed1 = endTime1 - startTime1;
        System.out.println("Running Time: " + elapsed1);
        String value2345 = scanner.nextLine();
        System.out.println("\nThank you for using \"Useful Tool for Spies\", a Cipher Program!");
        System.out.println("Have a nice day!");
      }
    } else if (choiceEntry == valueUpperLimit) {
      System.out.println("\nYou have chosen the Java Cipher!");
      Scanner scanner = new Scanner(System.in);
      char password3[] = null;
      try {
        password3 = PasswordField.getPassword(System.in, "Please enter your message: \n");
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
      if (password3 == null) {
        System.out.println("\nNo message was entered.");
      } else {
        System.out.println("\nPlease enter your desired word to use as your key.\n");
        String key3 = scanner.nextLine();
        System.out.println("\nPlease enter a shift value from 0-25.\n");
        int shifter1 = scanner.nextInt();
        System.out.println("\nEncrypting your message...");
        VigenereCipher message2 = new VigenereCipher();
        String hello = String.valueOf(password3);
        String wordy = message2.encryptInput(hello, key3);
        CaesarianCipher message3 = new CaesarianCipher();
        String finalEncryption = message3.encryptedMessage(wordy, shifter1);
        System.out.println("\nEncrypted Text: \n");
        System.out.println(finalEncryption);
        System.out.println("\nPress any character to view your decrypted message.\n");
        String ddddd = scanner.nextLine();
        String kevin = scanner.nextLine();
        CaesarianCipher word1 = new CaesarianCipher();
        String decryption1 = word1.decryptedMessage(finalEncryption, shifter1);
        VigenereCipher table = new VigenereCipher();
        String finalDecryption = table.decryptOutput(decryption1, key3);
        System.out.println("\nDecrypted Message: \n");
        System.out.println(finalDecryption);
        System.out.println("\nPrinting out the results of running the Vigenere Cipher.\n");
        String value2349 = scanner.nextLine();
        // declare the starting file and scanner
        File inputFile4 = null;
        Scanner scann2 = null;
        // connect the scanner to the input file
        try {
          inputFile4 = new File("input/numbers30000.csv");
          scann2 = new Scanner(inputFile4);
        } catch (FileNotFoundException noFile) {
          System.out.println("Unable to locate the input file");
        }
        int[] numbers2 = new int[30000]; // needs to be changed per input file
        for (int count2 = 0; count2 < numbers2.length; count2++) {
          numbers2[count2] = scann2.nextInt();
        }
        System.out.println("Size of the array is: " + numbers2.length);
        long startTime2 = System.currentTimeMillis();
        long endTime2 = System.currentTimeMillis();
        long elapsed2 = endTime2 - startTime2;
        System.out.println("Running Time: " + elapsed2);
        String value2347 = scanner.nextLine();
        System.out.println("\nThank you for using \"Useful Tool for Spies\", a Cipher Program!");
        System.out.println("Have a nice day!");
      }
    } else {
      System.out.println("\nPlease try again with a valid choice.");
    }
  }
}
