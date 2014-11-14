/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftotalreader;

/**Class to extract the content of a pdf either with Apache PDFbox with the encoding of your choice
 * or with Tesseract using the Tess4j
 *
 * @author Administrator
 */
public class PDFTotalReader {
   
    public String scan(String choice,String filestring,String encoding,String libdir,String languages) {
        // TODO code application logic here
        if(choice.equalsIgnoreCase("pdfbox")){
            ReadPDF readpdf=new ReadPDF();
            return readpdf.scan(filestring,encoding);
        }
        else if(choice.equalsIgnoreCase("tess4j")){
            PDFTess32 pdftess32=new PDFTess32();
            return pdftess32.scan(filestring,libdir,languages);
        }
        return "no choice made";
    }
}
