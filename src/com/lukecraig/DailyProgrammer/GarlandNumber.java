/**
 * @author Luke Craig
 * @Date: Jul 16, 2015
 */
package com.lukecraig.DailyProgrammer;

public class GarlandNumber {

  public static int garland(String s) {
    for (int i = s.length() - 1; i > 0; i--) {
      if (s.substring(0, i).equals(s.substring(s.length() - i))) {
        return i;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    String[] testData = {"programmer", "ceramic", "onion", "alfalfa"};
    for (String s : testData)
      System.out.println(s + " -> " + garland(s));
  }
}
