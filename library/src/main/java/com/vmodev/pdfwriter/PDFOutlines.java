package com.vmodev.pdfwriter;

import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;
import com.vmodev.pdfwriter.model.IWritable;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFOutlines implements IWritable{

   private int objectIDOutlines;

   public int getObjectIDOutlines() {
      return objectIDOutlines;
   }

   public void setObjectIDOutlines(int objectIDOutlines) {
      this.objectIDOutlines = objectIDOutlines;
   }

   @Override
   public String getText() throws PDFIncorrectParagraghException {
      StringBuilder strOutlines = new StringBuilder();
      strOutlines.append(String.valueOf(objectIDOutlines) + " 0 obj" + (char)13 + (char)10);
      strOutlines.append("<<" + (char)13 + (char)10);
      strOutlines.append("/Type /Outlines" + (char)13 + (char)10);
      strOutlines.append("/Count 0" + (char)13 + (char)10);
      strOutlines.append(">>" + (char)13 + (char)10);
      strOutlines.append("endobj" + (char)13 + (char)10);
      return strOutlines.toString();
   }

}
