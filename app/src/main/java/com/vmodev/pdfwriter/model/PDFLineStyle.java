package com.vmodev.pdfwriter.model;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFLineStyle implements IWritable{


   PredefinedLineStyle lineStyle = PredefinedLineStyle.Normal;
   int width = 1;

   public PDFLineStyle(int newWidth)
   {
      width = newWidth;
   }

   public PDFLineStyle(PredefinedLineStyle newStyle)
   {
      lineStyle = newStyle;
   }

   public PDFLineStyle(int newWidth, PredefinedLineStyle newStyle)
   {
      width = newWidth;
      lineStyle = newStyle;
   }

   public PredefinedLineStyle getLineStyle() {
      return lineStyle;
   }

   public void setLineStyle(PredefinedLineStyle lineStyle) {
      this.lineStyle = lineStyle;
   }

   public int getWidth() {
      return width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

   @Override
   public String getText()
   {
      StringBuilder resultText = new StringBuilder();
      resultText.append(String.valueOf(width) + " w" + String.valueOf(Character.toChars(13)[0])
         + String.valueOf(Character.toChars(10)[0]));
      switch (lineStyle)
      {
         case Outlined:
            resultText.append("[4 4] 0 d" + String.valueOf(Character.toChars(13)[0])
               + String.valueOf(Character.toChars(10)[0]));
            break;
         case OutlinedSmall:
            resultText.append("[2 2] 0 d" + String.valueOf(Character.toChars(13)[0])
               + String.valueOf(Character.toChars(10)[0]));
            break;
         case OutlinedBig:
            resultText.append("[6 6] 0 d" + String.valueOf(Character.toChars(13)[0])
               + String.valueOf(Character.toChars(10)[0]));
            break;
      }
      return resultText.toString();
   }

}
