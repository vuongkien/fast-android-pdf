package com.vmodev.pdfwriter.exception;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFIncorrectColumnException extends PDFException {

   public PDFIncorrectColumnException() {
      super("The object isn't of the right type. It MUST be a PDFTableColumn object!", null);
   }


}
