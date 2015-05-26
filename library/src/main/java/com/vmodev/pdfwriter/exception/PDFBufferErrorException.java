package com.vmodev.pdfwriter.exception;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * Exception that represents an error during the I/O on the buffer.
 */
public class PDFBufferErrorException extends PDFException{
   public PDFBufferErrorException(String message, Exception ex) {
      super(message, ex);
   }
}
