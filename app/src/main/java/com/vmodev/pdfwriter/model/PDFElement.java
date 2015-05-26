package com.vmodev.pdfwriter.model;

import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;

/**
 * Created by Kien on 5/25/2015.
 */
public abstract class PDFElement implements IWritable{

   protected PDFColor strokeColor = new PDFColor(PredefinedColor.NoColor);

   protected PDFColor fillColor = new PDFColor(PredefinedColor.NoColor);

   protected int coordX;

   protected int coordY;

   protected int objectID;


   public int getObjectID() {
      return objectID;
   }

   public void setObjectID(int objectID) {
      this.objectID = objectID;
   }

   /**
    * Method that returns the PDF codes to write the generic element in the document. It must be implemented by the derived class
     * @return String that contains PDF codes
    */
   public abstract String getText() throws PDFIncorrectParagraghException;
}
