package com.vmodev.pdfwriter;

import com.vmodev.pdfwriter.exception.PDFBufferErrorException;
import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;
import com.vmodev.pdfwriter.exception.PDFWritingErrorException;
import com.vmodev.pdfwriter.model.ImageElement;
import com.vmodev.pdfwriter.model.PDFElement;
import com.vmodev.pdfwriter.model.PDFFont;
import com.vmodev.pdfwriter.model.PredefinedFont;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * A Class that implements a PDF document.
 */
public class PDFDocument {

   private String title;
   private String author;
   private PDFHeader header;
   private PDFInfo info;
   private PDFOutlines outlines;
   private PDFPageTree pageTree;
   private PDFTrailer trailer;
   private ArrayList fonts = new ArrayList();
   private ArrayList pages = new ArrayList();

   public PDFPage getPage(int index) {
      return (PDFPage) pages.get(index);
   }

   /**
    * Class's Constructor
    * @param title Title of the document
    * @param author Author of the document
    */
   public PDFDocument(String title, String author) {
      this.title = title;
      this.author = author;
   }

   /**
    * Method that writes the PDF document on the stream
    * @param outStream Output stream
    * @throws PDFWritingErrorException
    * @throws PDFIncorrectParagraghException
    */
   public void createPDF(OutputStream outStream) throws PDFWritingErrorException, PDFIncorrectParagraghException {
      BufferedOutputStream myBuffer;
      long bufferLength = 0;
      initializeObjects();
      try {
         //Bufferedstream's initialization
         myBuffer = new BufferedOutputStream(outStream);

         //PDF's definition
         bufferLength += writeToBuffer(myBuffer, "%PDF-1.4" + (char)13 + (char)10);

         //PDF's header object
         trailer.addObject(String.valueOf(bufferLength));
         bufferLength += writeToBuffer(myBuffer, header.getText());

         //PDF's info object
         trailer.addObject(String.valueOf(bufferLength));
         bufferLength += writeToBuffer(myBuffer, info.getText());

         //PDF's outlines object
         trailer.addObject(String.valueOf(bufferLength));
         bufferLength += writeToBuffer(myBuffer, outlines.getText());

         //Fonts's initialization
         for (Object font : fonts) {
            trailer.addObject(String.valueOf(bufferLength));
            bufferLength += writeToBuffer(myBuffer, ((PDFFont) font).getText());
         }
         //PDF's pagetree object
         trailer.addObject(String.valueOf(bufferLength));
         bufferLength += writeToBuffer(myBuffer, pageTree.getText());

         //Generation of PDF's pages
         for (Object page : pages) {
            trailer.addObject(String.valueOf(bufferLength));
            bufferLength += writeToBuffer(myBuffer, ((PDFPage) page).getText());
            for (Object element : ((PDFPage) page).getElements()) {
               if (element.getClass().getName().contains("ImageElement")) {
                  trailer.addObject(String.valueOf(bufferLength));
                  bufferLength += writeToBuffer(myBuffer, ((PDFElement) element).getText());
                  trailer.addObject(String.valueOf(bufferLength));
                  bufferLength += writeToBuffer(myBuffer, ((ImageElement) element).getXObjectText());
                  bufferLength += writeToBuffer(myBuffer, "stream" + (char)13 + (char)10);
                  bufferLength += writeToBuffer(myBuffer, ((ImageElement) element).getContent());
                  bufferLength += writeToBuffer(myBuffer, String.valueOf((char)13));
                  bufferLength += writeToBuffer(myBuffer, String.valueOf((char)10));
                  bufferLength += writeToBuffer(myBuffer, "endstream" + (char)13 + (char)10);
                  bufferLength += writeToBuffer(myBuffer, "endobj" + (char)13 + (char)10);
               } else {
                  trailer.addObject(String.valueOf(bufferLength));
                  bufferLength += writeToBuffer(myBuffer, ((PDFElement) element).getText());
               }
            }
         }
         //PDF's trailer object
         trailer.setXrefOffset(bufferLength);
         bufferLength += writeToBuffer(myBuffer, trailer.getText());
         //Buffer's flush
         myBuffer.flush();
         //Free
         myBuffer.close();
         myBuffer = null;
      } catch (IOException ex) {
         throw new PDFWritingErrorException("Error when writing PDF", ex);
      } catch (PDFBufferErrorException e) {
         e.printStackTrace();
      }
   }

   /**
    * Method that writes the PDF document on a file
    * @param outputFile String that represents the name of the output file
    * @throws PDFWritingErrorException
    */
   public void createPDF(String outputFile) throws PDFWritingErrorException {
      FileOutputStream myFileOut;
      File file = new File(outputFile);
      if(file.exists()){
         file.delete();
      }
      try {
         myFileOut = new FileOutputStream(outputFile);
         createPDF(myFileOut);
         myFileOut.close();
      } catch (IOException exIO) {
         throw new PDFWritingErrorException("Cannot write content to file", exIO);
      } catch (PDFWritingErrorException exPDF) {
         throw new PDFWritingErrorException("Cannot write PDF", exPDF);
      } catch (PDFIncorrectParagraghException e) {
         e.printStackTrace();
      }

   }

   /**
    * Private method for the initialization of all PDF objects
    */
   private void initializeObjects() {
      int counterID = 0;
      //header
      header = new PDFHeader();
      header.setObjectIDHeader(1);
      header.setObjectIDInfo(2);
      header.setObjectIDOutlines(3);
      //Info
      info = new PDFInfo(title, author);
      info.setObjectIDInfo(2);
      //Outlines
      outlines = new PDFOutlines();
      outlines.setObjectIDOutlines(3);
      counterID = 4;
      //fonst
      for (int i = 0; i < 12; i++) {
         fonts.add(new PDFFont(PredefinedFont.values()[i], i + 1));
         ((PDFFont) fonts.get(i)).setObjectID(counterID);
         counterID++;
      }
      //pagetree
      pageTree = new PDFPageTree();
      pageTree.setObjectID(counterID);
      header.setPageTreeID(counterID);
      counterID++;
      //pages
      for (Object page : pages) {
         ((PDFPage)page).setObjectID(counterID);
         ((PDFPage)page).setPageTreeID(pageTree.getObjectID());
         ((PDFPage)page).addFonts(fonts);
         pageTree.addPage(counterID);
         counterID++;
         //page's elements
         for (Object element : ((PDFPage)page).getElements()) {
            ((PDFElement)element).setObjectID(counterID);
            counterID++;
            //Imageobject
            if (element.getClass().getName().contains("ImageElement"))
            {
               ((ImageElement) element).setxObjectID(counterID);
               counterID++;
            }
         }
      }
      //trailer
      trailer = new PDFTrailer(counterID - 1);
   }

   /**
    * Method that creates a new page
    * @return New PDF's page
    */
   public PDFPage addPage() {
      pages.add(new PDFPage());
      return (PDFPage) pages.get(pages.size() - 1);
   }

   /**
    * Method that creates a new page
    * @param height height of new page
    * @param width width of new page
    * @return New PDF's page
    */
   public PDFPage addPage(int height, int width) {
      pages.add(new PDFPage(height, width));
      return (PDFPage) pages.get(pages.size() - 1);
   }

   /**
    * Method that writes into the buffer a string
    * @param myBuffer Output Buffer
    * @param stringContent String that contains the informations
    * @return The number of the bytes written in the Buffer
    * @throws PDFBufferErrorException
    */
   private long writeToBuffer(BufferedOutputStream myBuffer, String stringContent) throws PDFBufferErrorException {
      // ASCIIEncoding myEncoder = new ASCIIEncoding();
      byte[] arrTemp;
      try {
         arrTemp = stringContent.getBytes("US-ASCII");
         myBuffer.write(arrTemp, 0, arrTemp.length);
         return arrTemp.length;
      } catch (IOException ex) {
         throw new PDFBufferErrorException("Buffer Error", ex);
      }
   }

   /**
    * Method that writes into the buffer a string
    * @param myBuffer Output Buffer
    * @param byteContent A Byte array that contains the informations
    * @return The number of the bytes written in the Buffer
    * @throws PDFBufferErrorException
    */
   private long writeToBuffer(BufferedOutputStream myBuffer, byte[] byteContent) throws PDFBufferErrorException {
      try {
         myBuffer.write(byteContent, 0, byteContent.length);
         return byteContent.length;
      } catch (IOException ex) {
         throw new PDFBufferErrorException("Buffer Error", ex);
      }
   }

}
