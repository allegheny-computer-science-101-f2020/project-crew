package project;

import java.io.*;
import java.util.*;

/**
* This class questions the user for an input in the terminal window.
* and attempts to mask input with "*".
*
* @author Quisay H. Mahmoud
* @author Alan Sommerer
* @author Adriana Solis
*/
public class PasswordField {

  /**
  *@param input stream to be used (e.g. System.in)
  *@param question The question to display to the user.
  *@return The message as entered by the user.
  */

  public static final char[] getPassword(InputStream in, String question) throws IOException {
    MaskingThread maskingThread = new MaskingThread(question);
    Thread thread = new Thread(maskingThread);
    thread.start();

    char[] lineBuffer;
    char[] buf;
    int i;

    buf = lineBuffer = new char[128];

    int room = buf.length;
    int offset = 0;
    int c;

    loop:   while (true) {
      switch (c = in.read()) {
        case -1:
        case '\n':
        break loop;

        case '\r':
        int c2 = in.read();
        if ((c2 != '\n') && (c2 != -1)) {
          if (!(in instanceof PushbackInputStream)) {
            in = new PushbackInputStream(in);
          }
          ((PushbackInputStream)in).unread(c2);
        } else {
          break loop;
        }

        default:
        if (--room < 0) {
            buf = new char[offset + 128];
            room = buf.length - offset - 1;
            System.arraycopy(lineBuffer, 0, buf, 0, offset);
            Arrays.fill(lineBuffer, ' ');
            lineBuffer = buf;
          }
          buf[offset++] = (char) c;
          break;
      }
    }
    maskingThread.stopMasking();
    if (offset == 0) {
      return null;
    }
    char[] ret = new char[offset];
    System.arraycopy(buf, 0, ret, 0, offset);
    Arrays.fill(buf, ' ');
    return ret;
  }
}
