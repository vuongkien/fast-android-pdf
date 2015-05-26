package com.vmodev.pdfwriter.model;

import com.vmodev.pdfwriter.exception.PDFBadColumnIndexException;
import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFTableRow implements IWritable, Iterable {

   protected ArrayList<PDFTableColumn> cols = new ArrayList();

   public PDFTableRow() {
   }

   /**
    * Class's Constructor
    * @param tableHeader table Header
    */
   public PDFTableRow(PDFTableHeader tableHeader) {
      for (Object myCol : tableHeader) {
         cols.add(new PDFTableColumn("", ((PDFTableColumn)myCol).get_columnAlign(),
            ((PDFTableColumn)myCol).getColumnSize()));
      }
   }

   /**
    * Get table column by index
    * @param index Index of column
    * @return PDFTableColumn
    * @throws PDFBadColumnIndexException
    */
   public PDFTableColumn getColumn(int index) throws PDFBadColumnIndexException {
      if (index < 0 || index >= cols.size()) {
         throw new PDFBadColumnIndexException();
      } else {
         return (PDFTableColumn) cols.get(index);
      }
   }

   /**
    * Set column by index
    * @param index index of column
    * @param value Table column
    * @throws PDFBadColumnIndexException
    */
   public void setColumn(int index, PDFTableColumn value) throws PDFBadColumnIndexException {
      if (index < 0 || index >= cols.size()) {
         throw new PDFBadColumnIndexException();
      } else {
         cols.add(index, value);
      }
   }

   /**
    * Method get number of column
    * @return number of column
    */
   public int getColumnsCount() {
      return cols.size();
   }


   @Override
   public String getText() throws PDFIncorrectParagraghException {
      return null;
   }


   @Override
   public Iterator iterator() {
      return cols.iterator();
   }

}
