package com.vmodev.pdfwriter.model;

import com.vmodev.pdfwriter.exception.PDFIncorrectColumnException;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFTableHeader extends PDFTableRow {

   public PDFTableHeader() {
   }

   /**
    * Add new coumt to TableHeader
    * @param newColumn new column
    * @throws PDFIncorrectColumnException
    */
   public void addColumn(PDFTableColumn newColumn) throws PDFIncorrectColumnException {
      if (newColumn instanceof PDFTableColumn) {
         cols.add(newColumn);
      } else {
         throw new PDFIncorrectColumnException();
      }
   }

}
