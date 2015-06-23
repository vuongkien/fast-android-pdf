package com.vmodev.pdfwriter.model;

import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;

/**
 * Created by Kien on 5/25/2015.
 */
public interface IWritable {

   /**
    * Method that returns the PDF codes to write the object in the document
    *
    * @return String that contains PDF codes
    */
   String getText() throws PDFIncorrectParagraghException;

}
