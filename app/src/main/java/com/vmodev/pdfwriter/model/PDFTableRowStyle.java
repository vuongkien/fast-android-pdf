package com.vmodev.pdfwriter.model;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFTableRowStyle {

   private PredefinedFont fontType;
   private int fontSize;
   private PDFColor fontColor;
   private PDFColor bgColor;

   /**
    * Class's Constructor
    * @param fontType Font  type
    * @param fontSize Font size
    * @param fontColor Font color
    * @param bgColor Background color
    */
   public PDFTableRowStyle(PredefinedFont fontType, int fontSize, PredefinedColor fontColor,
                           PredefinedColor bgColor)
   {
      this.fontType = fontType;
      this.fontSize = fontSize;
      this.fontColor = new PDFColor(fontColor);
      this.bgColor = new PDFColor(bgColor);
   }

   public PredefinedFont getFontType() {
      return fontType;
   }

   public void setFontType(PredefinedFont fontType) {
      this.fontType = fontType;
   }

   public int getFontSize() {
      return fontSize;
   }

   public void setFontSize(int fontSize) {
      this.fontSize = fontSize;
   }

   public PredefinedColor getFontColor() {
      return fontColor.getColor();
   }

   public void setFontColor(PDFColor fontColor) {
      this.fontColor = fontColor;
   }

   public PredefinedColor getBgColor() {
      return bgColor.getColor();
   }

   public void setBgColor(PDFColor bgColor) {
      this.bgColor = bgColor;
   }
}
