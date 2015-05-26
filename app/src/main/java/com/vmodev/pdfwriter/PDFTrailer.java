package com.vmodev.pdfwriter;

import com.vmodev.pdfwriter.exception.PDFIncorrectParagraghException;
import com.vmodev.pdfwriter.model.IWritable;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * Created by Kien on 5/25/2015.
 */
public class PDFTrailer implements IWritable {

   private int lastObjectID;
   private ArrayList objectOffsets;
   private long xrefOffset;


   public PDFTrailer(int lastObjectID) {
      this.lastObjectID = lastObjectID;
      this.objectOffsets = new ArrayList();
   }

   public long getXrefOffset() {
      return xrefOffset;
   }

   public void setXrefOffset(long xrefOffset) {
      this.xrefOffset = xrefOffset;
   }

   public void addObject(String offset) {
      objectOffsets.add(StringUtils.repeat('0', 10 - offset.length()) + offset);
   }

   @Override
   public String getText() throws PDFIncorrectParagraghException {
      StringBuilder content = new StringBuilder();
      content.append("xref" + (char)13 + (char)10);
      content.append("0 " + String.valueOf(lastObjectID + 1) + (char)13 + (char)10);
      content.append("0000000000 65535 f" + (char)13 + (char)10);
      for (Object offset : objectOffsets) {
         content.append(offset.toString() + " 00000 n" + (char)13
            + (char)10);
      }
      content.append("trailer" + (char)13 + (char)10);
      content.append("<<" + (char)13 + (char)10);
      content.append("/Size " + String.valueOf(lastObjectID + 1) + (char)13 + (char)10);
      content.append("/Root 1 0 R" + (char)13 + (char)10);
      content.append("/Info 2 0 R" + (char)13 + (char)10);
      content.append(">>" + (char)13 + (char)10);
      content.append("startxref" + (char)13 + (char)10);
      content.append(String.valueOf(xrefOffset) + (char)13 + (char)10);
      content.append("%%EOF");
      return content.toString();
   }
}
