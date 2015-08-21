/**
 * @author Luke Craig
 * @Date: Jul 16, 2015
 */
package com.lukecraig.DailyProgrammer;

import java.io.IOException;

public class MakingNumbersPalindromic {
  public static int steps(int x) {
    StringBuffer sb = new StringBuffer(x);

    if (sb.toString().equals(sb.reverse().toString()))
      return 1;
    else
      return 1 + steps(Integer.parseInt(sb.toString()) + Integer.parseInt(sb.reverse().toString()));
  }

  public static void main(String[] args) {
    int[] testData = {123, 286, 196196871};
    for (int x : testData) {
      System.out.println(x + " becomes palindromic after " + steps(x) + " steps.");
    }
  }
}
