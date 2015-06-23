package com.vmodev.pdfwriter.sample;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.vmodev.pdfwriter.PDFDocument;
import com.vmodev.pdfwriter.PDFPage;
import com.vmodev.pdfwriter.exception.PDFBadColumnIndexException;
import com.vmodev.pdfwriter.exception.PDFImageIOException;
import com.vmodev.pdfwriter.exception.PDFImageNotFoundException;
import com.vmodev.pdfwriter.exception.PDFIncorrectColumnException;
import com.vmodev.pdfwriter.exception.PDFIncorrectRowException;
import com.vmodev.pdfwriter.exception.PDFWritingErrorException;
import com.vmodev.pdfwriter.model.PDFColor;
import com.vmodev.pdfwriter.model.PDFTable;
import com.vmodev.pdfwriter.model.PDFTableColumn;
import com.vmodev.pdfwriter.model.PDFTableHeader;
import com.vmodev.pdfwriter.model.PDFTableRow;
import com.vmodev.pdfwriter.model.PredefinedAlignment;
import com.vmodev.pdfwriter.model.PredefinedFont;
import com.vmodev.pdfwriter.model.PredefinedSize;
import com.vmodev.pdfwriter.model.PredefinedTransform;


public class MainActivity extends ActionBarActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            PDFDocument document = new PDFDocument("Kien", "ME");
            for (int i = 0; i <= 50; i++) {
               PDFPage page = document.addPage();
               page.addText("Kiên", 70, 60, PredefinedFont.Times,
                  10);
               int height = page.addParagraph
                  ("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaA test too long word aaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaA", 20,
                  PredefinedSize.A4_HEIGHT,PredefinedFont.Courier, 10, 100,200);


               try {
                  PDFTable pdfTable = new PDFTable();
                  PDFTableHeader header = new PDFTableHeader();
                  PDFTableColumn column1 = new PDFTableColumn("STT", PredefinedAlignment.Center, 100);
                  PDFTableColumn column2 = new PDFTableColumn("Name", PredefinedAlignment.Center, 200);
                  PDFTableColumn column3 = new PDFTableColumn("Salary", PredefinedAlignment.Center,
                     200);
                  header.addColumn(column1);
                  header.addColumn(column2);
                  header.addColumn(column3);
                  pdfTable.setTableHeader(header);
                  PDFTableRow row1 = new PDFTableRow(header);
                  row1.setColumn(0, new PDFTableColumn("1", PredefinedAlignment.Center, 100));
                  row1.setColumn(1, new PDFTableColumn("Kien", PredefinedAlignment.Center, 200));
                  row1.setColumn(2, new PDFTableColumn("$1000", PredefinedAlignment.Center, 200));
                  PDFTableRow row2 = new PDFTableRow(header);
                  row2.setColumn(0, new PDFTableColumn("2", PredefinedAlignment.Center, 100));
                  row2.setColumn(1, new PDFTableColumn("Kien", PredefinedAlignment.Center, 200));
                  row2.setColumn(2, new PDFTableColumn("$1000", PredefinedAlignment.Center, 200));
                  PDFTableRow row3 = new PDFTableRow(header);
                  row3.setColumn(0, new PDFTableColumn("3", PredefinedAlignment.Center, 100));
                  row3.setColumn(1, new PDFTableColumn("Kien", PredefinedAlignment.Center, 200));
                  row3.setColumn(2, new PDFTableColumn("$1000", PredefinedAlignment.Center, 200));
                  PDFTableRow row4 = new PDFTableRow(header);
                  row4.setColumn(1, new PDFTableColumn("Kien", PredefinedAlignment.Center, 200));
                  row4.setColumn(2, new PDFTableColumn("$1000", PredefinedAlignment.Center, 200));
                  PDFTableRow row5 = new PDFTableRow(header);
                  row5.setColumn(2, new PDFTableColumn("The Unity Asset Store is a great place to find ", PredefinedAlignment.Center, 200));
                  pdfTable.addRow(row1);
                  pdfTable.addRow(row2);
                  pdfTable.addRow(row3);
                  pdfTable.addRow(row4);
                  pdfTable.addRow(row5);
                  page.addTable(pdfTable, 20, 700 - height);
               } catch (PDFIncorrectColumnException | PDFBadColumnIndexException
                  | PDFIncorrectRowException e) {
                  e.printStackTrace();
               }

            }
            for(int i=0;i<50;i++) {
               PDFPage pdfPage2 = document.addPage(PredefinedSize.A4_WIDTH, PredefinedSize.A4_HEIGHT);
               pdfPage2.addText("ABC ABC ABC ABC ABC ABC BAC", 70, 60, PredefinedFont.Helvetica, 10
                  ,new PDFColor("#ff0000"), PredefinedTransform.DEGREES_90_ROTATION);
               try {
                  pdfPage2.addImage(Environment.getExternalStorageDirectory() + "/picture.jpg",
                          20, 100,400,400);
               } catch (PDFImageNotFoundException e) {
                  e.printStackTrace();
               } catch (PDFImageIOException e) {
                  e.printStackTrace();
               }
            }
            try {
               document.createPDF(Environment.getExternalStorageDirectory() + "/KienPDFTest.pdf");
            } catch (PDFWritingErrorException e) {
               e.printStackTrace();
            }
         }
      });
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId();

      //noinspection SimplifiableIfStatement
      if (id == R.id.action_settings) {
         return true;
      }

      return super.onOptionsItemSelected(item);
   }
}
