# Report by Kevin Lee, Adriana Solis, Gabe Schwartz

## Design of your Program

Hi Professor JJ,
Our group wanted to design three different kinds of ciphers, which would each be able to encrypt and decrypt a message. First a foremost, this tool is supposed to be a tool that is enhances secrecy, so we have also developed a cipher that will hide a message with asterisks, as it is written into our program, while waiting to be encrypted.
We were able to design our program by having two paths within our SRC folder. Within our SRC folder we have one path named MAIN and our second path, which is named TEST. The main path is where our program exists and the TEST folder is where our test cases for our program exists. Within our MAIN folder, we have split up our program into three different folders. One folder, named project, to host our CipherProgram.java, which is built to implement the use of our ciphers. This java file has hard coding in it too allow the calling of our three ciphers and will also allow system inputs/ system print statements. This will allow people to interact with our cipher when our program is run. Therefore, we have a Caesarian Cipher and Vigenere Cipher, within the 2nd folder called "ciphers" within our MAIN folder, to be called upon by our CipherProgram.java. We have also used those two ciphers to call upon their methods in order to create a third cipher within our CipherProgram.java
Furthermore, we have created more java files, within the file "hidden message" within MAIN, in order to create secrecy when using our cipher program. The MaskingThread.java and our PasswordField.java, are called upon by CipherProgram.java, in order to hide the message with asterisks.  

## Implementation of your Program

The implementation of our program translates to the design of our program and it is a very long explanation, so I will break it down through notes and a list format.

CipherProgram.java
- Import necessary java packages, such as a scanner
- Define each cipher by assigning a numerical value
- Hard coding of system print line statements and system input variables
- Call upon Cipher methods according to the cipher you are trying to use
- Call upon masking thread and passwordfield.java method implementations
- Rinse and repeat steps for the next ciphers
- Java Cipher, rinse and repeat steps, but call methods from both the CaesarianCipher and VigenereCipher

CaesarianCipher.java (Encryption)
- Define the user generated inputs
- Assign integer value to each letter and implement shift
-

CaesarianCipher.java (Decryption)
- turn values into lower case
- decrypt using the user generated input

VignereCipher.java (Encryption)
- Define strings for output and input (user generated inputs)
- Create key for the output for decryption
- Declare the alphabet that will be used for encryption and decryption of message
- Use a for loop iteration for each individual letter being encrypted and the current letter in the key being supposed
- shift using the loop iteration

VignereCipher.java (Decryption)
- create a for loop iteration to for each individual letter being decrypted
- shift using the loop iteration

MaskingThread.java
- try catch block to initiate masking with chosen symbol
- bring back the what was given

PasswordField.java
- Implement an iteration to mask a input with chosen symbol

TestCaesarianCipher.java
- Testing that the cipher will not handle empty messages from users
- Test that the cipher should be able to encrypt and decrypt Uppercase and Lowercase letters
- Test that the cipher should be able to encrypt the entire alphabet
- Test that the cipher should be able to decrypt the users input

TestVigenereCipher.java
- Testing that the cipher will not handle empty messages from users
- Test that the cipher should be able to encrypt and decrypt Uppercase and Lowercase letters


TestJavaCipher.java
- Testing that the cipher will not handle empty messages from users
- Test that the cipher should be able to encrypt and decrypt Uppercase and Lowercase letters


## Evaluation and Testing of your Program

Include program input and output and output of test cases in code blocks

INPUT
```
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
```

OUPUT

```
bash-5.0# gradle run

> Task :run
Welcome to "Useful Tool for Spies", a Cipher program!

Please choose your desired cipher from the available options below.

Cipher 1: Caesarian Cipher
Cipher 2: Vigenere Cipher
Cipher 3: Java Cipher

Enter "1", "2" or "3":

1

You have chosen the Caesarian Cipher!

Please enter your message:
***m*****************                  
*
Please enter a shift value from 0-26:

7

Encrypting your message...

Encrypted Text:

jvtw10lygzjplujlg878

Press any character to view your decrypted message.

hi

Decrypted Text:

computer science 101

Printing out the results of running the Caesarian Cipher.
```
```
bash-5.0# gradle run

> Task :run
Welcome to "Useful Tool for Spies", a Cipher program!

Please choose your desired cipher from the available options below.

Cipher 1: Caesarian Cipher
Cipher 2: Vigenere Cipher
Cipher 3: Java Cipher

Enter "1", "2" or "3":

2

You have chosen the Vigenere Cipher!

Please enter your message:
*****************************
*
Please enter your desired word to use as your key.

what

Encrypting your message...

Encrypted Text:

yvmiqaek ojixjje 101 bo koia

Press any character to view your decrypted message.

hi

Decrypted Message:

computer science 101 is dope
```
```
bash-5.0# gradle run

> Task :run
Welcome to "Useful Tool for Spies", a Cipher program!

Please choose your desired cipher from the available options below.

Cipher 1: Caesarian Cipher
Cipher 2: Vigenere Cipher
Cipher 3: Java Cipher

Enter "1", "2" or "3":

3

You have chosen the Java Cipher!
Please enter your message:
********o**************
*
Please enter your desired word to use as your key.

Whats Up

Please enter a shift value from 0-25.

14

Encrypting your message...

Encrypted Text:

32ouqnawxnzb2b 50r1n4x

Press any character to view your decrypted message.

hi

Decrypted Message:

thank you professor jj

Printing out the results of running the Vigenere Cipher.

```
```
bash-5.0# gradle test

> Task :test

project.TestCaesarianCipher > cipherShouldDoNothingWithEmptyMessageWithShifter3 PASSED

project.TestCaesarianCipher > cipherShouldEncryptLowercaseLetters PASSED

project.TestCaesarianCipher > cipherShouldEncryptUppercaseLetters PASSED

project.TestCaesarianCipher > cipherShouldEncryptAlphabetWithShitfer3 PASSED

project.TestCaesarianCipher > cipherShouldDecryptMessageWithShifter3 PASSED

project.TestJavaCipher > cipherShouldDoNothingWithEmptyMessageWithShifter3 PASSED

project.TestJavaCipher > cipherShouldEncryptLowercaseLetters PASSED

project.TestJavaCipher > cipherShouldEncryptUppercaseLetters PASSED

project.TestJavaCipher > cipherShouldEncryptAlphabetWithShitfer3 PASSED

project.TestJavaCipher > cipherShouldDecryptMessageWithShifter3 PASSED

project.TestJavaCipher > vigenereCipherShouldEncryptLowercaseLetterss PASSED

project.TestVigenereCipher > vigenereCipherShouldEncryptLowercaseLetters PASSED

project.TestVigenereCipher > vigenereCipherShouldEncryptUppercaseLetters PASSED

```

Include commands needed to run and test your project

## Description of the challenges that you faced and how you resolved them

The biggest challenge we faced during this project, as a group, was researching how to implement the ability to mask the messages we type into our cipher. This was a tactic that we were eager to accomplish because we thought it would be very cool. However, we figured that we never learned how to do such a thing. Therefore, we called upon the internet to read a lot of guides.
The guides helped a lot, but the loop we were trying to create were very hard. We understood the concept, but we were not able to break down the steps. The issue was not being able to deconstruct what we learned into simple steps we could implement into our code. Therefore, we combined our research and talked about how we think this part of the program should be built. We discussed what our goal was and the small steps that we needed to accomplish a task. We were able to respond to each others ideas and figure out how create a iteration that will be able to accomplish the task we wanted. We were able to complete the task of hiding our message through conversing and a lot of trial and error. It was a three hour process, but we were eventually able to complete the task.

## If worked in a team, description of the way in which you and your team members shared the project work

We divided up the tasks as followed and it worked really well.
Group work
- Talk about project and ideas
- Research how to implement ciphers and continually brainstorm ideas together
- Teach each other what we learned from our research and grow together

Individual work (Adriana)
- Adriana was responsible for the Caesarian Cipher and the Test Caesarian Cipher
- Adriana was also responsible for most of the coding for the MaskingThread.java and PasswordField.Java

Individual work (Gabe)
- Gabe was responsible for the VigenereCipher and Test VigenereCipher

Individual work(Kevin)
- Kevin was responsible for the hard coding within the CipherProgram.Java
- Kevin was responsible for writing the proposal, update, and report
- Kevin was responsible for writing the Java cipher
- Kevin was responsible for writing the Test TestJavaCipher
