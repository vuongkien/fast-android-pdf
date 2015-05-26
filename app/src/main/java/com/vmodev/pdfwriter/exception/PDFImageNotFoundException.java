package com.vmodev.pdfwriter.exception;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * Exception that represents an nonexistent image
 */
public class PDFImageNotFoundException extends PDFException{

   public PDFImageNotFoundException(String message, Exception ex) {
      super(message, ex);
   }

}
