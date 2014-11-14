/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftotalreader;

import java.io.File;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.vietocr.PdfUtilities;
/**
 *
 * @author Administrator
 */
public class PDFTess32 {

    /**
     * @param args the command line arguments
     */
    public String scan(String filestring,String libdir, String languages) {
        File pdfFile = new File("C:\\themis\\BMWPdfs\\adamitest.pdf");
        System.setProperty("jna.library.path",libdir);//insert there all the dlls and .lib file without a slash in the end
        Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
        instance.setLanguage(languages);
        //File[] images = PdfUtilities.convertPdf2Png(pdfFile);
        try {
            //String result = instance.doOCR(images[0]);
            String totalresult = instance.doOCR(pdfFile);
            System.out.println(totalresult);
            return totalresult;
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
            String totalresult="fail";
            return totalresult;
        }
    }
}
