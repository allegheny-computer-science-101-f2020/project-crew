package project;

import java.util.Scanner;

/**
 * Class containing the Caesarian encryption and decryption method.
 *
 * @author Adriana Solis
 * @author Kevin Lee
 * @author Gabe Schwartz
 */

public class CaesarianCipher {

  /* value of the alphabet. */
  public static final String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789 ";

  /**
  * start of the encryption method for the user generated input.
  */
  public static String encryptedMessage(String input, int shifter) {

    // converts the input from the user to lowercase for simplicity
    input = input.toLowerCase();

    // initializing an empty string
    String output = "";

    // assigns an integer value to each letter of the alphabet
    for (int i = 0; i < input.length(); i++) {

      char encrypt = input.charAt(i);
      int value = alphabet.indexOf(encrypt);

      // finds out what the value of the shift is
      int shiftValue = (shifter + value) % alphabet.length();

      // finds out what character needs to be replaced
      char replacedValue = alphabet.charAt(shiftValue);

      // adding this to the output
      output += replacedValue;
    }
    return output.toString();
  }

  /**
  * start of the decryption method from the user generated input.
  */
  public static String decryptedMessage(String output, int shifter) {

    // converst the output into lowercase for simplicity
    output = output.toLowerCase();

    // initializes an empty String
    String input = "";

    for (int i = 0; i < output.length(); i++) {

      char decrypt = output.charAt(i);
      int val = alphabet.indexOf(decrypt);

      int val2 = (val - shifter) % alphabet.length();

      if (val2 < 0) {
        val2 += Math.abs(alphabet.length());
      }
      char val3 = alphabet.charAt(val2);
      input += val3;
    }
    return input.toString();
  }
}
