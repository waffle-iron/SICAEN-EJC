package staLuzia.Sicaen.models.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import staLuzia.Sicaen.controllers.dialogs.AlertDialog;
import staLuzia.Sicaen.models.dialogMessages.DialogMessage;
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
                PdfReader pdfTemplate = new PdfReader(PDFModelFields.PDF_FILE_MODEL_PATH.toString());
                FileOutputStream fileOutputStream = new FileOutputStream("relatorio/" +enc.getNome()+".pdf");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PdfStamper pdfStamper = new PdfStamper(pdfTemplate, fileOutputStream);
                pdfStamper.setFormFlattening(true);

                //PUTA QUE PARIU! É MUITO CAMPO PARA PREENCHER
                //CAMPOS PARA PREENCHER NO PDF
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_NOME.toString(),
                        enc.getNome().toUpperCase());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_APELIDO.toString(),
                        enc.getApelido());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_RELACIONAMENTO.toString(),
                        enc.getRelacionamento());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_DATANASCIMENTO.toString(),
                        enc.getDataNascimento().toString());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_CELULAR.toString(),
                        enc.getCelular());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_WHATSAPP.toString(),
                        enc.getWhatsapp());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_RESPONSAVEL1.toString(),
                        enc.getNomeResponsavel1());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_RESPONSAVEL1_TELEFONE.toString(),
                        enc.getTelefoneResponsavel1());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_RESPONSAVEL2.toString(),
                        enc.getNomeResponsavel2());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_RESPONSAVEL2_TELEFONE.toString(),
                        enc.getTelefoneResponsavel2());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_EMAIL.toString(),
                        enc.getEmail());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_TAMANHOCAMISA.toString(),
                        enc.getTamanhoCamisa().toUpperCase());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_PROBLEMASAUDE.toString(),
                        enc.getProblemaSaude());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_PROBLEMAALIMENTAR.toString(),
                        enc.getProblemaAlimentar());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_ENDERECO.toString(),
                        enc.getEndereco());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_COMPLEMENTO.toString(),
                        enc.getComplemento());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_CEP.toString(),
                        enc.getCep());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_BAIRRO.toString(),
                        enc.getBairro());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_REFERENCIA.toString(),
                        enc.getReferencia());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_RELIGIAO.toString(),
                        enc.getReligiao());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_PAROQUIA.toString(),
                        enc.getParoquia());
                pdfStamper.getAcroFields().setField(PDFModelFields.ACROFIELD_SACRAMENTO.toString(),
                        enc.getSacramento());

                Image image = Image.getInstance(enc.getImagemPerfil());
                image.scaleAbsolute(4.80f, 5.99f); //Tamanho da imagem no formulario
                image.setAbsolutePosition(13.70f, 5.40f); //Posição da imagem no formulario
                PdfContentByte content = pdfStamper.getUnderContent(1); // pega a página principal
                content.addImage(image); //adiciona a imagem na primeira folha

                pdfStamper.close();
                pdfTemplate.close();
            }

        } catch (IOException e) {
            AlertDialog.showExceptionDialog(DialogMessage.ERROR_EXCEPTION_TITLE, DialogMessage.ERROR_EXCEPTION_HEAD, e);
            e.printStackTrace();
        }
    }

}
