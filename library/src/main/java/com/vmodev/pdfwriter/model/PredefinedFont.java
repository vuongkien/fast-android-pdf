package com.vmodev.pdfwriter.model;

/**
 * Created by Kien on 5/25/2015.
 */
public enum PredefinedFont {

   Helvetica(1),

   HelveticaBold(2),

   HelveticaOblique(3),

   HelveticaBoldOblique(4),

   Courier(5),

   CourierBold(6),

   CourierOblique(7),

   CourierBoldOblique(8),

   Times(9),

   TimesBold(10),

   TimesOblique(11),

   TimesBoldOblique(12);

   PredefinedFont(int newValue) {
      value = newValue;
   }

   private final int value;

   public int getValue() {
      return value;
   }
}
