package com.vmodev.pdfwriter.exception;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 *  Exception that represents an error during the creation of a paragraph, when the paragraph's
 *  element is of the wrong type(different form paragraphLine object)
 */
public class PDFIncorrectParagraghException extends PDFException{

   public PDFIncorrectParagraghException() {
      super("The object isn't of the right type. It MUST be a paragraphLine object!", null);
   }

}
