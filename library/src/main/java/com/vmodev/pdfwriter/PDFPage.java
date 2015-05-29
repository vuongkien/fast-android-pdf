package com.vmodev.pdfwriter;

import android.graphics.Bitmap;

import com.vmodev.pdfwriter.adapter.TextAdapter;
import com.vmodev.pdfwriter.exception.PDFBadColumnIndexException;
import com.vmodev.pdfwriter.exception.PDFImageIOException;
import com.vmodev.pdfwriter.exception.PDFImageNotFoundException;
import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;
import com.vmodev.pdfwriter.model.CircleElement;
import com.vmodev.pdfwriter.model.IWritable;
import com.vmodev.pdfwriter.model.ImageElement;
import com.vmodev.pdfwriter.model.LineElement;
import com.vmodev.pdfwriter.model.PDFColor;
import com.vmodev.pdfwriter.model.PDFElement;
import com.vmodev.pdfwriter.model.PDFFont;
import com.vmodev.pdfwriter.model.PDFTable;
import com.vmodev.pdfwriter.model.PDFTableRowStyle;
import com.vmodev.pdfwriter.model.ParagraphElement;
import com.vmodev.pdfwriter.model.PredefinedAlignment;
import com.vmodev.pdfwriter.model.PredefinedColor;
import com.vmodev.pdfwriter.model.PredefinedFont;
import com.vmodev.pdfwriter.model.PredefinedLineStyle;
import com.vmodev.pdfwriter.model.PredefinedSize;
import com.vmodev.pdfwriter.model.PredefinedTransform;
import com.vmodev.pdfwriter.model.RectangleElement;
import com.vmodev.pdfwriter.model.TextElement;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFPage implements IWritable {

   private int height;
   private int width;
   private int objectID;
   private int pageTreeID;
   private String fontObjectsReference;
   private ArrayList elements;

   public PDFPage() {
      height = PredefinedSize.A4_HEIGHT;
      width = PredefinedSize.A4_WIDTH;
      elements = new ArrayList();
   }

   /**
    * Class's Constructor
    *
    * @param newHeight Page's height
    * @param newWidth  Page's width
    */
   public PDFPage(int newHeight, int newWidth) {
      height = newHeight;
      width = newWidth;
      elements = new ArrayList();
   }

   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      this.height = height;
   }

   public int getWidth() {
      return width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

   public int getObjectID() {
      return objectID;
   }

   public void setObjectID(int objectID) {
      this.objectID = objectID;
   }

   public int getPageTreeID() {
      return pageTreeID;
   }

   public void setPageTreeID(int pageTreeID) {
      this.pageTreeID = pageTreeID;
   }

   public ArrayList getElements() {
      return elements;
   }

   public void setElements(ArrayList elements) {
      this.elements = elements;
   }


   /**
    * Method that adds an image to the page object
    *
    * @param bitmap Bitmap input
    * @param X      X position of the image in the page
    * @param Y      Y position of the image in the page
    */
   public void addImage(Bitmap bitmap, int X, int Y) {
      ImageElement objImage = null;
      try {
         objImage = new ImageElement(bitmap, X, Y);
      } catch (PDFImageIOException e) {
         e.printStackTrace();
      }
      elements.add(objImage);
      objImage = null;
   }

   /**
    * Method that adds an image to the page object
    *
    * @param bitmap    Bitmap input
    * @param X         X position of the image in the page
    * @param Y         Y position of the image in the page
    * @param transform Rotate Degree
    */
   public void addImage(Bitmap bitmap, int X, int Y, PredefinedTransform transform) {
      ImageElement objImage = null;
      try {
         objImage = new ImageElement(bitmap, X, Y, transform);
      } catch (PDFImageIOException e) {
         e.printStackTrace();
      }
      elements.add(objImage);
      objImage = null;
   }

   /**
    * Method that adds an image to the page object
    *
    * @param bitmap Bitmap input
    * @param X      X position of the image in the page
    * @param Y      Y position of the image in the page
    * @param height new height
    * @param width  new width
    */
   public void addImage(Bitmap bitmap, int X, int Y, int height, int width) {
      ImageElement objImage = null;
      try {
         objImage = new ImageElement(bitmap, X, Y, height, width);
      } catch (PDFImageIOException e) {
         e.printStackTrace();
      }
      elements.add(objImage);
      objImage = null;
   }

   /**
    * Method that adds an image to the page object
    *
    * @param bitmap    Bitmap input
    * @param X         X position of the image in the page
    * @param Y         Y position of the image in the page
    * @param height    new height
    * @param width     new width
    * @param transform Rotate degree
    */
   public void addImage(Bitmap bitmap, int X, int Y, int height, int width,
                        PredefinedTransform transform) {
      ImageElement objImage = null;
      try {
         objImage = new ImageElement(bitmap, X, Y, height, width, transform);
      } catch (PDFImageIOException e) {
         e.printStackTrace();
      }
      elements.add(objImage);
      objImage = null;
   }


   /**
    * Method that adds an image to the page object
    *
    * @param newImgSource Full image path
    * @param X            X position of the image in the page
    * @param Y            Y position of the image in the page
    * @throws PDFImageNotFoundException
    * @throws PDFImageIOException
    */
   public void addImage(String newImgSource, int X, int Y)
      throws PDFImageNotFoundException, PDFImageIOException {
      try {
         ImageElement objImage = new ImageElement(newImgSource, X, Y);
         elements.add(objImage);
         objImage = null;
      } catch (PDFImageNotFoundException ex) {
         throw new PDFImageNotFoundException(ex.getMessage(), ex);
      } catch (PDFImageIOException ex) {
         throw new PDFImageIOException(ex.getMessage(), ex);
      }
   }

   /**
    * Method that adds an image to the page object
    *
    * @param newImgSource Full image path
    * @param X            X position of the image in the page
    * @param Y            Y position of the image in the page
    * @param transform    Rotate degree
    * @throws PDFImageNotFoundException
    * @throws PDFImageIOException
    */
   public void addImage(String newImgSource, int X, int Y, PredefinedTransform transform)
      throws PDFImageNotFoundException, PDFImageIOException {
      try {
         ImageElement objImage = new ImageElement(newImgSource, X, Y);
         elements.add(objImage);
         objImage = null;
      } catch (PDFImageNotFoundException ex) {
         throw new PDFImageNotFoundException(ex.getMessage(), ex);
      } catch (PDFImageIOException ex) {
         throw new PDFImageIOException(ex.getMessage(), ex);
      }
   }

   /**
    * Method that adds an image to the page object
    *
    * @param newImgSource Full image path
    * @param X            X position of the image in the page
    * @param Y            Y position of the image in the page
    * @param height       New height of the image
    * @param width        New width of the image
    * @throws PDFImageNotFoundException
    * @throws PDFImageIOException
    */
   public void addImage(String newImgSource, int X, int Y, int height, int width)
      throws PDFImageNotFoundException, PDFImageIOException {
      try {
         ImageElement objImage = new ImageElement(newImgSource, X, Y, height, width);
         elements.add(objImage);
         objImage = null;
      } catch (PDFImageNotFoundException ex) {
         throw new PDFImageNotFoundException(ex.getMessage(), ex);
      } catch (PDFImageIOException ex) {
         throw new PDFImageIOException(ex.getMessage(), ex);
      }
   }

   /**
    * Method that adds an image to the page object
    *
    * @param newImgSource Full image path
    * @param X            X position of the image in the page
    * @param Y            Y position of the image in the page
    * @param height       New height of the image
    * @param width        New width of the image
    * @param transform    Rotate degree
    * @throws PDFImageNotFoundException
    * @throws PDFImageIOException
    */
   public void addImage(String newImgSource, int X, int Y, int height, int width,
                        PredefinedTransform transform)
      throws PDFImageNotFoundException, PDFImageIOException {
      try {
         ImageElement objImage = new ImageElement(newImgSource, X, Y, height, width, transform);
         elements.add(objImage);
         objImage = null;
      } catch (PDFImageNotFoundException ex) {
         throw new PDFImageNotFoundException(ex.getMessage(), ex);
      } catch (PDFImageIOException ex) {
         throw new PDFImageIOException(ex.getMessage(), ex);
      }
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText  Text
    * @param X        X position of the text in the page
    * @param Y        Y position of the text in the page
    * @param fontType Font's type
    * @param fontSize Font's size
    */
   public void addText(String newText, int X, int Y, PredefinedFont fontType, int fontSize) {
      TextElement objText = new TextElement(newText, fontSize, fontType, X, Y);
      elements.add(objText);
      objText = null;
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText   Text
    * @param X         X position of the text in the page
    * @param Y         Y position of the text in the page
    * @param fontType  Font's type
    * @param fontSize  Font's size
    * @param fontColor Font's color
    */
   public void addText(String newText, int X, int Y, PredefinedFont fontType, int fontSize,
                       PredefinedColor fontColor) {
      TextElement objText = new TextElement(newText, fontSize, fontType, X, Y, fontColor);
      elements.add(objText);
      objText = null;
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText   Text
    * @param X         X position of the text in the page
    * @param Y         Y position of the text in the page
    * @param fontType  Font's type
    * @param fontSize  Font's size
    * @param fontColor Font's color
    */
   public void addText(String newText, int X, int Y, PredefinedFont fontType, int fontSize,
                       PDFColor fontColor) {
      TextElement objText = new TextElement(newText, fontSize, fontType, X, Y, fontColor);
      elements.add(objText);
      objText = null;
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText   Text
    * @param x         X position of the text in the page
    * @param y         Y position of the text in the page
    * @param fontType  Font's type
    * @param fontSize  Font's size
    * @param fontColor Font's color
    * @param transform Rotate Degree
    */
   public void addText(String newText, int x, int y, PredefinedFont fontType, int fontSize,
                       PredefinedColor fontColor, PredefinedTransform transform) {
      TextElement objText = new TextElement(newText, fontSize, fontType, x, y, fontColor, transform);
      elements.add(objText);
      objText = null;
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText   Text
    * @param x         X position of the text in the page
    * @param y         Y position of the text in the page
    * @param fontType  Font's type
    * @param fontSize  Font's size
    * @param fontColor Font's color
    * @param transform Rotate Degree
    */
   public void addText(String newText, int x, int y, PredefinedFont fontType, int fontSize,
                       PDFColor fontColor, PredefinedTransform transform) {
      TextElement objText = new TextElement(newText, fontSize, fontType, x, y, fontColor, transform);
      elements.add(objText);
      objText = null;
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText  Text
    * @param x        X position of the text in the page
    * @param y        Y position of the text in the page
    * @param fontType Font's type
    * @param parWidth Paragraph's width
    *                 Return height of paragraph;
    */
   public int addParagraph(String newText, int x, int y, PredefinedFont fontType, int fontSize,
                           int parWidth) {
      Iterable formattedPara = TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth);
      ParagraphElement objParagraph = new ParagraphElement(formattedPara, fontSize, fontType, x, y);
      elements.add(objParagraph);
      objParagraph = null;
      return paragraphSize(formattedPara) * (fontSize + 4);
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText   Text
    * @param x         X position of the text in the page
    * @param y         Y position of the text in the page
    * @param fontType  Font's type
    * @param fontSize  Font's size
    * @param parWidth  Paragraph's width
    * @param fontColor Font's color
    *                  Return height of paragraph;
    */
   public int addParagraph(String newText, int x, int y, PredefinedFont fontType, int fontSize,
                           int parWidth, PredefinedColor fontColor) {
      Iterable formattedPara = TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth);
      ParagraphElement objParagraph = new ParagraphElement(TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth), fontSize, fontType, x, y, fontColor);
      elements.add(objParagraph);
      objParagraph = null;
      return paragraphSize(formattedPara) * (fontSize + 4);
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText   Text
    * @param x         X position of the text in the page
    * @param y         Y position of the text in the page
    * @param fontType  Font's type
    * @param fontSize  Font's size
    * @param parWidth  Paragraph's width
    * @param fontColor Font's color
    *                  Return height of paragraph;
    */
   public int addParagraph(String newText, int x, int y, PredefinedFont fontType, int fontSize,
                           int parWidth, PDFColor fontColor) {
      Iterable formattedPara = TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth);
      ParagraphElement objParagraph = new ParagraphElement(TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth), fontSize, fontType, x, y, fontColor);
      elements.add(objParagraph);
      objParagraph = null;
      return paragraphSize(formattedPara) * (fontSize + 4);
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText    Text
    * @param x          X position of the text in the page
    * @param y          Y position of the text in the page
    * @param fontType   Font's type
    * @param fontSize   Font's size
    * @param parWidth   Paragraph's width
    * @param lineHeight Line's height
    *                   Return height of paragraph;
    */
   public int addParagraph(String newText, int x, int y, PredefinedFont fontType, int fontSize,
                           int parWidth, int lineHeight) {
      Iterable formattedPara = TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth, lineHeight);
      ParagraphElement objParagraph = new ParagraphElement(TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth, lineHeight), fontSize, fontType, x, y);
      elements.add(objParagraph);
      objParagraph = null;
      return paragraphSize(formattedPara) * (fontSize + 4);
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText    Text
    * @param x          X position of the text in the page
    * @param y          Y position of the text in the page
    * @param fontType   Font's type
    * @param fontSize   Font's size
    * @param parWidth   Paragraph's width
    * @param lineHeight Line's height
    * @param fontColor  Font's color
    *                   Return height of paragraph;
    */
   public int addParagraph(String newText, int x, int y, PredefinedFont fontType, int fontSize,
                           int parWidth, int lineHeight, PredefinedColor fontColor) {
      Iterable formattedPara = TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth, lineHeight);
      ParagraphElement objParagraph = new ParagraphElement(TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth, lineHeight), fontSize, fontType, x, y, fontColor);
      elements.add(objParagraph);
      objParagraph = null;
      return paragraphSize(formattedPara) * (fontSize + 4);
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText    Text
    * @param x          X position of the text in the page
    * @param y          Y position of the text in the page
    * @param fontType   Font's type
    * @param fontSize   Font's size
    * @param parWidth   Paragraph's width
    * @param lineHeight Line's height
    * @param fontColor  Font's color
    *                   Return height of paragraph;
    */
   public int addParagraph(String newText, int x, int y, PredefinedFont fontType, int fontSize,
                           int parWidth, int lineHeight, PDFColor fontColor) {
      Iterable formattedPara = TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth, lineHeight);
      ParagraphElement objParagraph = new ParagraphElement(TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth, lineHeight), fontSize, fontType, x, y, fontColor);
      elements.add(objParagraph);
      objParagraph = null;
      return paragraphSize(formattedPara) * (fontSize + 4);
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText    Text
    * @param x          X position of the text in the page
    * @param y          Y position of the text in the page
    * @param fontType   Font's type
    * @param fontSize   Font's size
    * @param parWidth   Paragraph's width
    * @param lineHeight Line's height
    * @param parAlign   Paragraph's alignment
    *                   Return height of paragraph;
    */
   public int addParagraph(String newText, int x, int y, PredefinedFont fontType, int fontSize,
                           int parWidth, int lineHeight, PredefinedAlignment parAlign) {
      Iterable formattedPara = TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth, lineHeight, parAlign);
      ParagraphElement objParagraph = new ParagraphElement(TextAdapter.formatParagraph(newText,
         fontSize, fontType, parWidth, lineHeight, parAlign), fontSize, fontType, x, y);
      elements.add(objParagraph);
      objParagraph = null;
      return paragraphSize(formattedPara) * (fontSize + 4);
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText    Text
    * @param x          X position of the text in the page
    * @param y          Y position of the text in the page
    * @param fontType   Font's type
    * @param fontSize   Font's size
    * @param parWidth   Paragraph's width
    * @param lineHeight Line's height
    * @param parAlign   Paragraph's alignment
    * @param fontColor  Font's color
    *                   Return height of paragraph;
    */
   public int addParagraph(String newText, int x, int y, PredefinedFont fontType, int fontSize,
                           int parWidth, int lineHeight, PredefinedAlignment parAlign,
                           PredefinedColor fontColor) {
      Iterable formattedPara = TextAdapter.formatParagraph(newText, fontSize,
         fontType, parWidth, lineHeight, parAlign);
      ParagraphElement objParagraph = new ParagraphElement(TextAdapter.formatParagraph(newText, fontSize,
         fontType, parWidth, lineHeight, parAlign), fontSize, fontType, x, y, fontColor);
      elements.add(objParagraph);
      objParagraph = null;
      return paragraphSize(formattedPara) * (fontSize + 4);
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText  Interface Iterable that contains paragraphLine objects
    * @param x        X position of the text in the page
    * @param y        Y position of the text in the page
    * @param fontType Font's type
    * @param fontSize Font's size
    *                 Return height of paragraph;
    * @throws PDFIncorrectParagraghException
    */
   public int addParagraph(Iterable newText, int x, int y, PredefinedFont fontType,
                           int fontSize) throws PDFIncorrectParagraghException {
      ParagraphElement objParagraph = new ParagraphElement(newText, fontSize, fontType, x, y);
      elements.add(objParagraph);
      objParagraph = null;
      return paragraphSize(newText) * (fontSize + 4);
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText   Interface Iterable that contains paragraphLine objects
    * @param x         X position of the text in the page
    * @param y         Y position of the text in the page
    * @param fontType  Font's type
    * @param fontSize  Font's size
    * @param fontColor Font's color
    *                  Return height of paragraph;
    */
   public int addParagraph(Iterable newText, int x, int y, PredefinedFont fontType, int fontSize,
                           PredefinedColor fontColor) {
      ParagraphElement objParagraph = new ParagraphElement(newText, fontSize, fontType, x, y, fontColor);
      elements.add(objParagraph);
      objParagraph = null;
      return paragraphSize(newText) * (fontSize + 4);
   }

   /**
    * Method that adds a text element to the page object
    *
    * @param newText   Interface Iterable that contains paragraphLine objects
    * @param x         X position of the text in the page
    * @param y         Y position of the text in the page
    * @param fontType  Font's type
    * @param fontSize  Font's size
    * @param fontColor Font's color
    *                  Return height of paragraph;
    */
   public int addParagraph(Iterable newText, int x, int y, PredefinedFont fontType, int fontSize,
                           PDFColor fontColor) {
      ParagraphElement objParagraph = new ParagraphElement(newText, fontSize, fontType, x, y, fontColor);
      elements.add(objParagraph);
      objParagraph = null;
      return paragraphSize(newText) * (fontSize + 4);
   }

   /**
    * Method that adds a table to the page object
    *
    * @param newTable The table object
    * @param x        X position of the table in the page
    * @param y        Y position of the table in the page
    * @throws PDFBadColumnIndexException
    */
   public void addTable(PDFTable newTable, int x, int y) throws PDFBadColumnIndexException {
      int headerHeight = newTable.getTableHeaderStyle().getFontSize() + (newTable.getCellpadding() * 2);
      int rowHeight = newTable.getRowStyle().getFontSize() + (newTable.getCellpadding() * 2);
      int tableWidth = newTable.getBorderSize();
      int i;
      int j;
      int coordx;
      int coordy;
      int textx;
      String textWord;
      PDFTableRowStyle myStyle;
      boolean alternate = false;


      for (i = 0; i < newTable.getTableHeader().getColumnsCount(); i++) {
         tableWidth += (newTable.getBorderSize() + newTable.getTableHeader().getColumn(i).getColumnSize());
      }

      //Table's Header
      coordx = x;
      this.drawRectangle(x, y, x + tableWidth, y - headerHeight, newTable.getBorderColor(),
         newTable.getTableHeaderStyle().getBgColor(), newTable.getBorderSize());
      for (i = 0; i < newTable.getTableHeader().getColumnsCount(); i++) {
         textWord = TextAdapter.cropWord(newTable.getTableHeader().getColumn(i).getColumnValue(),
            newTable.getTableHeaderStyle().getFontSize(), newTable.getTableHeaderStyle().getFontType(),
            newTable.getTableHeader().getColumn(i).getColumnSize() - (newTable.getCellpadding() * 2));
         switch (newTable.getTableHeader().getColumn(i).get_columnAlign()) {
            case Left:
            default:
               textx = coordx + newTable.getCellpadding();
               break;
            case Center:
               textx = coordx + ((newTable.getTableHeader().getColumn(i).getColumnSize() -
                  TextAdapter.wordWeight(textWord, newTable.getTableHeaderStyle().getFontSize(),
                     newTable.getTableHeaderStyle().getFontType())) / 2);
               break;
            case Right:
               textx = coordx + (newTable.getTableHeader().getColumn(i).getColumnSize()
                  - newTable.getCellpadding() - TextAdapter.wordWeight(textWord, newTable
                  .getTableHeaderStyle().getFontSize(), newTable.getTableHeaderStyle().getFontType()));
               break;
         }
         this.addText(textWord, textx, y - (headerHeight - newTable.getCellpadding()), newTable.getTableHeaderStyle()
            .getFontType(), newTable.getTableHeaderStyle().getFontSize());
         coordx += newTable.getTableHeader().getColumn(i).getColumnSize();
         if (i < (newTable.getTableHeader().getColumnsCount() - 1)) {
            this.drawLine(coordx, y, coordx, y - headerHeight, newTable.getBorderColor(),
               newTable.getBorderSize());
         }
      }

      //Table's Rows
      coordy = y - headerHeight;
      for (i = 0; i < newTable.rowCount(); i++) {
         if (alternate && newTable.getAlternateRowStyle() != null) {
            myStyle = newTable.getAlternateRowStyle();
         } else {
            myStyle = newTable.getRowStyle();
         }

         alternate = !(alternate);

         this.drawRectangle(x, coordy, x + tableWidth, coordy - rowHeight, newTable.getBorderColor(), myStyle
            .getBgColor(), newTable.getBorderSize());
         coordx = x;
         for (j = 0; j < newTable.getTableHeader().getColumnsCount(); j++) {
            textWord = TextAdapter.cropWord(newTable.getTableRow(i).getColumn(j).getColumnValue(),
               myStyle.getFontSize(), myStyle.getFontType(), newTable.getTableHeader().getColumn(j)
                  .getColumnSize() - (newTable.getCellpadding() * 2));
            switch (newTable.getTableRow(i).getColumn(j).get_columnAlign()) {
               case Left:
               default:
                  textx = coordx + newTable.getCellpadding();
                  break;
               case Center:
                  textx = coordx + ((newTable.getTableHeader().getColumn(j).getColumnSize()
                     - TextAdapter.wordWeight(textWord, myStyle.getFontSize(), myStyle.getFontType())) / 2);
                  break;
               case Right:
                  textx = coordx + (newTable.getTableHeader().getColumn(j).getColumnSize() - newTable
                     .getCellpadding() - TextAdapter.wordWeight(textWord, myStyle.getFontSize(),
                     myStyle.getFontType()));
                  break;
            }
            this.addText(textWord, textx, coordy - (rowHeight - newTable.getCellpadding()),
               myStyle.getFontType(),
               myStyle.getFontSize());
            coordx += newTable.getTableHeader().getColumn(j).getColumnSize();
            if (j < (newTable.getTableHeader().getColumnsCount() - 1)) {
               this.drawLine(coordx, coordy, coordx, coordy - rowHeight, newTable.getBorderColor(), newTable
                  .getBorderSize());
            }
         }
         coordy -= rowHeight;
      }

   }

   /**
    * Method that adds a line to the page object
    *
    * @param X  X position of the line in the page
    * @param Y  Y position of the line in the page
    * @param X1 X1 position of the line in the page
    * @param Y1 Y1 position of the line in the page
    */
   public void drawLine(int X, int Y, int X1, int Y1) {
      LineElement objLine = new LineElement(X, Y, X1, Y1);
      elements.add(objLine);
      objLine = null;
   }

   /**
    * Method that adds a line to the page object
    *
    * @param X         X position of the line in the page
    * @param Y         Y position of the line in the page
    * @param X1        X1 position of the line in the page
    * @param Y1        Y1 position of the line in the page
    * @param lineColor Line's color
    */
   public void drawLine(int X, int Y, int X1, int Y1, PredefinedColor lineColor) {
      LineElement objLine = new LineElement(X, Y, X1, Y1, lineColor);
      elements.add(objLine);
      objLine = null;
   }

   /**
    * Method that adds a line to the page object
    *
    * @param X         X position of the line in the page
    * @param Y         Y position of the line in the page
    * @param X1        X1 position of the line in the page
    * @param Y1        Y1 position of the line in the page
    * @param lineColor Line's color ie: new PDFColor("0","0","0") => BLACK
    */
   public void drawLine(int X, int Y, int X1, int Y1, PDFColor lineColor) {
      LineElement objLine = new LineElement(X, Y, X1, Y1, lineColor);
      elements.add(objLine);
      objLine = null;
   }

   /**
    * Method that adds a line to the page object
    *
    * @param X         X position of the line in the page
    * @param Y         Y position of the line in the page
    * @param X1        X1 position of the line in the page
    * @param Y1        Y1 position of the line in the page
    * @param lineStyle Line's style
    */
   public void drawLine(int X, int Y, int X1, int Y1, PredefinedLineStyle lineStyle) {
      LineElement objLine = new LineElement(X, Y, X1, Y1, lineStyle);
      elements.add(objLine);
      objLine = null;
   }

   /**
    * Method that adds a line to the page object
    *
    * @param X         X position of the line in the page
    * @param Y         Y position of the line in the page
    * @param X1        X1 position of the line in the page
    * @param Y1        Y1 position of the line in the page
    * @param lineColor Line's color
    * @param lineWidth Line's size
    */
   public void drawLine(int X, int Y, int X1, int Y1, PredefinedColor lineColor, int lineWidth) {
      LineElement objLine = new LineElement(X, Y, X1, Y1, lineWidth, lineColor);
      elements.add(objLine);
      objLine = null;
   }

   /**
    * Method that adds a line to the page object
    *
    * @param X         X position of the line in the page
    * @param Y         Y position of the line in the page
    * @param X1        X1 position of the line in the page
    * @param Y1        Y1 position of the line in the page
    * @param lineColor Line's color
    * @param lineWidth Line's size
    */
   public void drawLine(int X, int Y, int X1, int Y1, PDFColor lineColor, int lineWidth) {
      LineElement objLine = new LineElement(X, Y, X1, Y1, lineWidth, lineColor);
      elements.add(objLine);
      objLine = null;
   }

   /**
    * Method that adds a line to the page object
    *
    * @param X         X position of the line in the page
    * @param Y         Y position of the line in the page
    * @param X1        X1 position of the line in the page
    * @param Y1        Y1 position of the line in the page
    * @param lineStyle Line's style
    * @param lineWidth Line's size
    */
   public void drawLine(int X, int Y, int X1, int Y1, PredefinedLineStyle lineStyle, int lineWidth) {
      LineElement objLine = new LineElement(X, Y, X1, Y1, lineWidth, lineStyle);
      elements.add(objLine);
      objLine = null;
   }

   /**
    * Method that adds a line to the page object
    *
    * @param X         X position of the line in the page
    * @param Y         Y position of the line in the page
    * @param X1        X1 position of the line in the page
    * @param Y1        Y1 position of the line in the page
    * @param lineStyle Line's style
    * @param lineColor Line's color
    */
   public void drawLine(int X, int Y, int X1, int Y1, PredefinedLineStyle lineStyle,
                        PredefinedColor lineColor) {
      LineElement objLine = new LineElement(X, Y, X1, Y1, lineStyle, lineColor);
      elements.add(objLine);
      objLine = null;
   }

   /**
    * Method that adds a line to the page object
    *
    * @param X         X position of the line in the page
    * @param Y         Y position of the line in the page
    * @param X1        X1 position of the line in the page
    * @param Y1        Y1 position of the line in the page
    * @param lineStyle Line's style
    * @param lineColor Line's color
    */
   public void drawLine(int X, int Y, int X1, int Y1, PredefinedLineStyle lineStyle,
                        PDFColor lineColor) {
      LineElement objLine = new LineElement(X, Y, X1, Y1, lineStyle, lineColor);
      elements.add(objLine);
      objLine = null;
   }

   /**
    * Method that adds a line to the page object
    *
    * @param X         X position of the line in the page
    * @param Y         Y position of the line in the page
    * @param X1        X1 position of the line in the page
    * @param Y1        Y1 position of the line in the page
    * @param lineStyle Line's style
    * @param lineColor Line's color
    * @param lineWidth Line's size
    */
   public void drawLine(int X, int Y, int X1, int Y1, PredefinedLineStyle lineStyle,
                        PredefinedColor lineColor, int lineWidth) {
      LineElement objLine = new LineElement(X, Y, X1, Y1, lineWidth, lineStyle, lineColor);
      elements.add(objLine);
      objLine = null;
   }

   /**
    * Method that adds a line to the page object
    *
    * @param X         X position of the line in the page
    * @param Y         Y position of the line in the page
    * @param X1        X1 position of the line in the page
    * @param Y1        Y1 position of the line in the page
    * @param lineStyle Line's style
    * @param lineColor Line's color
    * @param lineWidth Line's size
    */
   public void drawLine(int X, int Y, int X1, int Y1, PredefinedLineStyle lineStyle,
                        PDFColor lineColor, int lineWidth) {
      LineElement objLine = new LineElement(X, Y, X1, Y1, lineWidth, lineStyle, lineColor);
      elements.add(objLine);
      objLine = null;
   }

   /**
    * Method that adds a rectangle to the page object
    *
    * @param X           X position of the rectangle in the page
    * @param Y           Y position of the rectangle in the page
    * @param X1          X1 position of the rectangle in the page
    * @param Y1          Y1 position of the rectangle in the page
    * @param strokeColor Stroke color
    * @param fillColor   Fill color
    */
   public void drawRectangle(int X, int Y, int X1, int Y1, PredefinedColor strokeColor,
                             PredefinedColor fillColor) {
      RectangleElement objRectangle = new RectangleElement(X, Y, X1, Y1, strokeColor, fillColor);
      elements.add(objRectangle);
      objRectangle = null;
   }

   /**
    * Method that adds a rectangle to the page object
    *
    * @param X           X position of the rectangle in the page
    * @param Y           Y position of the rectangle in the page
    * @param X1          X1 position of the rectangle in the page
    * @param Y1          Y1 position of the rectangle in the page
    * @param strokeColor Stroke color
    * @param fillColor   Fill color
    */
   public void drawRectangle(int X, int Y, int X1, int Y1, PDFColor strokeColor,
                             PDFColor fillColor) {
      RectangleElement objRectangle = new RectangleElement(X, Y, X1, Y1, strokeColor, fillColor);
      elements.add(objRectangle);
      objRectangle = null;
   }

   /**
    * Method that adds a rectangle to the page object
    *
    * @param X           X position of the rectangle in the page
    * @param Y           Y position of the rectangle in the page
    * @param X1          X1 position of the rectangle in the page
    * @param Y1          Y1 position of the rectangle in the page
    * @param strokeColor Stroke color
    * @param fillColor   Fill color
    * @param borderWidth Border's size
    */
   public void drawRectangle(int X, int Y, int X1, int Y1, PredefinedColor strokeColor, PredefinedColor fillColor, int
      borderWidth) {
      RectangleElement objRectangle = new RectangleElement(X, Y, X1, Y1, strokeColor, fillColor, borderWidth);
      elements.add(objRectangle);
      objRectangle = null;
   }

   /**
    * Method that adds a rectangle to the page object
    *
    * @param X           X position of the rectangle in the page
    * @param Y           Y position of the rectangle in the page
    * @param X1          X1 position of the rectangle in the page
    * @param Y1          Y1 position of the rectangle in the page
    * @param strokeColor Stroke color
    * @param fillColor   Fill color
    * @param borderWidth Border's size
    */
   public void drawRectangle(int X, int Y, int X1, int Y1, PDFColor strokeColor, PDFColor fillColor, int
      borderWidth) {
      RectangleElement objRectangle = new RectangleElement(X, Y, X1, Y1, strokeColor, fillColor, borderWidth);
      elements.add(objRectangle);
      objRectangle = null;
   }

   /**
    * Method that adds a rectangle to the page object
    *
    * @param X           X position of the rectangle in the page
    * @param Y           Y position of the rectangle in the page
    * @param X1          X1 position of the rectangle in the page
    * @param Y1          Y1 position of the rectangle in the page
    * @param strokeColor Stroke color
    * @param fillColor   Fill color
    * @param borderStyle Border's style
    */
   public void drawRectangle(int X, int Y, int X1, int Y1, PredefinedColor strokeColor,
                             PredefinedColor fillColor, PredefinedLineStyle borderStyle) {
      RectangleElement objRectangle = new RectangleElement(X, Y, X1, Y1, strokeColor, fillColor, borderStyle);
      elements.add(objRectangle);
      objRectangle = null;
   }

   /**
    * Method that adds a rectangle to the page object
    *
    * @param X           X position of the rectangle in the page
    * @param Y           Y position of the rectangle in the page
    * @param X1          X1 position of the rectangle in the page
    * @param Y1          Y1 position of the rectangle in the page
    * @param strokeColor Stroke color
    * @param fillColor   Fill color
    * @param borderStyle Border's style
    */
   public void drawRectangle(int X, int Y, int X1, int Y1, PDFColor strokeColor,
                             PDFColor fillColor, PredefinedLineStyle borderStyle) {
      RectangleElement objRectangle = new RectangleElement(X, Y, X1, Y1, strokeColor, fillColor, borderStyle);
      elements.add(objRectangle);
      objRectangle = null;
   }

   /**
    * Method that adds a rectangle to the page object
    *
    * @param X           X position of the rectangle in the page
    * @param Y           Y position of the rectangle in the page
    * @param X1          X1 position of the rectangle in the page
    * @param Y1          Y1 position of the rectangle in the page
    * @param strokeColor Stroke color
    * @param fillColor   Fill color
    * @param borderWidth Border's width
    * @param borderStyle Border's style
    */
   public void drawRectangle(int X, int Y, int X1, int Y1, PredefinedColor strokeColor,
                             PredefinedColor fillColor, int borderWidth, PredefinedLineStyle borderStyle) {
      RectangleElement objRectangle = new RectangleElement(X, Y, X1, Y1, strokeColor, fillColor, borderWidth, borderStyle);
      elements.add(objRectangle);
      objRectangle = null;
   }

   /**
    * Method that adds a rectangle to the page object
    *
    * @param X           X position of the rectangle in the page
    * @param Y           Y position of the rectangle in the page
    * @param X1          X1 position of the rectangle in the page
    * @param Y1          Y1 position of the rectangle in the page
    * @param strokeColor Stroke color
    * @param fillColor   Fill color
    * @param borderWidth Border's width
    * @param borderStyle Border's style
    */
   public void drawRectangle(int X, int Y, int X1, int Y1, PDFColor strokeColor,
                             PDFColor fillColor, int borderWidth, PredefinedLineStyle borderStyle) {
      RectangleElement objRectangle = new RectangleElement(X, Y, X1, Y1, strokeColor, fillColor, borderWidth, borderStyle);
      elements.add(objRectangle);
      objRectangle = null;
   }

   /**
    * Method that adds a circle to the page object
    *
    * @param X           X position of the circle in the page
    * @param Y           Y position of the circle in the page
    * @param ray         Circle's ray
    * @param strokeColor Border's color
    * @param fillColor   fill color
    */
   public void drawCircle(int X, int Y, int ray, PredefinedColor strokeColor, PredefinedColor
      fillColor) {
      CircleElement objCircle = new CircleElement(X, Y, ray, strokeColor, fillColor);
      elements.add(objCircle);
      objCircle = null;
   }

   /**
    * Method that adds a circle to the page object
    *
    * @param X           X position of the circle in the page
    * @param Y           Y position of the circle in the page
    * @param ray         Circle's ray
    * @param strokeColor Border's color
    * @param fillColor   fill color
    */
   public void drawCircle(int X, int Y, int ray, PDFColor strokeColor, PDFColor fillColor) {
      CircleElement objCircle = new CircleElement(X, Y, ray, strokeColor, fillColor);
      elements.add(objCircle);
      objCircle = null;
   }

   /**
    * Method that adds a circle to the page object
    *
    * @param X           X position of the circle in the page
    * @param Y           Y position of the circle in the page
    * @param ray         Circle's ray
    * @param strokeColor Border's color
    * @param fillColor   fill color
    * @param borderWidth Border's size
    */
   public void drawCircle(int X, int Y, int ray, PredefinedColor strokeColor, PredefinedColor
      fillColor, int borderWidth) {
      CircleElement objCircle = new CircleElement(X, Y, ray, strokeColor, fillColor, borderWidth);
      elements.add(objCircle);
      objCircle = null;
   }

   /**
    * Method that adds a circle to the page object
    *
    * @param X           X position of the circle in the page
    * @param Y           Y position of the circle in the page
    * @param ray         Circle's ray
    * @param strokeColor Border's color
    * @param fillColor   fill color
    * @param borderWidth Border's size
    */
   public void drawCircle(int X, int Y, int ray, PDFColor strokeColor, PDFColor fillColor, int
      borderWidth) {
      CircleElement objCircle = new CircleElement(X, Y, ray, strokeColor, fillColor, borderWidth);
      elements.add(objCircle);
      objCircle = null;
   }

   /**
    * Method that adds a circle to the page object
    *
    * @param X           X position of the circle in the page
    * @param Y           Y position of the circle in the page
    * @param ray         Circle's ray
    * @param strokeColor Border's color
    * @param fillColor   fill color
    * @param borderStyle Border's style
    */
   public void drawCircle(int X, int Y, int ray, PredefinedColor strokeColor, PredefinedColor
      fillColor, PredefinedLineStyle borderStyle) {
      CircleElement objCircle = new CircleElement(X, Y, ray, strokeColor, fillColor, borderStyle);
      elements.add(objCircle);
      objCircle = null;
   }

   /**
    * Method that adds a circle to the page object
    *
    * @param X           X position of the circle in the page
    * @param Y           Y position of the circle in the page
    * @param ray         Circle's ray
    * @param strokeColor Border's color
    * @param fillColor   fill color
    * @param borderStyle Border's style
    */
   public void drawCircle(int X, int Y, int ray, PDFColor strokeColor, PDFColor fillColor,
                          PredefinedLineStyle borderStyle) {
      CircleElement objCircle = new CircleElement(X, Y, ray, strokeColor, fillColor, borderStyle);
      elements.add(objCircle);
      objCircle = null;
   }

   /**
    * Method that adds a circle to the page object
    *
    * @param X           X position of the circle in the page
    * @param Y           Y position of the circle in the page
    * @param ray         Circle's ray
    * @param strokeColor Border's color
    * @param fillColor   fill color
    * @param borderStyle Border's style
    * @param borderWidth Border's size
    */
   public void drawCircle(int X, int Y, int ray, PredefinedColor strokeColor, PredefinedColor fillColor,
                          PredefinedLineStyle borderStyle, int borderWidth) {
      CircleElement objCircle = new CircleElement(X, Y, ray, strokeColor, fillColor, borderWidth, borderStyle);
      elements.add(objCircle);
      objCircle = null;
   }

   /**
    * Method that adds a circle to the page object
    *
    * @param X           X position of the circle in the page
    * @param Y           Y position of the circle in the page
    * @param ray         Circle's ray
    * @param strokeColor Border's color
    * @param fillColor   fill color
    * @param borderStyle Border's style
    * @param borderWidth Border's size
    */
   public void drawCircle(int X, int Y, int ray, PDFColor strokeColor, PDFColor fillColor,
                          PredefinedLineStyle borderStyle, int borderWidth) {
      CircleElement objCircle = new CircleElement(X, Y, ray, strokeColor, fillColor, borderWidth, borderStyle);
      elements.add(objCircle);
      objCircle = null;
   }

   /**
    * Internal method that adds fonts object to the page object
    *
    * @param fonts ArrayList of fonts object
    */
   void addFonts(ArrayList fonts) {
      StringBuilder resultString = new StringBuilder();
      for (int i = 0; i < fonts.size(); i++) {
         resultString.append("/F" + String.valueOf(i + 1) + " " +
            String.valueOf(((PDFFont) fonts.get(i)).getObjectID()) + " 0 R ");
      }
      fontObjectsReference = resultString.toString();
      resultString = null;
   }

   @Override
   public String getText() throws PDFIncorrectParagraghException {
      StringBuilder pageContent = new StringBuilder();
      StringBuilder objContent = new StringBuilder();
      StringBuilder imgContent = new StringBuilder();
      pageContent.append(String.valueOf(objectID) + " 0 obj" + (char) 13 + (char) 10);
      pageContent.append("<<" + (char) 13 + (char) 10);
      pageContent.append("/Type /Page" + (char) 13 + (char) 10);
      pageContent.append("/Parent " + String.valueOf(pageTreeID) + " 0 R" + (char) 13 +
         (char) 10);
      pageContent.append("/Resources <</Font <<" + fontObjectsReference + ">>" + (char) 13 +
         (char) 10);
      for (Object item : elements) {
         objContent.append(String.valueOf(((PDFElement) item).getObjectID()) + " 0 R ");
         if (item.getClass().getName().contains("ImageElement")) {
            imgContent.append("/I" + String.valueOf(((ImageElement) item).getxObjectID()) + " "
               + String.valueOf(((ImageElement) item).getxObjectID()) + " 0 R ");
         }
      }
      if (imgContent.length() > 0) {
         pageContent.append("/XObject <<" + imgContent.toString() + ">>" + (char) 13 + (char) 10);
      }
      pageContent.append(">>" + (char) 13 + (char) 10);
      pageContent.append("/MediaBox [0 0 " + width + " " + height + "]" + (char) 13 +
         (char) 10);
      pageContent.append("/CropBox [0 0 " + width + " " + height + "]" + (char) 13 + (char) 10);
      pageContent.append("/Rotate 0" + (char) 13 + (char) 10);
      pageContent.append("/ProcSet [/PDF /Text /ImageC]" + (char) 13 + (char) 10);
      if (objContent.length() > 0) {
         pageContent.append("/Contents [" + objContent.toString() + "]" + (char) 13 + (char) 10);
      }
      pageContent.append(">>" + (char) 13 + (char) 10);
      pageContent.append("endobj" + (char) 13 + (char) 10);
      objContent = null;
      imgContent = null;
      return pageContent.toString();
   }

   /**
    * Get size of an iteable
    *
    * @param it input
    * @return size of iterable
    */
   private int paragraphSize(Iterable<?> it) {
      if (it instanceof Collection)
         return ((Collection<?>) it).size();

      // else iterate

      int i = 0;
      for (Object obj : it) i++;
      return i;
   }
}
