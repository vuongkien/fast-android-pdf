package com.vmodev.pdfwriter;

import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;
import com.vmodev.pdfwriter.model.IWritable;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * A Class that implements a PDF header.
 */
public class PDFHeader implements IWritable{

   private int objectIDHeader;
   private int objectIDInfo;
   private int objectIDOutlines;
   private int pageTreeID;

   public int getObjectIDHeader() {
      return objectIDHeader;
   }

   public void setObjectIDHeader(int objectIDHeader) {
      this.objectIDHeader = objectIDHeader;
   }

   public int getObjectIDInfo() {
      return objectIDInfo;
   }

   public void setObjectIDInfo(int objectIDInfo) {
      this.objectIDInfo = objectIDInfo;
   }

   public int getObjectIDOutlines() {
      return objectIDOutlines;
   }

   public void setObjectIDOutlines(int objectIDOutlines) {
      this.objectIDOutlines = objectIDOutlines;
   }

   public int getPageTreeID() {
      return pageTreeID;
   }

   public void setPageTreeID(int pageTreeID) {
      this.pageTreeID = pageTreeID;
   }

   @Override
   public String getText() throws PDFIncorrectParagraghException {
      StringBuilder strHeader = new StringBuilder();
      strHeader.append(String.valueOf(objectIDHeader) + " 0 obj" + (char)13 +(char)10);
      strHeader.append("<<" + (char)13 + (char)10);
      strHeader.append("/Type /Catalog" + (char)13 + (char)10);
      strHeader.append("/Version /1.4" + (char)13 + (char)10);
      strHeader.append("/Pages " + String.valueOf(pageTreeID) + " 0 R" + (char)13 + (char)10);
      strHeader.append("/Outlines "+ String.valueOf(objectIDOutlines) +" 0 R" + (char)13 + (char)10);
      strHeader.append(">>" + (char)13 + (char)10);
      strHeader.append("endobj" + (char)13 + (char)10);
      return strHeader.toString();
   }
}
