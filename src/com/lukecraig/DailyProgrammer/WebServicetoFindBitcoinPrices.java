package com.lukecraig.DailyProgrammer;
/**
 * @author Luke Craig
 * @Date: Aug 20, 2015
 */

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebServicetoFindBitcoinPrices {
  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    System.out.println(new Scanner(new URL(
        "http://api.bitcoincharts.com/v1/trades.csv?symbol=" + sc.nextLine() + sc.nextLine())
            .openStream()).useDelimiter("\\A").next().split(",")[1]);
  }
}
