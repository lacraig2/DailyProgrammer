/**
 * @author Luke Craig
 * @Date: Jul 16, 2015
 */
package com.lukecraig.DailyProgrammer;

public class WordSnake221 {

    public static void main(String[] args) {
	String[] words = "SHENANIGANS SALTY YOUNGSTER ROUND DOUBLET TERABYTE ESSENCE"
		.split(" ");
	if (!isProperInput(words)) {
	    System.out.println("Improper input");
	    System.exit(0);
	}
	int x = 0;
	for (int i = 0; i < words.length; i++) {
	    if (i % 2 == 0) {
		System.out.println(new String(new char[x]).replace('\0', ' ')
			+ words[i]);
		x += words[i].length() - 1;
	    } else {
		for (int j = 1; j < words[i].length() - 1; j++) {
		    System.out.println(new String(new char[x]).replace('\0',
			    ' ') + (words[i].charAt(j)));
		}
	    }
	}
    }

    public static boolean isProperInput(String[] words) {
	for (int i = 0; i < words.length - 1; i++)
	    if (words[i].charAt(words[i].length() - 1) != words[i + 1]
		    .charAt(0))
		return false;
	return true;
    }
}
