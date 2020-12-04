package project;
import java.lang.*;
import java.util.Scanner;
import java.util.*;
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
    final int VALUE_LOWER_LIMIT = 1;
    final int VALUE_MIDDLE_LIMIT = 2;
    final int VALUE_UPPER_LIMIT = 3;
    System.out.println("Welcome to \"Useful Tool for Spies\", a Cipher program!");
    System.out.println();
    System.out.println("Please choose your desired cipher from the available options below.");
    System.out.println();
    System.out.println("Cipher 1: Caesarian Cipher");
    System.out.println("Cipher 2: Vigenere Cipher");
    System.out.println("Cipher 3: Java Cipher");
    System.out.println();
    Scanner scanChoice = new Scanner(System.in);
    System.out.println("Enter \"1\", \"2\" or \"3\": ");
    System.out.println();
    int choiceEntry = scanChoice.nextInt();
    if (choiceEntry == VALUE_LOWER_LIMIT) {
      System.out.println();
      System.out.println("You have chosen the Caesarian Cipher!");
      System.out.println();
      Scanner scanner = new Scanner(System.in);
      char password[] = null;
        try {
          password = PasswordField.getPassword(System.in, "Please enter your message: ");
        } catch(IOException ioe) {
          ioe.printStackTrace();
        }
        if (password == null) {
          System.out.println("No message was entered.");
        } else {
          System.out.println();
          System.out.println("Please enter a shift value from 0-26: ");
          System.out.println();
          int shiftedValue = scanner.nextInt();
          System.out.println();
          System.out.println("Encrypting your message...");
          System.out.println();
          CaesarianCipher encrypt = new CaesarianCipher();
          String userInput = String.valueOf(password);
          String encryptedMessages = encrypt.encryptedMessage(userInput, shiftedValue);
          System.out.println("Encrypted Text:");
          System.out.println();
          System.out.println(encryptedMessages);
          System.out.println();
          System.out.println("Press any character to view your decrypted message.");
          System.out.println();
          String dval = scanner.nextLine();
          System.out.println();
          String userInput2 = scanner.nextLine();
          System.out.println();
          CaesarianCipher decrypt = new CaesarianCipher();
          String decryptedMessages = decrypt.decryptedMessage(encryptedMessages, shiftedValue);
          System.out.println("Decrypted Text:");
          System.out.println(decryptedMessages);
          scanner.close();
          System.out.println();
          System.out.print("Thank you for using \"Useful Tool for Spies\", a Cipher Program!");
          System.out.print(" Have a nice day!");
          System.out.println();
        }

    } else if (choiceEntry == VALUE_MIDDLE_LIMIT) {
      System.out.println();
      System.out.println("You have chosen the Vigenere Cipher!");
      System.out.println();
      Scanner scanner = new Scanner(System.in);
      char password2[] = null;
      try {
        password2 = PasswordField.getPassword(System.in, "Please enter your message: ");
      } catch(IOException ioe) {
        ioe.printStackTrace();
      }
      if (password2 == null) {
        System.out.println("No message was entered.");
      } else {
        System.out.println();
        System.out.println("Please enter your desired key.");
        String key2 = scanner.nextLine();
        System.out.println();
        System.out.println("Encrypting your message...");
        System.out.println();
        VigenereCipher vigenereMessage = new VigenereCipher();
        String messageFromUser = String.valueOf(password2);
        String encryptionOfMessage = vigenereMessage.encryptInput(messageFromUser, key2);
        System.out.println("Encrypted Text:");
        System.out.println();
        System.out.println(encryptionOfMessage);
        System.out.println();
        System.out.println("Press any character to view your decrypted message.");
        System.out.println();
        String dval = scanner.nextLine();
        System.out.println();
        VigenereCipher vigenereMessage2 = new VigenereCipher();
        String decryptionMessage = vigenereMessage2.decryptOutput(encryptionOfMessage, key2);
        System.out.println("Decrypted Message:");
        System.out.println();
        System.out.println(decryptionMessage);
        System.out.println();
        System.out.print("Thank you for using \"Useful Tool for Spies\", a Cipher Program!");
        System.out.print(" Have a nice day!");
        System.out.println();
      }
    } else if (choiceEntry == VALUE_UPPER_LIMIT) {
      System.out.println();
      System.out.println("You have chosen the Java Cipher!");

    }
  }
}
