package com.lukecraig.DailyProgrammer;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Luke Craig
 * @Date: Aug 20, 2015
 */

public class LettersIn {
  public static void main(String[] args) {
    String s =
        "billowy\nbiopsy\nchinos\ndefaced\nchintz\nsponged\nbijoux\nabhors\nfiddle\nbegins\nchimps\nwronged";
    Scanner sc = new Scanner(s);
    String[] input = sc.useDelimiter("\\A").next().split("\n");
    sc.close();
    for (int i = 0; i < input.length; i++) {
      System.out.print("\t");
      if (isInOrder(input[i]))
        System.out.println(input[i] + " IN ORDER");
      else if (isInReverseOrder(input[i]))
        System.out.println(input[i] + " REVERSE ORDER");
      else
        System.out.println(input[i] + " NOT IN ORDER");
    }
  }

  public static boolean isInOrder(String s) {
    char c = s.charAt(0);
    for (char m : s.toCharArray()) {
      if (!(m >= c))
        return false;
      c = m;
    }
    return true;
  }

  public static boolean isInReverseOrder(String s) {
    char c = s.charAt(0);
    for (char m : s.toCharArray()) {
      if (m > c)
        return false;
      c = m;
    }
    return true;
  }
}
