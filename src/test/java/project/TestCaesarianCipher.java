package project;

import org.junit.Test;

import static org.junit.Assert.*;

/**
* A JUnit test suite.
*
* @author Adriana Solis
* @author Kevin Lee
* @author Gabe Schwartz
*/

public class TestCaesarianCipher {
  // add your implementation of the test cases
  private CaesarianCipher cipher = new CaesarianCipher();
  /* Tests that the cipher should do nothing with an empty message. */
  @Test
  public void cipherShouldDoNothingWithEmptyMessageWithShifter3() {
    assertEquals("", cipher.encryptedMessage("", 3));
  }

  /* Tests that the cipher should encrypt lowercase letters. */
  @Test
  public void cipherShouldEncryptLowercaseLetters() {
    assertEquals("a", cipher.encryptedMessage("a", 0));
    assertEquals("g", cipher.encryptedMessage("a", 6));
    assertEquals("h", cipher.encryptedMessage("a", 7));
    assertEquals("l", cipher.encryptedMessage("a", 11));
    assertEquals("v", cipher.encryptedMessage("a", 21));
  }

  /* Tests that the cipher should encrypt uppercase letters. */
  @Test
  public void cipherShouldEncryptUppercaseLetters() {
    assertEquals("a", cipher.encryptedMessage("A", 0));
    assertEquals("d", cipher.encryptedMessage("A", 3));
    assertEquals("h", cipher.encryptedMessage("A", 7));
    assertEquals("l", cipher.encryptedMessage("A", 11));
    assertEquals("t", cipher.encryptedMessage("A", 19));
  }

  /* Tests that the cipher should encrypt the entire alphabet. */
  @Test
  public void cipherShouldEncryptAlphabetWithShitfer3() {
    String alph = "the quick brown fox jumps over the lazy dog";
    String encrypt = cipher.encryptedMessage(alph, 3);
    assertEquals(encrypt, cipher.encryptedMessage(alph, 3));
  }

  /* Tests that the cipher can decrypt the users message. */
  @Test
  public void cipherShouldDecryptMessageWithShifter3() {
    String message = "hello";
    String encrypt = cipher.encryptedMessage(message, 3);
    assertEquals(message, cipher.encryptedMessage(encrypt, -3));
  }
}
