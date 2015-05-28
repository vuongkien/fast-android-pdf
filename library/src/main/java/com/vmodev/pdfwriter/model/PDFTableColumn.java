package com.vmodev.pdfwriter.model;

import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFTableColumn implements IWritable {

   private String columnValue = "";
   private PredefinedAlignment _columnAlign = PredefinedAlignment.Left;
   private int columnSize;

   public PDFTableColumn() {
   }

   /**
    * Class constructor
    * @param columnValue Column value
    * @param columnAlign Alignment Style
    * @param columnSize Column size
    */
   public PDFTableColumn(String columnValue, PredefinedAlignment columnAlign, int columnSize) {
      this.columnValue = columnValue;
      this._columnAlign = columnAlign;
      this.columnSize = columnSize;
   }

   public String getColumnValue() {
      return columnValue;
   }

   public void setColumnValue(String columnValue) {
      this.columnValue = columnValue;
   }

   public PredefinedAlignment get_columnAlign() {
      return _columnAlign;
   }

   public void set_columnAlign(PredefinedAlignment _columnAlign) {
      this._columnAlign = _columnAlign;
   }

   public int getColumnSize() {
      return columnSize;
   }

   public void setColumnSize(int columnSize) {
      this.columnSize = columnSize;
   }

   @Override
   public String getText() throws PDFIncorrectParagraghException {
      return null;
   }
}
