/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftotalreader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**Class to parse the content of a pdf with Apache PDFbox with the encoding of your choice
 *
 * @author Themis Mavridis
 */
public class ReadPDF {

    /**
     * @param args the command line arguments
     */
    public String scan(String filestring,String encoding) {
        try {
            PDFTextStripper pdfStripper = null;
            PDDocument pdDoc = null;
            COSDocument cosDoc = null;
            File file = new File(filestring);//"<file to analyze>"
            PDFParser parser = new PDFParser(new FileInputStream(file));
            parser.parse();
            cosDoc = parser.getDocument();
            pdDoc = new PDDocument(cosDoc);
            PDDocument pdDoc2=parser.getPDDocument();
            pdfStripper = new PDFTextStripper(encoding);//you can set the encoding of your choice
            pdfStripper.setStartPage(1);
            pdfStripper.setEndPage(2);
            String parsedText = pdfStripper.getText(pdDoc2);
            System.out.println(parsedText);
            return parsedText;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadPDF.class.getName()).log(Level.SEVERE, null, ex);
            return "fail";
        } catch (IOException ex) {
            Logger.getLogger(ReadPDF.class.getName()).log(Level.SEVERE, null, ex);
            return "fail";
        }
    }
}
