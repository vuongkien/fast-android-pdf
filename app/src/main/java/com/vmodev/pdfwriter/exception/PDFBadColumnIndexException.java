package com.vmodev.pdfwriter.exception;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * Exception that represents an error during an access on the pdfTableRow's columns with a bad index
 */
public class PDFBadColumnIndexException extends PDFException{

   public PDFBadColumnIndexException() {
      super("The columnd index does not exist", null);
   }

}
