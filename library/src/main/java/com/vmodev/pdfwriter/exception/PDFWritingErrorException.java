package com.vmodev.pdfwriter.exception;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * Exception that represents an error during the writing of the PDF document.
 */
public class PDFWritingErrorException extends PDFException {
   public PDFWritingErrorException(String message, Exception ex) {
      super(message, ex);
   }
}
