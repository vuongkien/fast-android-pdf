package com.vmodev.pdfwriter.model;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * A Class that implements a PDF line.
 */
public class LineElement extends PDFElement {

   private int coordX1;
   private int coordY1;
   private PDFLineStyle lineStyle;

   /**
    * Class's Constructor
    *
    * @param X  Start X position
    * @param Y  Start Y position
    * @param X1 End X position
    * @param Y1 End Y position
    */
   public LineElement(int X, int Y, int X1, int Y1) {
      this.coordX = X;
      this.coordY = Y;
      this.coordX1 = X1;
      this.coordY1 = Y1;
      this.lineStyle = new PDFLineStyle(1, PredefinedLineStyle.Normal);
   }

   /**
    * Class's Constructor
    *
    * @param X        Start X position
    * @param Y        Start Y position
    * @param X1       End X position
    * @param Y1       End Y position
    * @param newWidth Line's width
    */
   public LineElement(int X, int Y, int X1, int Y1, int newWidth) {
      this.coordX = X;
      this.coordY = Y;
      this.coordX1 = X1;
      this.coordY1 = Y1;
      this.lineStyle = new PDFLineStyle(newWidth, PredefinedLineStyle.Normal);
   }

   /**
    * Class's Constructor
    *
    * @param X        Start X position
    * @param Y        Start Y position
    * @param X1       End X position
    * @param Y1       End Y position
    * @param newStyle Line's style
    */
   public LineElement(int X, int Y, int X1, int Y1, PredefinedLineStyle newStyle) {
      this.coordX = X;
      this.coordY = Y;
      this.coordX1 = X1;
      this.coordY1 = Y1;
      this.lineStyle = new PDFLineStyle(newStyle);
   }

   /**
    * Class's Constructor
    *
    * @param X        Start X position
    * @param Y        Start Y position
    * @param X1       End X position
    * @param Y1       End Y position
    * @param newWidth Line's width
    * @param newStyle Line's style
    */
   public LineElement(int X, int Y, int X1, int Y1, int newWidth, PredefinedLineStyle newStyle) {
      this.coordX = X;
      this.coordY = Y;
      this.coordX1 = X1;
      this.coordY1 = Y1;
      this.lineStyle = new PDFLineStyle(newWidth, newStyle);
   }

   /**
    * Class's Constructor
    *
    * @param X        Start X position
    * @param Y        Start Y position
    * @param X1       End X position
    * @param Y1       End Y position
    * @param newColor Line's color
    */
   public LineElement(int X, int Y, int X1, int Y1, PredefinedColor newColor) {
      this.coordX = X;
      this.coordY = Y;
      this.coordX1 = X1;
      this.coordY1 = Y1;
      this.strokeColor = new PDFColor(newColor);
      this.lineStyle = new PDFLineStyle(1, PredefinedLineStyle.Normal);
   }

   /**
    * Class's Constructor
    *
    * @param X        Start X position
    * @param Y        Start Y position
    * @param X1       End X position
    * @param Y1       End Y position
    * @param newStyle Line's style
    * @param newColor Line's color
    */
   public LineElement(int X, int Y, int X1, int Y1, PredefinedLineStyle newStyle,
                      PredefinedColor newColor) {
      this.coordX = X;
      this.coordY = Y;
      this.coordX1 = X1;
      this.coordY1 = Y1;
      this.strokeColor = new PDFColor(newColor);
      this.lineStyle = new PDFLineStyle(1, newStyle);
   }

   /**
    * Class's Constructor
    *
    * @param X        Start X position
    * @param Y        Start Y position
    * @param X1       End X position
    * @param Y1       End Y position
    * @param newWidth Line's width
    * @param newColor Line's color
    */
   public LineElement(int X, int Y, int X1, int Y1, int newWidth, PredefinedColor newColor) {
      this.coordX = X;
      this.coordY = Y;
      this.coordX1 = X1;
      this.coordY1 = Y1;
      this.strokeColor = new PDFColor(newColor);
      this.lineStyle = new PDFLineStyle(newWidth, PredefinedLineStyle.Normal);
   }


   /**
    * Class's Constructor
    *
    * @param X        Start X position
    * @param Y        Start Y position
    * @param X1       End X position
    * @param Y1       End Y position
    * @param newWidth Line's width
    * @param newStyle Line's style
    * @param newColor Line's color
    */
   public LineElement(int X, int Y, int X1, int Y1, int newWidth, PredefinedLineStyle newStyle, PredefinedColor newColor) {
      this.coordX = X;
      this.coordY = Y;
      this.coordX1 = X1;
      this.coordY1 = Y1;
      this.strokeColor = new PDFColor(newColor);
      this.lineStyle = new PDFLineStyle(newWidth, newStyle);
   }

   @Override
   public String getText() {
      StringBuilder resultLine = new StringBuilder();
      StringBuilder lineContent = new StringBuilder();
      if (strokeColor.isColor()) {
         lineContent.append(strokeColor.getrColor() + " " + strokeColor.getgColor() + " " + strokeColor
            .getbColor() + " RG" + (char) 13 + (char) 10);
      }
      lineContent.append("q" + (char) 13 + (char) 10);
      lineContent.append(lineStyle.getText() + (char) 13 + (char) 10);
      lineContent.append(String.valueOf(coordX) + " " + String.valueOf(coordY) + " m" + (char) 13 + (char) 10);
      lineContent.append(String.valueOf(coordX1) + " " + String.valueOf(coordY1) + " l" + (char) 13 + (char) 10);
      lineContent.append("S" + (char) 13 + (char) 10);
      lineContent.append("Q" + (char) 13 + (char) 10);
      resultLine.append(String.valueOf(objectID) + " 0 obj" + (char) 13 + (char) 10);
      resultLine.append("<<" + (char) 13 + (char) 10);
      resultLine.append("/Length " + String.valueOf(lineContent.length()) + (char) 13 + (char) 10);
      resultLine.append(">>" + (char) 13 + (char) 10);
      resultLine.append("stream" + (char) 13 + (char) 10);
      resultLine.append(lineContent.toString() + (char) 13 + (char) 10);
      resultLine.append("endstream" + (char) 13 + (char) 10);
      resultLine.append("endobj" + (char) 13 + (char) 10);
      lineContent = null;
      return resultLine.toString();
   }

}
