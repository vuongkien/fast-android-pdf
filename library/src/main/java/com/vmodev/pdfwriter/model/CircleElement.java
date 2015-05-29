package com.vmodev.pdfwriter.model;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * A Class that implements a PDF circle.
 */
public class CircleElement extends PDFElement {

   private int ray;
   private PDFLineStyle lineStyle;

   /**
    * Class's constructor
    * @param X X position in the PDF document
    * @param Y Y position in the PDF document
    * @param Ray Ray of the circle
    * @param strokeColor Color of circle's border
    * @param fillColor Color of the circle
    */
   public CircleElement(int X, int Y, int Ray, PredefinedColor strokeColor,
                        PredefinedColor fillColor) {
      this.coordX = X;
      this.coordY = Y;
      this.ray = Ray;
      this.strokeColor = new PDFColor(strokeColor);
      this.fillColor = new PDFColor(fillColor);
      this.lineStyle = new PDFLineStyle(1, PredefinedLineStyle.Normal);
   }

   /**
    * Class's constructor
    * @param X X position in the PDF document
    * @param Y Y position in the PDF document
    * @param Ray Ray of the circle
    * @param strokeColor Color of circle's border
    * @param fillColor Color of the circle
    */
   public CircleElement(int X, int Y, int Ray, PDFColor strokeColor,
                        PDFColor fillColor) {
      this.coordX = X;
      this.coordY = Y;
      this.ray = Ray;
      this.strokeColor = strokeColor;
      this.fillColor = fillColor;
      this.lineStyle = new PDFLineStyle(1, PredefinedLineStyle.Normal);
   }

   /**
    * Class's constructor
    * @param X X position in the PDF document
    * @param Y Y position in the PDF document
    * @param Ray Ray of the circle
    * @param strokeColor Color of circle's border
    * @param fillColor Color of the circle
    * @param newWidth Border's size
    */
   public CircleElement(int X, int Y, int Ray, PredefinedColor strokeColor,
                        PredefinedColor fillColor, int newWidth) {
      this.coordX = X;
      this.coordY = Y;
      this.ray = Ray;
      this.strokeColor = new PDFColor(strokeColor);
      this.fillColor = new PDFColor(fillColor);
      this.lineStyle = new PDFLineStyle(newWidth, PredefinedLineStyle.Normal);
   }

   /**
    * Class's constructor
    * @param X X position in the PDF document
    * @param Y Y position in the PDF document
    * @param Ray Ray of the circle
    * @param strokeColor Color of circle's border
    * @param fillColor Color of the circle
    * @param newWidth Border's size
    */
   public CircleElement(int X, int Y, int Ray, PDFColor strokeColor,
                        PDFColor fillColor, int newWidth) {
      this.coordX = X;
      this.coordY = Y;
      this.ray = Ray;
      this.strokeColor = strokeColor;
      this.fillColor = fillColor;
      this.lineStyle = new PDFLineStyle(newWidth, PredefinedLineStyle.Normal);
   }

   /**
    * Class's constructor
    * @param X X position in the PDF document
    * @param Y Y position in the PDF document
    * @param Ray Ray of the circle
    * @param strokeColor Color of circle's border
    * @param fillColor Color of the circle
    * @param newStyle Border's style
    */
   public CircleElement(int X, int Y, int Ray, PredefinedColor strokeColor,
                        PredefinedColor fillColor, PredefinedLineStyle newStyle) {
      this.coordX = X;
      this.coordY = Y;
      this.ray = Ray;
      this.strokeColor = new PDFColor(strokeColor);
      this.fillColor = new PDFColor(fillColor);
      this.lineStyle = new PDFLineStyle(1, newStyle);
   }

   /**
    * Class's constructor
    * @param X X position in the PDF document
    * @param Y Y position in the PDF document
    * @param Ray Ray of the circle
    * @param strokeColor Color of circle's border
    * @param fillColor Color of the circle
    * @param newStyle Border's style
    */
   public CircleElement(int X, int Y, int Ray, PDFColor strokeColor,
                        PDFColor fillColor, PredefinedLineStyle newStyle) {
      this.coordX = X;
      this.coordY = Y;
      this.ray = Ray;
      this.strokeColor = strokeColor;
      this.fillColor = fillColor;
      this.lineStyle = new PDFLineStyle(1, newStyle);
   }

   /**
    *
    * Class's constructor
    * @param X X position in the PDF document
    * @param Y Y position in the PDF document
    * @param Ray Ray of the circle
    * @param strokeColor Color of circle's border
    * @param fillColor Color of the circle
    * @param newWidth Border's size
    * @param newStyle Border's style
    */
   public CircleElement(int X, int Y, int Ray, PredefinedColor strokeColor, PredefinedColor
      fillColor, int newWidth, PredefinedLineStyle newStyle) {
      this.coordX = X;
      this.coordY = Y;
      this.ray = Ray;
      this.strokeColor = new PDFColor(strokeColor);
      this.fillColor = new PDFColor(fillColor);
      this.lineStyle = new PDFLineStyle(newWidth, newStyle);
   }

   /**
    *
    * Class's constructor
    * @param X X position in the PDF document
    * @param Y Y position in the PDF document
    * @param Ray Ray of the circle
    * @param strokeColor Color of circle's border
    * @param fillColor Color of the circle
    * @param newWidth Border's size
    * @param newStyle Border's style
    */
   public CircleElement(int X, int Y, int Ray, PDFColor strokeColor, PDFColor fillColor, int
      newWidth, PredefinedLineStyle newStyle) {
      this.coordX = X;
      this.coordY = Y;
      this.ray = Ray;
      this.strokeColor = strokeColor;
      this.fillColor = fillColor;
      this.lineStyle = new PDFLineStyle(newWidth, newStyle);
   }

   @Override
   public String getText() {
      StringBuilder resultCircle = new StringBuilder();
      StringBuilder circleContent = new StringBuilder();
      circleContent.append("q" + (char)13 + (char)10);
      if (strokeColor.isColor()) {
         circleContent.append(strokeColor.getrColor() + " " + strokeColor.getgColor() + " "
            + strokeColor.getbColor() + " RG" + (char)13 + (char)10);
      }
      if (fillColor.isColor()) {
         circleContent.append(fillColor.getrColor() + " " + fillColor.getgColor() + " "
            + fillColor.getbColor() + " rg" + (char)13 + (char)10);
      }
      circleContent.append(lineStyle.getText() + (char)13 + (char)10);
      circleContent.append(String.valueOf(coordX - ray) + " " + String.valueOf(coordY) + " " + "m" +
         (char)13 + (char)10);
      circleContent.append(String.valueOf(coordX - ray) + " " + getYBezier(coordY, ray, '+') + " "
         + String.valueOf(coordX + ray) + " " + getYBezier(coordY, ray, '+') + " " + String.valueOf(coordX + ray)
         + " " + String.valueOf(coordY) + " c" + (char)13 + (char)10);
      circleContent.append(String.valueOf(coordX - ray) + " " + String.valueOf(coordY) + " m"
         + (char)13 + (char)10);
      circleContent.append(String.valueOf(coordX - ray) + " " + getYBezier(coordY, ray, '-')
         + " " + String.valueOf(coordX + ray) + " " + getYBezier(coordY, ray, '-') + " "
         + String.valueOf(coordX + ray) + " " + String.valueOf(coordY) + " c" + (char)13
         + (char)10);
      circleContent.append("B" + (char)13 + (char)10);
      circleContent.append("Q" + (char)13 + (char)10);
      resultCircle.append(String.valueOf(objectID) + " 0 obj" + (char)13 + (char)10);
      resultCircle.append("<<" + (char)13 + (char)10);
      resultCircle.append("/Length " + String.valueOf(circleContent.length()) + (char)13 + (char)10);
      resultCircle.append(">>" + (char)13 + (char)10);
      resultCircle.append("stream" + (char)13 + (char)10);
      resultCircle.append(circleContent.toString() + (char)13 + (char)10);
      resultCircle.append("endstream" + (char)13 + (char)10);
      resultCircle.append("endobj" + (char)13 + (char)10);
      circleContent = null;
      return resultCircle.toString();
   }

   /**
    * Private method that returns the Y position with the Bezier's function
    * @param coordY Y position of the circle's center
    * @param ray Circle's ray
    * @param operation Type of operation : '+' or '-'
    * @return String that contains Y position
    */
   private String getYBezier(int coordY, int ray, char operation) {
      double result = 0;
      switch (operation) {
         case '+':
            result = (double) coordY + (double) ray * 1.414;
            break;
         case '-':
            result = (double) coordY - (double) ray * 1.414;
            break;
      }
      return String.valueOf((int) result);
   }

}
