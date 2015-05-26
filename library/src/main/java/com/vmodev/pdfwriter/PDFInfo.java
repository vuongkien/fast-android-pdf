package com.vmodev.pdfwriter;

import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;
import com.vmodev.pdfwriter.model.IWritable;

import java.util.Calendar;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * A Class that implements a PDF info.
 */
public class PDFInfo implements IWritable{

   private int objectIDInfo;
   private String title;
   private String author;

   public PDFInfo(String title, String author)
   {
      this.title = title;
      this.author = author;
   }

   public int getObjectIDInfo() {
      return objectIDInfo;
   }

   public void setObjectIDInfo(int objectIDInfo) {
      this.objectIDInfo = objectIDInfo;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   @Override
   public String getText() throws PDFIncorrectParagraghException {
      StringBuilder strInfo = new StringBuilder();
      strInfo.append(String.valueOf(objectIDInfo) + " 0 obj" + (char)13 + (char)10);
      strInfo.append("<<" + (char)13 + (char)10);
      strInfo.append("/Title (" + title + ")" + (char)13 + (char)10);
      strInfo.append("/Author (" + author + ")" + (char)13 + (char)10);
      strInfo.append("/Creator (sharpPDF)" + (char)13 + (char)10);
      strInfo.append("/CreationDate (" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) +
         String.valueOf(Calendar.getInstance().get(Calendar.MONTH)) + String.valueOf(Calendar
         .getInstance().get(Calendar.DATE)) + ")" + (char)13 +
         (char)10);
      strInfo.append(">>" + (char)13 + (char)10);
      strInfo.append("endobj" + (char)13 + (char)10);
      return strInfo.toString();
   }
}
