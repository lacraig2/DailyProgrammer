package com.lukecraig.DailyProgrammer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author Luke Craig
 * @Date: Aug 3, 2015
 */

public class AddingFractions {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int x = Integer.parseInt(br.readLine());
      Fraction[] list = new Fraction[x];
      long total = 1;
      for (int i = 0; i < x; i++) {
        String[] input = br.readLine().split("/");
        list[i] = new Fraction(Long.parseLong(input[0]), Long.parseLong(input[1]));
        total *= list[i].y;
      }
      br.close();
      long top = 0;
      for (int i = 0; i < x; i++) {
        top += (list[i].x * (total / list[i].y));
      }
      Fraction totes = new Fraction(top, total);
      totes.simplify();
      System.out.println(totes.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


class Fraction {
  public long x, y;

  public Fraction(long x, long y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return x + "/" + y;
  }

  public long gcd(long a, long b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public void simplify() {
    long gcd = gcd(x, y);
    if (gcd > 1) {
      this.x = this.x / gcd;
      this.y = this.y / gcd;
      gcd = gcd(x, y);
    }
  }
}
