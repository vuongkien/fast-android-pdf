package com.vmodev.pdfwriter.model;

import com.vmodev.pdfwriter.adapter.TextAdapter;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * A Class that implements a PDF paragraph's line.
 */
public class ParagraphLine implements IWritable{

   private String strLine;
   private int lineLeftMargin;
   private int lineTopMargin;

   /**
    *Class's Constructor
    * @param strLine Text of the line
    * @param lineTopMargin Top margin
    * @param lineLeftMargin Left margin
    */
   public ParagraphLine(String strLine, int lineTopMargin, int lineLeftMargin)
   {
      this.strLine = strLine;
      this.lineTopMargin = lineTopMargin;
      this.lineLeftMargin = lineLeftMargin;
   }

   @Override
   public String getText() {
      StringBuilder resultString = new StringBuilder();
      resultString.append(String.valueOf(lineLeftMargin) + " -" + String.valueOf(lineTopMargin) + " Td"
         + (char)13 + (char)10);
      resultString.append("(" + TextAdapter.checkText(strLine) + ") Tj" + (char)13 + (char)10);
      resultString.append("-" + Integer.toString(lineLeftMargin).replace(",", ".") + " 0 Td"
         + (char)13 + (char)10);
      return resultString.toString();
   }

}
