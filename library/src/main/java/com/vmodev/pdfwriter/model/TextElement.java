package com.vmodev.pdfwriter.model;

import com.vmodev.pdfwriter.adapter.TextAdapter;
import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;

/**
 * Created by Kien on 5/25/2015.
 */
public class TextElement extends PDFElement {

   private String content;
   private int fontSize;
   private PredefinedFont fontType;
   private PredefinedTransform transformation;

   /**
    * Class's Constructor
    *
    * @param newContent  Text content
    * @param newFontSize Font size
    * @param newFontType Font type
    * @param newCoordX   Start X position
    * @param newCoordY   Start Y position
    */
   public TextElement(String newContent, int newFontSize, PredefinedFont newFontType, int
      newCoordX, int newCoordY) {
      this(newContent, newFontSize, newFontType, newCoordX, newCoordY, PredefinedColor.Black);
   }

   /**
    * Class's Constructor
    *
    * @param newContent     Text content
    * @param newFontSize    Font size
    * @param newFontType    Font type
    * @param newCoordX      Start X position
    * @param newCoordY      Start Y position
    * @param newStrokeColor Font's color
    */
   public TextElement(String newContent, int newFontSize, PredefinedFont newFontType, int
      newCoordX, int newCoordY, PredefinedColor newStrokeColor) {
      this(newContent, newFontSize, newFontType, newCoordX, newCoordY, newStrokeColor,
         PredefinedTransform.DEGREES_0_ROTATION);
   }

   /**
    * Class's Constructor
    *
    * @param newContent     Text content
    * @param newFontSize    Font size
    * @param newFontType    Font type
    * @param newCoordX      Start X position
    * @param newCoordY      Start Y position
    * @param newStrokeColor Font's color
    */
   public TextElement(String newContent, int newFontSize, PredefinedFont newFontType, int
      newCoordX, int newCoordY, PDFColor newStrokeColor) {
      this(newContent, newFontSize, newFontType, newCoordX, newCoordY, newStrokeColor,
         PredefinedTransform.DEGREES_0_ROTATION);
   }

   /**
    * Class's Constructor
    *
    * @param newContent     Text content
    * @param newFontSize    Font size
    * @param newFontType    Font type
    * @param newCoordX      Start X position
    * @param newCoordY      Start Y position
    * @param newStrokeColor Font's color
    * @param newTransform   Rotate degree
    */
   public TextElement(String newContent, int newFontSize, PredefinedFont newFontType, int newCoordX,
                      int newCoordY, PDFColor newStrokeColor, PredefinedTransform newTransform) {
      content = newContent;
      fontSize = newFontSize;
      fontType = newFontType;
      coordX = newCoordX;
      coordY = newCoordY;
      strokeColor = newStrokeColor;
      transformation = newTransform;

   }

   /**
    * Class's Constructor
    *
    * @param newContent     Text content
    * @param newFontSize    Font size
    * @param newFontType    Font type
    * @param newCoordX      Start X position
    * @param newCoordY      Start Y position
    * @param newStrokeColor Font's color
    * @param newTransform   Rotate degree
    */
   public TextElement(String newContent, int newFontSize, PredefinedFont newFontType, int newCoordX,
                      int newCoordY, PredefinedColor newStrokeColor, PredefinedTransform newTransform) {
      content = newContent;
      fontSize = newFontSize;
      fontType = newFontType;
      coordX = newCoordX;
      coordY = newCoordY;
      strokeColor = new PDFColor(newStrokeColor);
      transformation = newTransform;

   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public int getFontSize() {
      return fontSize;
   }

   public void setFontSize(int fontSize) {
      this.fontSize = fontSize;
   }

   public PredefinedFont getFontType() {
      return fontType;
   }

   public void setFontType(PredefinedFont fontType) {
      this.fontType = fontType;
   }

   @Override
   public String getText() throws PDFIncorrectParagraghException {
      StringBuilder resultText = new StringBuilder();
      StringBuilder hexContent = new StringBuilder();
      resultText.append(String.valueOf(objectID) + " 0 obj" + (char) 13 + (char) 10);
      resultText.append("<<" + (char) 13 + (char) 10);
      resultText.append("/Filter [/ASCIIHexDecode]" + (char) 13 + (char) 10);
      hexContent.append("q" + (char) 13 + (char) 10);
      hexContent.append("BT" + (char) 13 + (char) 10);
      hexContent.append("/F" + String.valueOf(fontType.getValue()) + " " + String.valueOf
         (fontSize) + " Tf" + (char) 13 + (char) 10);
      if (strokeColor.isColor()) {
         hexContent.append(strokeColor.getrColor() + " " + strokeColor.getgColor() + " " +
            strokeColor.getbColor() + " rg" + (char) 13 + (char) 10);
      }
      hexContent.append(transformation.getValue() + " " + String.valueOf(coordX) + " " + String.valueOf
         (coordY) + " Tm" + (char)
         13 + (char) 10);
      hexContent.append("(" + TextAdapter.checkText(content) + ") Tj" + (char) 13 + (char) 10);
      hexContent.append("ET" + (char) 13 + (char) 10);
      hexContent.append("Q");
      resultText.append("/Length " + String.valueOf((hexContent.length() * 2) + 1) + (char) 13 + (char) 10);
      resultText.append(">>" + (char) 13 + (char) 10);
      resultText.append("stream" + (char) 13 + (char) 10);
      resultText.append(TextAdapter.encodeHEX(hexContent.toString()) + ">" + (char) 13 +
         (char)
            10);
      resultText.append("endstream" + (char) 13 + (char) 10);
      resultText.append("endobj" + (char) 13 + (char) 10);
      hexContent = null;
      return resultText.toString();
   }
}
