package com.vmodev.pdfwriter.model;

import com.vmodev.pdfwriter.exception.PDFIncorrectRowException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFTable implements Iterable {

   private PDFTableHeader tableHeader;
   private PDFTableRowStyle tableHeaderStyle;
   private PDFTableRowStyle rowStyle;
   private PDFTableRowStyle alternateRowStyle;
   private ArrayList rows = new ArrayList();
   private int borderSize;
   private PDFColor borderColor;
   private int cellpadding;

   public PDFTable()
   {
      tableHeader = new PDFTableHeader();
      tableHeaderStyle = new PDFTableRowStyle(PredefinedFont.Helvetica, 10, PredefinedColor.Black, PredefinedColor.White);
      rowStyle = new  PDFTableRowStyle(PredefinedFont.Helvetica, 10, PredefinedColor.Black,
         PredefinedColor.White);
      alternateRowStyle = null;
      borderSize = 1;
      borderColor = new PDFColor(PredefinedColor.Black);
      cellpadding = 5;
   }

   /**
    * Get row by index
    * @param index index of row
    * @return TableRow
    */
   public PDFTableRow getTableRow(int index){
      return (PDFTableRow)rows.get(index);
   }

   /**
    *
    * @return row size
    */
   public int rowCount(){
      return rows.size();
   }


   /**
    * create new row
    * @return new row
    */
   public PDFTableRow createRow()
   {
      return new PDFTableRow(tableHeader);
   }

   /**
    * Add new row to table
    * @param newRow new row
    * @throws PDFIncorrectRowException
    */
   public void addRow(PDFTableRow newRow) throws PDFIncorrectRowException {
      if (newRow instanceof PDFTableRow) {
         rows.add(newRow);
      } else {
         throw new PDFIncorrectRowException();
      }

   }

   public PDFTableHeader getTableHeader() {
      return tableHeader;
   }

   public void setTableHeader(PDFTableHeader tableHeader) {
      this.tableHeader = tableHeader;
   }

   public PDFTableRowStyle getTableHeaderStyle() {
      return tableHeaderStyle;
   }

   public void setTableHeaderStyle(PDFTableRowStyle tableHeaderStyle) {
      this.tableHeaderStyle = tableHeaderStyle;
   }

   public PDFTableRowStyle getRowStyle() {
      return rowStyle;
   }

   public void setRowStyle(PDFTableRowStyle rowStyle) {
      this.rowStyle = rowStyle;
   }

   public PDFTableRowStyle getAlternateRowStyle() {
      return alternateRowStyle;
   }

   public void setAlternateRowStyle(PDFTableRowStyle alternateRowStyle) {
      this.alternateRowStyle = alternateRowStyle;
   }

   public ArrayList getRows() {
      return rows;
   }

   public void setRows(ArrayList rows) {
      this.rows = rows;
   }

   public int getBorderSize() {
      return borderSize;
   }

   public void setBorderSize(int borderSize) {
      this.borderSize = borderSize;
   }

   public PredefinedColor getBorderColor() {
      return borderColor.getColor();
   }

   public void setBorderColor(PDFColor borderColor) {
      this.borderColor = borderColor;
   }

   public int getCellpadding() {
      return cellpadding;
   }

   public void setCellpadding(int cellpadding) {
      this.cellpadding = cellpadding;
   }

   @Override
   public Iterator iterator() {
      return rows.iterator();
   }
}
