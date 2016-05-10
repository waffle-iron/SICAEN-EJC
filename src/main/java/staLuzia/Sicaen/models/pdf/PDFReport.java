package staLuzia.Sicaen.models.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import staLuzia.Sicaen.models.encontrista.Encontrista;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Henrique on 09/05/2016.
 */
public class PDFReport {

    public PDFReport(){}

    public void generateEncontristaReport(List<Encontrista> list) throws DocumentException {
        try {
            for(Encontrista enc : list) {
                PdfReader pdfTemplate = new PdfReader("template/pdf/pdfModel.pdf");
                FileOutputStream fileOutputStream = new FileOutputStream("relatorio/" +enc.getNome()+".pdf");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PdfStamper pdfStamper = new PdfStamper(pdfTemplate, fileOutputStream);
                pdfStamper.setFormFlattening(true);

                pdfStamper.getAcroFields().setField("nome",enc.getNome().toUpperCase());

                Image image = Image.getInstance(enc.getImagemPerfil());
                image.scaleAbsolute(4.80f, 5.99f); //Tamanho da imagem no formulario
                image.setAbsolutePosition(13.70f, 5.40f); //Posição da imagem no formulario
                PdfContentByte content = pdfStamper.getUnderContent(1); // pega a página principal
                content.addImage(image); //adiciona a imagem na primeira folha

                pdfStamper.close();
                pdfTemplate.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
