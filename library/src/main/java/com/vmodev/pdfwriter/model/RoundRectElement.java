package com.vmodev.pdfwriter.model;

import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;

/**
 * Created by Kien on 5/25/2015.
 */

public class RoundRectElement extends PDFElement{

   private int width;
   private int height;
   private int radius;
   private PDFLineStyle lineStyle;

   /**
    * Class's Constructor
    * @param X Start X position
    * @param Y Start Y position
    * @param X1 End X position
    * @param Y1 End Y position
    * @param strokeColor Color of stroke
    * @param fillColor Color of fill
    */
   public RoundRectElement(int X, int Y, int X1, int Y1, int radius, PredefinedColor strokeColor,
                           PredefinedColor fillColor)
   {
      this.coordX = X;
      this.coordY = Y;
      width = X1;
      height = Y1;
      this.radius = radius;
      this.strokeColor = new PDFColor(strokeColor);
      this.fillColor = new PDFColor(fillColor);
      this.lineStyle = new PDFLineStyle(1, PredefinedLineStyle.Normal);
   }

   /**
    * Class's Constructor
    * @param X Start X position
    * @param Y Start Y position
    * @param X1 End X position
    * @param Y1 End Y position
    * @param strokeColor Color of stroke
    * @param fillColor Color of fill
    */
   public RoundRectElement(int X, int Y, int X1, int Y1, int radius, PDFColor strokeColor,
                           PDFColor fillColor)
   {
      this.coordX = X;
      this.coordY = Y;
      width = X1;
      height = Y1;
      this.radius = radius;
      this.strokeColor = strokeColor;
      this.fillColor = fillColor;
      this.lineStyle = new PDFLineStyle(1, PredefinedLineStyle.Normal);
   }

   /**
    * Class's Constructor
    * @param X Start X position
    * @param Y Start Y position
    * @param X1 End X position
    * @param Y1 End Y position
    * @param strokeColor Color of stroke
    * @param fillColor Color of fill
    * @param newWidth Border's width
    */
   public RoundRectElement(int X, int Y, int X1, int Y1, int radius, PredefinedColor strokeColor,
                           PredefinedColor fillColor, int newWidth)
   {
      this.coordX = X;
      this.coordY = Y;
      width = X1;
      height = Y1;
      this.radius = radius;
      this.strokeColor = new PDFColor(strokeColor);
      this.fillColor = new PDFColor(fillColor);
      this.lineStyle = new PDFLineStyle(newWidth, PredefinedLineStyle.Normal);
   }

   /**
    * Class's Constructor
    * @param X Start X position
    * @param Y Start Y position
    * @param X1 End X position
    * @param Y1 End Y position
    * @param strokeColor Color of stroke
    * @param fillColor Color of fill
    * @param newWidth Border's width
    */
   public RoundRectElement(int X, int Y, int X1, int Y1, int radius, PDFColor strokeColor,
                           PDFColor fillColor, int newWidth)
   {
      this.coordX = X;
      this.coordY = Y;
      width = X1;
      height = Y1;
      this.radius = radius;
      this.strokeColor = strokeColor;
      this.fillColor = fillColor;
      this.lineStyle = new PDFLineStyle(newWidth, PredefinedLineStyle.Normal);
   }

   /**
    * Class's Constructor
    * @param X Start X position
    * @param Y Start Y position
    * @param X1 End X position
    * @param Y1 End Y position
    * @param strokeColor Color of stroke
    * @param fillColor Color of fill
    * @param newStyle Border's style
    */
   public RoundRectElement(int X, int Y, int X1, int Y1, int radius, PredefinedColor strokeColor,
                           PredefinedColor fillColor, PredefinedLineStyle newStyle)
   {
      this.coordX = X;
      this.coordY = Y;
      width = X1;
      height = Y1;
      this.radius = radius;
      this.strokeColor = new PDFColor(strokeColor);
      this.fillColor = new PDFColor(fillColor);
      this.lineStyle = new PDFLineStyle(1, newStyle);
   }

   /**
    * Class's Constructor
    * @param X Start X position
    * @param Y Start Y position
    * @param X1 End X position
    * @param Y1 End Y position
    * @param strokeColor Color of stroke
    * @param fillColor Color of fill
    * @param newStyle Border's style
    */
   public RoundRectElement(int X, int Y, int X1, int Y1, int radius,PDFColor strokeColor,
                           PDFColor fillColor, PredefinedLineStyle newStyle)
   {
      this.coordX = X;
      this.coordY = Y;
      width = X1;
      height = Y1;
      this.radius = radius;
      this.strokeColor = strokeColor;
      this.fillColor = fillColor;
      this.lineStyle = new PDFLineStyle(1, newStyle);
   }

   /**
    * Class's Constructor
    * @param X Start X position
    * @param Y Start Y position
    * @param X1 End X position
    * @param Y1 End Y position
    * @param strokeColor Color of stroke
    * @param fillColor Color of fill
    * @param newWidth Border's width
    * @param newStyle Border's style
    */
   public RoundRectElement(int X, int Y, int X1, int Y1, int radius,PredefinedColor strokeColor,
                           PredefinedColor fillColor, int newWidth, PredefinedLineStyle newStyle)
   {
      this.coordX = X;
      this.coordY = Y;
      width = X1;
      height = Y1;
      this.radius = radius;
      this.strokeColor = new PDFColor(strokeColor);
      this.fillColor = new PDFColor(fillColor);
      this.lineStyle = new PDFLineStyle(newWidth, newStyle);
   }

   /**
    * Class's Constructor
    * @param X Start X position
    * @param Y Start Y position
    * @param X1 End X position
    * @param Y1 End Y position
    * @param strokeColor Color of stroke
    * @param fillColor Color of fill
    * @param newWidth Border's width
    * @param newStyle Border's style
    */
   public RoundRectElement(int X, int Y, int X1, int Y1,int radius, PDFColor strokeColor,
                           PDFColor fillColor, int newWidth, PredefinedLineStyle newStyle)
   {
      this.coordX = X;
      this.coordY = Y;
      width = X1;
      height = Y1;
      this.radius = radius;
      this.strokeColor = strokeColor;
      this.fillColor = fillColor;
      this.lineStyle = new PDFLineStyle(newWidth, newStyle);
   }

   @Override
   public String getText() throws PDFIncorrectParagraghException {
      StringBuilder resultRect = new StringBuilder();
      StringBuilder rectContent = new StringBuilder();
      float b = 0.4477f;
      rectContent.append("q" + (char)13 + (char)10);
      if (strokeColor.isColor())
      {
         rectContent.append(strokeColor.getrColor() + " " + strokeColor.getgColor() + " "
            + strokeColor.getbColor() + " RG" + (char)13 + (char)10);
      }
      if  (fillColor.isColor())
      {
         rectContent.append(fillColor.getrColor() + " " + fillColor.getgColor() + " " + fillColor
            .getbColor() + " rg"+ (char)13 + (char)10);
      }
      rectContent.append(lineStyle.getText() + (char) 13 + (char) 10);
      /*rectContent.append(String.valueOf(coordX) + " " + String.valueOf(coordY) + " " + String.valueOf(width - coordX)
         + " " + String.valueOf(height - coordY) + " re" + (char)13 + (char)10);*/
      rectContent.append(coordX + radius).append(' ').append(coordY).append(" m"+(char)13 + (char)10);
      rectContent.append(coordX + width - radius).append(' ').append(coordY).append(" l" + (char) 13 + (char) 10);
      rectContent.append(coordX + width - radius * b).append(' ').append(coordY).append(' ').append(coordX+width).append(' ').append(coordY+radius*b).append(' ').append(coordX + width).append(' ').append(coordY+radius).append(" c" + (char) 13 + (char) 10);
      rectContent.append(coordX + width).append(' ').append(coordY+height-radius).append(" l" + (char) 13 + (char) 10);
      rectContent.append(coordX + width).append(' ').append(coordY+height-radius*b).append(' ').append(coordX+width-radius*b).append(' ').append(coordY+height).append(' ').append(coordX + width - radius).append(' ').append(coordY+height).append(" c" + (char) 13 + (char) 10);
      rectContent.append(coordX + radius).append(' ').append(coordY+height).append(" l" + (char) 13 + (char) 10);
      rectContent.append(coordX + radius * b).append(' ').append(coordY+height).append(' ').append(coordX).append(' ').append(coordY+height-radius*b).append(' ').append(coordX).append(' ').append(coordY+height-radius).append(" c" + (char) 13 + (char) 10);
      rectContent.append(coordX).append(' ').append(coordY+radius).append(" l" + (char) 13 + (char) 10);
      rectContent.append(coordX).append(' ').append(coordY+radius*b).append(' ').append(coordX+radius*b).append(' ').append(coordY).append(' ').append(coordX+radius).append(' ').append(coordY).append(" c" + (char) 13 + (char) 10);

      rectContent.append("B" + (char) 13 + (char)10);
      rectContent.append("Q" + (char)13 + (char)10);
      resultRect.append(String.valueOf(objectID) + " 0 obj" + (char)13 +
         (char)10);
      resultRect.append("<<" + (char)13 + (char)10);
      resultRect.append("/Length " + String.valueOf(rectContent.length()) + (char)13 + (char)10);
      resultRect.append(">>" + (char)13 + (char)10);
      resultRect.append("stream" + (char)13 + (char)10);
      resultRect.append(String.valueOf(rectContent) + (char)13 +
         (char)10);
      resultRect.append("endstream" + (char)13 + (char)10);
      resultRect.append("endobj" + (char)13 + (char)10);
      rectContent = null;
      return resultRect.toString();
   }

}
