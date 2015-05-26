package com.vmodev.pdfwriter.exception;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * Generic PDF Exception.
 */
public class PDFException extends Exception{

   public PDFException(String message, Exception ex)
   {
      super(message,ex);
   }

}
