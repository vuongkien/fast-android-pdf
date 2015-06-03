package com.vmodev.pdfwriter.model;

import android.graphics.Color;

import java.text.DecimalFormat;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFColor {

   //String red value
   private String rColor;
   //String green value
   private String gColor;
   //String blue value
   private String bColor;
   //Default color
   private PredefinedColor color = PredefinedColor.NoColor;

   public String getrColor() {
      return rColor;
   }

   public void setrColor(String rColor) {
      this.rColor = rColor;
   }

   public String getgColor() {
      return gColor;
   }

   public void setgColor(String gColor) {
      this.gColor = gColor;
   }

   public String getbColor() {
      return bColor;
   }

   public void setbColor(String bColor) {
      this.bColor = bColor;
   }

   public PredefinedColor getColor() {
      return color;
   }

   public void setColor(PredefinedColor color) {
      this.color = color;
   }


   /**
    * Class's Constructor
    *
    * @param newColor Color
    */
   public PDFColor(PredefinedColor newColor) {
      switch (newColor) {
         case NoColor:
            rColor = "";
            gColor = "";
            bColor = "";
            break;
         case Black:
            rColor = "0";
            gColor = "0";
            bColor = "0";
            break;
         case White:
            rColor = "1";
            gColor = "1";
            bColor = "1";
            break;
         case Red:
            rColor = "1";
            gColor = "0";
            bColor = "0";
            break;
         case LightRed:
            rColor = "1";
            gColor = ".75";
            bColor = ".75";
            break;
         case DarkRed:
            rColor = ".5";
            gColor = "0";
            bColor = "0";
            break;
         case Orange:
            rColor = "1";
            gColor = ".5";
            bColor = "0";
            break;
         case LightOrange:
            rColor = "1";
            gColor = ".75";
            bColor = "0";
            break;
         case DarkOrange:
            rColor = "1";
            gColor = ".25";
            bColor = "0";
            break;
         case Yellow:
            rColor = "1";
            gColor = "1";
            bColor = ".25";
            break;
         case LightYellow:
            rColor = "1";
            gColor = "1";
            bColor = ".75";
            break;
         case DarkYellow:
            rColor = "1";
            gColor = "1";
            bColor = "0";
            break;
         case Blue:
            rColor = "0";
            gColor = "0";
            bColor = "1";
            break;
         case LightBlue:
            rColor = ".1";
            gColor = ".3";
            bColor = ".75";
            break;
         case DarkBlue:
            rColor = "0";
            gColor = "0";
            bColor = ".5";
            break;
         case Green:
            rColor = "0";
            gColor = "1";
            bColor = "0";
            break;
         case LightGreen:
            rColor = ".75";
            gColor = "1";
            bColor = ".75";
            break;
         case DarkGreen:
            rColor = "0";
            gColor = ".5";
            bColor = "0";
            break;
         case Cyan:
            rColor = "0";
            gColor = ".5";
            bColor = "1";
            break;
         case LightCyan:
            rColor = ".2";
            gColor = ".8";
            bColor = "1";
            break;
         case DarkCyan:
            rColor = "0";
            gColor = ".4";
            bColor = ".8";
            break;
         case Purple:
            rColor = ".5";
            gColor = "0";
            bColor = "1";
            break;
         case LightPurple:
            rColor = ".75";
            gColor = ".45";
            bColor = ".95";
            break;
         case DarkPurple:
            rColor = ".4";
            gColor = ".1";
            bColor = ".5";
            break;
         case Gray:
            rColor = ".5";
            gColor = ".5";
            bColor = ".5";
            break;
         case LightGray:
            rColor = ".75";
            gColor = ".75";
            bColor = ".75";
            break;
         case DarkGray:
            rColor = ".25";
            gColor = ".25";
            bColor = ".25";
            break;
      }
      color = newColor;
   }

   /**
    * Class's Constructor
    *
    * @param rColor String red value
    * @param gColor String green value
    * @param bColor String blue value
    */
   public PDFColor(String rColor, String gColor, String bColor) {
      this.rColor = rColor;
      this.gColor = gColor;
      this.bColor = bColor;
   }

   /**
    *
    * @param hexColor String color
    */
   public PDFColor(String hexColor){
      int color = Color.parseColor(hexColor);
      int r = (color >> 16) & 0xFF;
      int g = (color >> 8) & 0xFF;
      int b = (color) & 0xFF;
      DecimalFormat format = new DecimalFormat("#.##");
      rColor = format.format(r / (double) 255);
      gColor = format.format(g / (double) 255);
      bColor = format.format(b / (double) 255);
      this.color = PredefinedColor.Black;
   }



   /**
    * Method that validates the color
    *
    * @return Boolean value that represents the validity of the color
    */
   public boolean isColor() {
      return (color != PredefinedColor.NoColor);
   }
}
