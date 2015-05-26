package com.vmodev.pdfwriter.model;

import com.vmodev.pdfwriter.adapter.TextAdapter;
import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;

/**
 * Created by Kien on 5/25/2015.
 */
public class ParagraphElement extends PDFElement{

   private Iterable content;
   private int fontSize;
   private PredefinedFont fontType;

   public ParagraphElement(Iterable newContent, int newFontSize, PredefinedFont newFontType,
                           int newCoordX, int newCoordY)
   {
      this.content = newContent;
      this.fontSize = newFontSize;
      this.fontType = newFontType;
      this.coordX = newCoordX;
      this.coordY = newCoordY;
   }

   public ParagraphElement(Iterable newContent, int newFontSize, PredefinedFont newFontType, int
      newCoordX, int newCoordY, PredefinedColor newStrokeColor)
   {
      this.content = newContent;
      this.fontSize = newFontSize;
      this.fontType = newFontType;
      this.coordX = newCoordX;
      this.coordY = newCoordY;
      this.strokeColor = new PDFColor(newStrokeColor);
   }

   public Iterable getContent() {
      return content;
   }

   public void setContent(Iterable content) {
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
      resultText.append(String.valueOf(objectID) + " 0 obj" + (char)13 + (char)10);
      resultText.append("<<" + (char)13 + (char)10);
      resultText.append("/Filter [/ASCIIHexDecode]" + (char)13 + (char)10);
      hexContent.append("q" + (char)13 + (char)10);
      hexContent.append("BT" + (char)13 + (char)10);
      hexContent.append("/F" + Integer.toString(fontType.getValue()) + " " + String.valueOf(fontSize)
         + " Tf" +(char)13 + (char)10);
      if(strokeColor.isColor())
         hexContent.append(strokeColor.getrColor() + " " + strokeColor.getgColor() + " " + strokeColor.getbColor() +
            " rg" + (char)13 + (char)10);
      hexContent.append(String.valueOf(coordX) + " " + String.valueOf(coordY) + " Td"
         + (char)13 + (char)10);
      hexContent.append("14 TL" + (char)13 + (char)10);
      for (Object line : content) {
         if (line instanceof ParagraphLine) {
            hexContent.append(((ParagraphLine) line).getText());
         } else {
            throw new PDFIncorrectParagraghException();
         }
      }
      hexContent.append("ET" + (char)13 + (char)10);
      hexContent.append("Q" + (char)13 + (char)10);
      resultText.append("/Length " + String.valueOf((hexContent.length() * 2) + 1) + (char)13 + (char)10);
      resultText.append(">>" + (char)13 + (char)10);
      resultText.append("stream" + (char)13 + (char)10);
      resultText.append(TextAdapter.encodeHEX(hexContent.toString()) + ">" + (char)13 + (char)10);
      resultText.append("endstream" + (char)13 + (char)10);
      resultText.append("endobj" + (char)13 + (char)10);
      hexContent = null;
      return resultText.toString();
   }

}
