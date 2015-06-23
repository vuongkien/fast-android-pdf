package com.vmodev.pdfwriter.adapter;

import com.vmodev.pdfwriter.model.ParagraphLine;
import com.vmodev.pdfwriter.model.PredefinedAlignment;
import com.vmodev.pdfwriter.model.PredefinedFont;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kien on 5/25/2015.
 */

/**
 * Abstract class that implements different functions used for text and paragraph
 */
public abstract class TextAdapter {

   /**
    * Static property with the dimensions of the standard fonts
    */
   private static int[][] fontWeight =
      {
         //Helvetica
         new int[]{278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 355, 556, 556, 889, 667, 191, 333, 333, 389, 584, 278, 333, 278, 278, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 278, 278, 584, 584, 584, 556, 1015, 667, 667, 722, 722, 667, 611, 778, 722, 278, 500, 667, 556, 833, 722, 778, 667, 778, 722, 667, 611, 722, 667, 944, 667, 667, 611, 278, 278, 278, 469, 556, 333, 556, 556, 500, 556, 556, 278, 556, 556, 222, 222, 500, 222, 833, 556, 556, 556, 556, 333, 500, 278, 556, 500, 722, 500, 500, 500, 334, 260, 334, 584, 350, 556, 350, 222, 556, 333, 1000, 556, 556, 333, 1000, 667, 333, 1000, 350, 611, 350, 350, 222, 222, 333, 333, 350, 556, 1000, 333, 1000, 500, 333, 944, 350, 500, 667, 278, 333, 556, 556, 556, 556, 260, 556, 333, 737, 370, 556, 584, 333, 737, 333, 400, 584, 333, 333, 333, 556, 537, 278, 333, 333, 365, 556, 834, 834, 834, 611, 667, 667, 667, 667, 667, 667, 1000, 722, 667, 667, 667, 667, 278, 278, 278, 278, 722, 722, 778, 778, 778, 778, 778, 584, 778, 722, 722, 722, 722, 667, 667, 611, 556, 556, 556, 556, 556, 556, 889, 500, 556, 556, 556, 556, 278, 278, 278, 278, 556, 556, 556, 556, 556, 556, 556, 584, 611, 556, 556, 556, 556, 500, 556, 500},
         //HelveticaBold
         new int[]{278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 333, 474, 556, 556, 889, 722, 238, 333, 333, 389, 584, 278, 333, 278, 278, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 333, 333, 584, 584, 584, 611, 975, 722, 722, 722, 722, 667, 611, 778, 722, 278, 556, 722, 611, 833, 722, 778, 667, 778, 722, 667, 611, 722, 667, 944, 667, 667, 611, 333, 278, 333, 584, 556, 333, 556, 611, 556, 611, 556, 333, 611, 611, 278, 278, 556, 278, 889, 611, 611, 611, 611, 389, 556, 333, 611, 556, 778, 556, 556, 500, 389, 280, 389, 584, 350, 556, 350, 278, 556, 500, 1000, 556, 556, 333, 1000, 667, 333, 1000, 350, 611, 350, 350, 278, 278, 500, 500, 350, 556, 1000, 333, 1000, 556, 333, 944, 350, 500, 667, 278, 333, 556, 556, 556, 556, 280, 556, 333, 737, 370, 556, 584, 333, 737, 333, 400, 584, 333, 333, 333, 611, 556, 278, 333, 333, 365, 556, 834, 834, 834, 611, 722, 722, 722, 722, 722, 722, 1000, 722, 667, 667, 667, 667, 278, 278, 278, 278, 722, 722, 778, 778, 778, 778, 778, 584, 778, 722, 722, 722, 722, 667, 667, 611, 556, 556, 556, 556, 556, 556, 889, 556, 556, 556, 556, 556, 278, 278, 278, 278, 611, 611, 611, 611, 611, 611, 611, 584, 611, 611, 611, 611, 611, 556, 611, 556},
         //HelveticaOblique
         new int[]{278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 355, 556, 556, 889, 667, 191, 333, 333, 389, 584, 278, 333, 278, 278, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 278, 278, 584, 584, 584, 556, 1015, 667, 667, 722, 722, 667, 611, 778, 722, 278, 500, 667, 556, 833, 722, 778, 667, 778, 722, 667, 611, 722, 667, 944, 667, 667, 611, 278, 278, 278, 469, 556, 333, 556, 556, 500, 556, 556, 278, 556, 556, 222, 222, 500, 222, 833, 556, 556, 556, 556, 333, 500, 278, 556, 500, 722, 500, 500, 500, 334, 260, 334, 584, 350, 556, 350, 222, 556, 333, 1000, 556, 556, 333, 1000, 667, 333, 1000, 350, 611, 350, 350, 222, 222, 333, 333, 350, 556, 1000, 333, 1000, 500, 333, 944, 350, 500, 667, 278, 333, 556, 556, 556, 556, 260, 556, 333, 737, 370, 556, 584, 333, 737, 333, 400, 584, 333, 333, 333, 556, 537, 278, 333, 333, 365, 556, 834, 834, 834, 611, 667, 667, 667, 667, 667, 667, 1000, 722, 667, 667, 667, 667, 278, 278, 278, 278, 722, 722, 778, 778, 778, 778, 778, 584, 778, 722, 722, 722, 722, 667, 667, 611, 556, 556, 556, 556, 556, 556, 889, 500, 556, 556, 556, 556, 278, 278, 278, 278, 556, 556, 556, 556, 556, 556, 556, 584, 611, 556, 556, 556, 556, 500, 556, 500},
         //HelvetivaBoldOblique
         new int[]{278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 278, 333, 474, 556, 556, 889, 722, 238, 333, 333, 389, 584, 278, 333, 278, 278, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 333, 333, 584, 584, 584, 611, 975, 722, 722, 722, 722, 667, 611, 778, 722, 278, 556, 722, 611, 833, 722, 778, 667, 778, 722, 667, 611, 722, 667, 944, 667, 667, 611, 333, 278, 333, 584, 556, 333, 556, 611, 556, 611, 556, 333, 611, 611, 278, 278, 556, 278, 889, 611, 611, 611, 611, 389, 556, 333, 611, 556, 778, 556, 556, 500, 389, 280, 389, 584, 350, 556, 350, 278, 556, 500, 1000, 556, 556, 333, 1000, 667, 333, 1000, 350, 611, 350, 350, 278, 278, 500, 500, 350, 556, 1000, 333, 1000, 556, 333, 944, 350, 500, 667, 278, 333, 556, 556, 556, 556, 280, 556, 333, 737, 370, 556, 584, 333, 737, 333, 400, 584, 333, 333, 333, 611, 556, 278, 333, 333, 365, 556, 834, 834, 834, 611, 722, 722, 722, 722, 722, 722, 1000, 722, 667, 667, 667, 667, 278, 278, 278, 278, 722, 722, 778, 778, 778, 778, 778, 584, 778, 722, 722, 722, 722, 667, 667, 611, 556, 556, 556, 556, 556, 556, 889, 556, 556, 556, 556, 556, 278, 278, 278, 278, 611, 611, 611, 611, 611, 611, 611, 584, 611, 611, 611, 611, 611, 556, 611, 556},
         //Courier
         new int[]{00, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600},
         //CourierBold
         new int[]{00, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600},
         //CourierOblique
         new int[]{00, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600},
         //CourierBoldOblique
         new int[]{00, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600},
         //Times
         new int[]{250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 333, 408, 500, 500, 833, 778, 180, 333, 333, 500, 564, 250, 333, 250, 278, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 278, 278, 564, 564, 564, 444, 921, 722, 667, 667, 722, 611, 556, 722, 722, 333, 389, 722, 611, 889, 722, 722, 556, 722, 667, 556, 611, 722, 722, 944, 722, 722, 611, 333, 278, 333, 469, 500, 333, 444, 500, 444, 500, 444, 333, 500, 500, 278, 278, 500, 278, 778, 500, 500, 500, 500, 333, 389, 278, 500, 500, 722, 500, 500, 444, 480, 200, 480, 541, 350, 500, 350, 333, 500, 444, 1000, 500, 500, 333, 1000, 556, 333, 889, 350, 611, 350, 350, 333, 333, 444, 444, 350, 500, 1000, 333, 980, 389, 333, 722, 350, 444, 722, 250, 333, 500, 500, 500, 500, 200, 500, 333, 760, 276, 500, 564, 333, 760, 333, 400, 564, 300, 300, 333, 500, 453, 250, 333, 300, 310, 500, 750, 750, 750, 444, 722, 722, 722, 722, 722, 722, 889, 667, 611, 611, 611, 611, 333, 333, 333, 333, 722, 722, 722, 722, 722, 722, 722, 564, 722, 722, 722, 722, 722, 722, 556, 500, 444, 444, 444, 444, 444, 444, 667, 444, 444, 444, 444, 444, 278, 278, 278, 278, 500, 500, 500, 500, 500, 500, 500, 564, 500, 500, 500, 500, 500, 500, 500, 500},
         //TimesBold
         new int[]{250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 333, 555, 500, 500, 1000, 833, 278, 333, 333, 500, 570, 250, 333, 250, 278, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 333, 333, 570, 570, 570, 500, 930, 722, 667, 722, 722, 667, 611, 778, 778, 389, 500, 778, 667, 944, 722, 778, 611, 778, 722, 556, 667, 722, 722, 1000, 722, 722, 667, 333, 278, 333, 581, 500, 333, 500, 556, 444, 556, 444, 333, 500, 556, 278, 333, 556, 278, 833, 556, 500, 556, 556, 444, 389, 333, 556, 500, 722, 500, 500, 444, 394, 220, 394, 520, 350, 500, 350, 333, 500, 500, 1000, 500, 500, 333, 1000, 556, 333, 1000, 350, 667, 350, 350, 333, 333, 500, 500, 350, 500, 1000, 333, 1000, 389, 333, 722, 350, 444, 722, 250, 333, 500, 500, 500, 500, 220, 500, 333, 747, 300, 500, 570, 333, 747, 333, 400, 570, 300, 300, 333, 556, 540, 250, 333, 300, 330, 500, 750, 750, 750, 500, 722, 722, 722, 722, 722, 722, 1000, 722, 667, 667, 667, 667, 389, 389, 389, 389, 722, 722, 778, 778, 778, 778, 778, 570, 778, 722, 722, 722, 722, 722, 611, 556, 500, 500, 500, 500, 500, 500, 722, 444, 444, 444, 444, 444, 278, 278, 278, 278, 500, 556, 500, 500, 500, 500, 500, 570, 500, 556, 556, 556, 556, 500, 556, 500},
         //csTimesOblique
         new int[]{250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 333, 420, 500, 500, 833, 778, 214, 333, 333, 500, 675, 250, 333, 250, 278, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 333, 333, 675, 675, 675, 500, 920, 611, 611, 667, 722, 611, 611, 722, 722, 333, 444, 667, 556, 833, 667, 722, 611, 722, 611, 500, 556, 722, 611, 833, 611, 556, 556, 389, 278, 389, 422, 500, 333, 500, 500, 444, 500, 444, 278, 500, 500, 278, 278, 444, 278, 722, 500, 500, 500, 500, 389, 389, 278, 500, 444, 667, 444, 444, 389, 400, 275, 400, 541, 350, 500, 350, 333, 500, 556, 889, 500, 500, 333, 1000, 500, 333, 944, 350, 556, 350, 350, 333, 333, 556, 556, 350, 500, 889, 333, 980, 389, 333, 667, 350, 389, 556, 250, 389, 500, 500, 500, 500, 275, 500, 333, 760, 276, 500, 675, 333, 760, 333, 400, 675, 300, 300, 333, 500, 523, 250, 333, 300, 310, 500, 750, 750, 750, 500, 611, 611, 611, 611, 611, 611, 889, 667, 611, 611, 611, 611, 333, 333, 333, 333, 722, 667, 722, 722, 722, 722, 722, 675, 722, 722, 722, 722, 722, 556, 611, 500, 500, 500, 500, 500, 500, 500, 667, 444, 444, 444, 444, 444, 278, 278, 278, 278, 500, 500, 500, 500, 500, 500, 500, 675, 500, 500, 500, 500, 500, 444, 500, 444},
         //TimesBoldOblique
         new int[]{250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 250, 389, 555, 500, 500, 833, 778, 278, 333, 333, 500, 570, 250, 333, 250, 278, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 333, 333, 570, 570, 570, 500, 832, 667, 667, 667, 722, 667, 667, 722, 778, 389, 500, 667, 611, 889, 722, 722, 611, 722, 667, 556, 611, 722, 667, 889, 667, 611, 611, 333, 278, 333, 570, 500, 333, 500, 500, 444, 500, 444, 333, 500, 556, 278, 278, 500, 278, 778, 556, 500, 500, 500, 389, 389, 278, 556, 444, 667, 500, 444, 389, 348, 220, 348, 570, 350, 500, 350, 333, 500, 500, 1000, 500, 500, 333, 1000, 556, 333, 944, 350, 611, 350, 350, 333, 333, 500, 500, 350, 500, 1000, 333, 1000, 389, 333, 722, 350, 389, 611, 250, 389, 500, 500, 500, 500, 220, 500, 333, 747, 266, 500, 606, 333, 747, 333, 400, 570, 300, 300, 333, 576, 500, 250, 333, 300, 300, 500, 750, 750, 750, 500, 667, 667, 667, 667, 667, 667, 944, 667, 667, 667, 667, 667, 389, 389, 389, 389, 722, 722, 722, 722, 722, 722, 722, 570, 722, 722, 722, 722, 722, 611, 611, 500, 500, 500, 500, 500, 500, 500, 722, 444, 444, 444, 444, 444, 278, 278, 278, 278, 500, 556, 500, 500, 500, 500, 500, 570, 500, 556, 556, 556, 556, 444, 500, 444}
      };

   /**
    * Static method that encodes the string
    *
    * @param strText Input Text
    * @return Result of the encoding
    */
   public static String encodeHEX(String strText) {
      byte[] bytes = stringToBytesASCII(strText);
      return new String(Hex.encodeHex(bytes));
   }

   public static String encodeHEX(String strText, String encoding) {
      byte[] bytes = stringToBytes(strText, encoding);
      return new String(Hex.encodeHex(bytes));
   }

   /**
    * Convert String ASCII to byte array
    *
    * @param str Input string
    * @return byte array
    */
   public static byte[] stringToBytesASCII(String str) {
      char[] buffer = str.toCharArray();
      byte[] b = new byte[buffer.length];
      for (int i = 0; i < b.length; i++) {
         b[i] = (byte) buffer[i];
      }
      return b;
   }

   /**
    * Convert String  UTF-8 to byte array
    */
   public static byte[] stringToBytesUTF8(String str) {
      return org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str);
   }

   /**
    * Convert String to byte array
    *
    * @param str Input string
    * @return byte array
    */
   public static byte[] stringToBytes(String str, String encoding) {
      try {
         return str.getBytes(encoding);
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
      return null;
   }


   /**
    * Static method that checks special characters into a string
    *
    * @param strText Input text
    * @return Formatted text
    */
   public static String checkText(String strText) {
      String checkedString = strText;
      checkedString = checkedString.replace("(", "\\(");
      checkedString = checkedString.replace(")", "\\)");
      return checkedString;
   }

   /**
    * Static method thats format a paragraph
    *
    * @param strText  Input text
    * @param fontSize Font's size
    * @param fontType Font's type
    * @param parWidth Paragraph's width
    * @return Iterable interface that contains paragraphLine objects
    */
   public static Iterable formatParagraph(String strText, int fontSize, PredefinedFont fontType, int
      parWidth, int parHeight) {
      return formatParagraph(strText, fontSize, fontType, parWidth,parHeight ,fontSize + 4,
         PredefinedAlignment.Left);
   }

   /**
    * Static method that format a paragraph
    *
    * @param strText    Input text
    * @param fontSize   Font's size
    * @param fontType   Font's type
    * @param parWidth   Paragraph's width
    * @param lineHeight Line's height
    * @return Iterable interface that contains paragraphLine objects
    */
   public static Iterable formatParagraph(String strText, int fontSize, PredefinedFont fontType,
                                          int parWidth, int parHeight, int lineHeight) {
      return formatParagraph(strText, fontSize, fontType, parWidth, parHeight, lineHeight,
         PredefinedAlignment.Left);
   }

   /**
    * Static method that format a paragraph
    *
    * @param strText    Input text
    * @param fontSize   Font's size
    * @param fontType   Font's type
    * @param parWidth   Paragraph's width
    * @param lineHeight Line's height
    * @param parAlign   Paragraph's Alignment
    * @return Iterable interface that contains paragraphLine objects
    */
   public static Iterable formatParagraph(String strText, int fontSize, PredefinedFont fontType,
                                          int parWidth, int parHeight, int lineHeight,
                                          PredefinedAlignment parAlign) {
      int maxLine = parHeight/lineHeight;
      int count=0;
      String[] paragraphsArray = strText.split("[\\r\\n]+");
      String[] bufferArray;
      int lineLength;
      ParagraphLine tempPar;
      StringBuilder lineString = new StringBuilder(parWidth);
      ArrayList resultArray = new ArrayList();
      lineLength = 0;
      for (String paragraph : paragraphsArray) {
         bufferArray = paragraph.split(" ");
         for (String word : bufferArray) {
            if ((TextAdapter.wordWeight(word + " ", fontSize, fontType) + lineLength) > parWidth
               && lineLength != 0) {
               switch (parAlign) {
                  case Left:
                  default:
                     tempPar = new ParagraphLine(lineString.substring(0, lineString.length() - 1).trim(),
                        lineHeight, 0);
                     break;
                  case Right:
                     tempPar = new ParagraphLine(lineString.substring(0, lineString.length() - 1).trim()
                        , lineHeight, parWidth - lineLength);
                     break;
                  case Center:
                     tempPar = new ParagraphLine(lineString.substring(0, lineString.length() - 1).trim()
                        , lineHeight, ((parWidth - lineLength) / 2));
                     break;
               }
               if(count<maxLine) {
                  resultArray.add(tempPar);
                  lineString.replace(0, lineString.length() - 1, "");
                  lineLength = 0;
                  count++;
               }else {
                  return resultArray;
               }
            }
            if (TextAdapter.wordWeight(word, fontSize, fontType) > parWidth) {
               List<String> splitWord = splitWord(word, fontSize, fontType, parWidth);
               for (int i = 0; i < splitWord.size() - 1; i++) {
                  switch (parAlign) {
                     case Left:
                     default:
                        tempPar = new ParagraphLine(splitWord.get(i).trim(), lineHeight, 0);
                        break;
                     case Right:
                        tempPar = new ParagraphLine(splitWord.get(i).trim(), lineHeight, parWidth - lineLength);
                        break;
                     case Center:
                        tempPar = new ParagraphLine(splitWord.get(i).trim(), lineHeight, ((parWidth - lineLength) / 2));
                        break;
                  }
                  if(count<maxLine) {
                     resultArray.add(tempPar);
                     count++;
                  }else {
                     return resultArray;
                  }
               }
               word = splitWord.get(splitWord.size() - 1);
            }
            lineString.append(word + " ");
            lineLength += TextAdapter.wordWeight(word + " ", fontSize, fontType);
         }
         if (lineLength > 0) {
            switch (parAlign) {
               case Left:
               default:
                  tempPar = new ParagraphLine(lineString.substring(0, lineString.length() - 1).trim(),
                     lineHeight, 0);
                  break;
               case Right:
                  tempPar = new ParagraphLine(lineString.substring(0, lineString.length() - 1).trim(),
                     lineHeight, parWidth - lineLength);
                  break;
               case Center:
                  tempPar = new ParagraphLine(lineString.substring(0, lineString.length() - 1).trim(),
                     lineHeight, ((parWidth - lineLength) / 2));
                  break;
            }
            if(count<maxLine) {
               resultArray.add(tempPar);
               lineString.replace(0, lineString.length() - 1, "");
               lineLength = 0;
               count++;
            }else {
               return resultArray;
            }
         }
         bufferArray = null;
      }
      return resultArray;
   }

   /**
    * Static Method that returns the length of a single word
    *
    * @param word     Input word
    * @param fontSize Font's size
    * @param fontType Font's type
    * @return Size of the word
    */
   public static int wordWeight(String word, int fontSize, PredefinedFont fontType) {
      double returnWeight = 0;
      for (char myChar : word.toCharArray()) {
         try {
            returnWeight += TextAdapter.fontWeight[fontType.getValue() - 1][(byte) myChar];
         } catch (IndexOutOfBoundsException ex) {
            returnWeight += TextAdapter.fontWeight[fontType.getValue() - 1][1];
         }
      }
      return (int) (returnWeight * fontSize / 1000);
   }

   /**
    * Static Method that crop a word to put it in a predefined space
    *
    * @param word      Input word
    * @param fontSize  Font's size
    * @param fontType  Font's type
    * @param textSpace Max text's space
    * @return Cropped word
    */
   public static String cropWord(String word, int fontSize, PredefinedFont fontType, int textSpace) {
      StringBuilder tempWord = new StringBuilder();
      int i = 0;
      while ((wordWeight(tempWord.toString(), fontSize, fontType) <= textSpace) && (i < word
         .length())) {
         tempWord.append(word.toCharArray()[i]);
         i++;
      }
      if (tempWord.toString().compareTo(word) != 0) {
         tempWord.replace(tempWord.length() - 3, tempWord.length(), "");
         tempWord.append("...");
      }
      return tempWord.toString();
   }

   /**
    * Static method that split word if word's length longer than line's length
    *
    * @param word      input word
    * @param fontSize  font's size
    * @param fontType  font's type
    * @param textSpace line's width
    * @return List split word
    */
   public static List<String> splitWord(String word, int fontSize, PredefinedFont fontType,
                                        int textSpace) {
      List<String> splitWord = new ArrayList<>();
      StringBuilder tempWord = new StringBuilder();
      int i = 0;
      while ((i < word.length())) {
         while ((wordWeight(tempWord.toString(), fontSize, fontType) <= textSpace) && (i < word.length())) {
            tempWord.append(word.toCharArray()[i]);
            i++;
         }
         splitWord.add(tempWord.toString());
         tempWord.replace(0, tempWord.length() - 1, "");
      }
      return splitWord;
   }

}
