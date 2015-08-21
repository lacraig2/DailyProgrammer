/**
 * @author Luke Craig
 * @Date: Jul 16, 2015
 */
package com.lukecraig.DailyProgrammer;

import java.util.Iterator;
import java.util.Scanner;

public class SimpleStream {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a message: ");
    String message = sc.nextLine();
    System.out.print("Enter a seed: ");
    int seed = sc.nextInt();
    SimpleStream stream = new SimpleStream();
    message = stream.encrypt(message, seed);
    System.out.println("Encrypted: \"" + message + "\"");
    message = stream.decrypt(message, seed);
    System.out.println("Decrypted: " + message);
    sc.close();
  }

  public String encrypt(String original, int seed) {
    char[] bs = original.toCharArray();
    LCGStream stream = new LCGStream(128, 1023021, 79509, seed);
    for (int x = 0; x < bs.length; x++) {
      bs[x] = (char) ((int) bs[x] ^ stream.next());
    }
    return new String(bs);
  }

  public String decrypt(String encoded, int seed) {
    return encrypt(encoded, seed);
  }

  public class LCGStream implements Iterator<Integer> {
    private int modulus, multi, incre, seed;

    public LCGStream(int modulus, int multi, int incre, int seed) {
      this.modulus = modulus;
      this.multi = multi;
      this.incre = incre;
      this.seed = seed;
    }

    @Override
    public boolean hasNext() {
      return true;
    }

    @Override
    public Integer next() {
      seed = (seed * multi + incre) % modulus;
      return seed;
    }

  }
}
