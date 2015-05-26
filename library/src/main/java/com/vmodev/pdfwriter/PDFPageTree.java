package com.vmodev.pdfwriter;

import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;
import com.vmodev.pdfwriter.model.IWritable;

import java.util.ArrayList;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * A Class that implements a PDF pageTree.
 */
public class PDFPageTree implements IWritable{

   private ArrayList pages;
   private int pageCount;
   private int objectID;

   public PDFPageTree()
   {
      pageCount = 0;
      pages = new ArrayList();
   }

   public void addPage(int pageID)
   {
      pages.add(pageID);
      pageCount++;
   }

   public ArrayList getPages() {
      return pages;
   }

   public void setPages(ArrayList pages) {
      this.pages = pages;
   }

   public int getPageCount() {
      return pageCount;
   }

   public void setPageCount(int pageCount) {
      this.pageCount = pageCount;
   }

   public int getObjectID() {
      return objectID;
   }

   public void setObjectID(int objectID) {
      this.objectID = objectID;
   }

   @Override
   public String getText() throws PDFIncorrectParagraghException {
      if (pages.size() > 0)
      {
         StringBuilder content = new StringBuilder();
         content.append(String.valueOf(objectID) + " 0 obj" + (char)13 + (char)10);
         content.append("<<" + (char)13 + (char)10);
         content.append("/Type /Pages" + (char)13 + (char)10);
         content.append("/Count " + String.valueOf(pages.size()) + (char)13
            + (char)10);
         content.append("/Kids [");
         for(Object item : pages)
         {
            content.append(String.valueOf((int)item) + " 0 R ");
         }
         content.append("]" + (char)13 + (char)10);
         content.append(">>" + (char)13 + (char)10);
         content.append("endobj" + (char)13 + (char)10);
         return content.toString();
      } else {
         return null;
      }
   }
}
