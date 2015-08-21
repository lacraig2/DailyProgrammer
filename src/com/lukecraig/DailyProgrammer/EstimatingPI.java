/**
 * @author Luke Craig
 * @Date: Aug 3, 2015
 */
package com.lukecraig.DailyProgrammer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EstimatingPI {
  public static void main(String[] args) throws IOException {
    for (String file : new String[] {"images/image1.png", "images/image2.png"}) {
      System.out.println(new EstimatingPI(file).getPI());
    }
  }

  private final BufferedImage image;


  public EstimatingPI(String file) throws IOException {
    image = ImageIO.read(new File(file));
  }

  public double getPI() {
    int width = image.getWidth(), height = image.getHeight(), blackPixels = 0,
        minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int rgb = image.getRGB(i, j);
        if (rgb != -1) {
          blackPixels++;
          if (i < minX) {
            minX = i;
          }
          if (i > maxX) {
            maxX = i;
          }
        }
      }
    }
    int diameter = maxX - minX;

    return ((double) blackPixels) / ((diameter / 2d) * (diameter / 2d));
  }

}
