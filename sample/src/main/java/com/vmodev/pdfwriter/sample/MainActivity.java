package com.vmodev.pdfwriter.sample;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.vmodev.pdfwriter.PDFDocument;
import com.vmodev.pdfwriter.PDFPage;
import com.vmodev.pdfwriter.exception.PDFWritingErrorException;
import com.vmodev.pdfwriter.model.PredefinedFont;


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
               page.addText("ABC ABC ABC ABC ABC ABC BAC", 70, 60, PredefinedFont.Helvetica, 10);
               int height = page.addParagraph("The Unity Asset Store is a great place to find " +
                     "models, " +
                     "scripts, audio and starter kits - but did you know you can also distribute and sell your work to a wide audience of Unity users ? If you're a skilled programmer, artist, designer, modeller or musician, you might want to look at our Asset Store submission guidelines !", 0,
                  700, PredefinedFont.Courier, 10, 500);
               int height2 = page.addParagraph("The Unity Asset Store is a great place to find " +
                  "models, " +
                  "scripts, audio and starter kits - but did you know you can also distribute and" +
                  " sell your work to a wide audience of Unity users ? If you're a skilled " +
                  "programmer, artist, designer, modeller or musician, you might want to look at " +
                  "our Asset Store submission guidelines !",0,700-height,PredefinedFont.Helvetica,
                  10,500);

               int height3 = page.addParagraph("The Unity Asset Store is a great place to find " +
                     "models, " +
                     "scripts, audio and starter kits - but did you know you can also distribute and" +
                     " sell your work to a wide audience of Unity users ? If you're a skilled " +
                     "programmer, artist, designer, modeller or musician, you might want to look at " +
                     "our Asset Store submission guidelines !",0,700-height - height2,PredefinedFont
                     .Times,
                  10,500);

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
