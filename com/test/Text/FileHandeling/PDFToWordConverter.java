package main;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFToWordConverter {

    public static void main(String[] args) {
        // Get the input PDF file path from the user
        String pdfPath = "input.pdf";

        // Get the output Word file name from the user
        String wordPath = "output.docx";

        try {
            // Open the PDF file
            PDDocument document = PDDocument.load(new FileInputStream(pdfPath));

            // Extract the text from the PDF
            String text = new PDFTextExtractor().getText(document);

            // Create a new Word document
            XWPFDocument wordDoc = new XWPFDocument();

            // Split the text into paragraphs
            String[] paragraphs = text.split("\n\n");

            // Add each paragraph to the Word document
            for (String paragraph : paragraphs) {
                XWPFParagraph wordPara = wordDoc.createParagraph();
                wordPara.setText(paragraph);
            }

            // Save the Word document
            FileOutputStream out = new FileOutputStream(wordPath);
            wordDoc.write(out);
            out.close();

            System.out.println("Conversion complete!");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
