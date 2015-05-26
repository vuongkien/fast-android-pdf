package com.vmodev.pdfwriter.model;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFFont implements IWritable {

   private PredefinedFont fontStyle;
   private int objectID;
   private int fontNumber;

   public int getObjectID() {
      return objectID;
   }

   public void setObjectID(int objectID) {
      this.objectID = objectID;
   }

   public PDFFont(PredefinedFont newFontStyle, int newFontNumber)
   {
      fontStyle = newFontStyle;
      fontNumber = newFontNumber;
   }

   @Override
   public String getText() {
      StringBuilder content = new StringBuilder();
      content.append(String.valueOf(objectID) + " 0 obj" + (char)13
         + (char)10);
      content.append("<<" + (char)13 + (char)10);
      content.append("/Type /Font" + (char)13 + (char)10);
      content.append("/Subtype /Type1" + (char)13 + (char)10);
      content.append("/Name /F" + String.valueOf(fontNumber) + (char)13
         + (char)10);
      content.append("/BaseFont /" + PDFFont.getFontName(fontStyle) + (char)13 + (char)10);
      content.append("/Encoding /WinAnsiEncoding" + (char)13 +
         (char)10);
      content.append(">>" + (char)13 + (char)10);
      content.append("endobj" + (char)13 + (char)10);
      return content.toString();
   }

   /**
    * Get font name
    * @param fontType Font's type
    * @return
    */
   public static String getFontName(PredefinedFont fontType) {
      switch (fontType) {
         case Helvetica:
            return "Helvetica";
         case HelveticaBold:
            return "Helvetica-Bold";
         case HelveticaOblique:
            return "Helvetica-Oblique";
         case HelveticaBoldOblique:
            return "Helvetica-BoldOblique";
         case Courier:
            return "Courier";
         case CourierBold:
            return "Courier-Bold";
         case CourierOblique:
            return "Courier-Oblique";
         case CourierBoldOblique:
            return "Courier-BoldOblique";
         case Times:
            return "Times-Roman";
         case TimesBold:
            return "Times-Bold";
         case TimesOblique:
            return "Times-Italic";
         case TimesBoldOblique:
            return "Times-BoldItalic";
         default:
            return "";
      }
   }
}
