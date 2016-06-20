package staLuzia.Sicaen.models.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.util.IOUtils;
import staLuzia.Sicaen.models.encontrista.Encontrista;

import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * Created by Henrique on 09/05/2016.
 */
public class PDFReport {

    public PDFReport(){}

    public void generateEncontristaPDFReport(List<Encontrista> listEncontrista) {

        for(Encontrista en : listEncontrista){
            OutputStream outputStream = null;

            try {
                //Cria um Documento tamanho A4
                Document doc = new Document(PageSize.A4);
                outputStream = new FileOutputStream("relatorio/"+en.getNome().toUpperCase() + ".pdf");
                PdfWriter.getInstance(doc, outputStream);
                doc.open();

                //Escrevendo no pdf
                /*File logoStLuzia = new File("draw/StaLuziaLogo.jpg");
                InputStream inputstream = new FileInputStream(logoStLuzia);
                byte[] logoSntaLuziaImgByte = IOUtils.toByteArray(inputstream);
                Image logoSntaLuzia = Image.getInstance(logoSntaLuziaImgByte);
                logoSntaLuzia.setAlignment(Element.ALIGN_LEFT);
                logoSntaLuzia.scaleAbsolute(1080f, 998f);
                doc.add(logoSntaLuzia);*/

                /*
                Image logoSantaLuzia = Image.getInstance("draw/StaLuziaLogo.jpg");
                logoSantaLuzia.scaleAbsolute(80f, 80f);
                logoSantaLuzia.setAlignment(Element.ALIGN_RIGHT);
                doc.add(logoSantaLuzia);*/

                Paragraph titulo = new Paragraph("Paróquia de Santa Luzia");
                titulo.setAlignment(Element.ALIGN_CENTER);
                doc.add(titulo);

                Paragraph section = new Paragraph("EJC");
                section.setAlignment(Element.ALIGN_CENTER);
                doc.add(section);

                //Imagem do perfil
                /*InputStream profileImageInputStream = en.getImagemPerfil();
                byte[] imageByteArray = IOUtils.toByteArray(profileImageInputStream);
                Image profileImage = Image.getInstance(imageByteArray);
                profileImage.setAbsolutePosition(400f, 650f);
                doc.add(profileImage);*/

                File img = new File(en.getImagemPerfil());
                InputStream is = new FileInputStream(img);
                byte[] imgproff = IOUtils.toByteArray(is);
                Image profile = Image.getInstance(imgproff);
                profile.scaleAbsolute(124f, 142f); //Tamanho da imagem
                profile.setAbsolutePosition(430f, 630f); // posição da imagem
                doc.add(profile);

                section = new Paragraph("Nome: "+en.getNome());
                doc.add(section);

                section= new Paragraph("Apelido: "+en.getApelido());
                doc.add(section);

                section = new Paragraph("Relacionamento: "+en.getRelacionamento());
                doc.add(section);

                section = new Paragraph("Nascimento: "+en.getDataNascimento().toString());
                doc.add(section);

                section = new Paragraph("Celular: "+en.getCelular());
                doc.add(section);

                section = new Paragraph("Whatsapp: "+en.getWhatsapp());
                doc.add(section);

                section = new Paragraph("E-mail: "+en.getEmail());
                doc.add(section);

                section = new Paragraph("Endereço: "+en.getEndereco());
                doc.add(section);

                section = new Paragraph("Bairro: "+en.getBairro());
                doc.add(section);

                section = new Paragraph("Complemento: "+en.getComplemento());
                doc.add(section);

                section = new Paragraph("Cep: "+en.getCep());
                doc.add(section);

                section = new Paragraph("Referencia: "+en.getReferencia());
                doc.add(section);

                section = new Paragraph("Nome responsavel: "+en.getNomeResponsavel1());
                doc.add(section);

                section = new Paragraph("Telefone: "+en.getTelefoneResponsavel1());
                doc.add(section);

                section = new Paragraph("Nome responsavel: "+en.getNomeResponsavel2());
                doc.add(section);

                section = new Paragraph("Telefone: "+en.getTelefoneResponsavel2());
                doc.add(section);

                section = new Paragraph("Problema de saúde: "+en.getProblemaSaude());
                doc.add(section);

                section = new Paragraph("Problema alumentar: "+en.getProblemaAlimentar());
                doc.add(section);

                section = new Paragraph("Religião: "+en.getReligiao());
                doc.add(section);

                section = new Paragraph("Paroquia: "+en.getParoquia());
                doc.add(section);

                section = new Paragraph("Sacramento: "+en.getSacramento());
                doc.add(section);

                doc.close();
                outputStream.close();
            }catch (FileNotFoundException fnf){
                //Erro ao criar arquivo
                fnf.printStackTrace();
            } catch (DocumentException e) {
                //Erro ao criar documento
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
