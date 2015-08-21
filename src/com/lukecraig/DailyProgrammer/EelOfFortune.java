/**
 * @author Luke Craig
 * @Date: Jul 16, 2015
 */
package com.lukecraig.DailyProgrammer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EelOfFortune {

  public static String getFilledChars(char[] z) {
    String s = "";
    for (char c : z)
      if (Character.isAlphabetic(c))
        s += c;
    return s;
  }

  public static boolean problem(String word, String testCaseWord) {
    String regex = "[^" + testCaseWord + "]";
    word = word.toLowerCase().replaceAll(regex, "");

    if (word.equals(testCaseWord))
      return true;

    return false;
  }

  public static void main(String[] args) {
    // challenge #1
    String[] c = {"synchronized", "misfunctioned", "mispronounced", "shotgunned", "snond"};
    for (String b : c)
      System.out.println(b + " " + problem(b, "snond"));

    // challenge #1
    try {
      Scanner sc = new Scanner(new File("enable1.txt"));
      int count = 0;
      while (sc.hasNextLine()) {
        String s = sc.nextLine();
        for (String q : c)
          if (problem(q, s))
            count++;
      }
      System.out.println(count);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

}
