# vmo-android-pdf

An android pdf writer - fast and safe

# How to use:
```
//create document
PDFDocument document = new PDFDocument("Document's Name", "Document's Author");
//Add a page
PDFPage page = document.addPage(PredefinedSize.A4_HEIGHT,PredefinedSize.A4_WIDTH);
//Add text to page
page.addText("This is an android pdf writer library", 70, 60, PredefinedFont.Helvetica, 10);
....
//Create PDF
document.createPDF("YourPDFName.pdf");
```

