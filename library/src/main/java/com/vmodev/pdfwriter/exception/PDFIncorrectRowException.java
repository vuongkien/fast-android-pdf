package com.vmodev.pdfwriter.exception;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * Exception that represents the insert of a non-pdfTableRow into a rows collection
 */
public class PDFIncorrectRowException extends PDFException{

   public PDFIncorrectRowException() {
      super("The object isn't of the right type. It MUST be a PDFTableRow object!", null);
   }

}
