package com.vmodev.pdfwriter.model;

/**
 * Created by Kien on 5/29/2015.
 */
public enum  PredefinedTransform {
   DEGREES_0_ROTATION("1 0 0 1"),
   DEGREES_45_ROTATION("1 -1 1 1"),
   DEGREES_90_ROTATION ("0 -1 1 0"),
   DEGREES_135_ROTATION("-1 -1 1 -1"),
   DEGREES_180_ROTATION("-1 0 0 -1"),
   DEGRESS_225_ROTATION("-1 1 -1 -1"),
   DEGREES_270_ROTATION("0 1 -1 0"),
   DEGREES_315_ROTATION("1 1 -1 1");

   PredefinedTransform(String value){
      this.value = value;
   }

   private final String value;

   public String getValue() {
      return value;
   }
}
