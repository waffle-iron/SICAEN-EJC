package staLuzia.Sicaen.models.pdf;

/**
 * Created by Henrique on 09/05/2016.
 */
public enum PDFModelFields {

    PDF_FILE_MODEL_PATH("template/pdf/pdfModel.pdf"),

    ACROFIELD_NOME("nome"),
    ACROFIELD_APELIDO("apelido"),
    ACROFIELD_DATANASCIMENTO("relacionamento"),
    ACROFIELD_RELACIONAMENTO("dataNascimento"),
    ACROFIELD_CELULAR("celular"),
    ACROFIELD_WHATSAPP("whatsapp"),
    ACROFIELD_RESPONSAVEL1("nomeResponsavel1"),
    ACROFIELD_RESPONSAVEL1_TELEFONE("telefoneResponsavel1"),
    ACROFIELD_RESPONSAVEL2("nomeResponsavel2"),
    ACROFIELD_RESPONSAVEL2_TELEFONE("telefoneResponsavel2"),
    ACROFIELD_EMAIL("email"),
    ACROFIELD_TAMANHOCAMISA("tamanhoCamisa"),
    ACROFIELD_PROBLEMASAUDE("problemaSaude"),
    ACROFIELD_PROBLEMAALIMENTAR("problemaAlimentar"),
    ACROFIELD_ENDERECO("endereco"),
    ACROFIELD_COMPLEMENTO("complemento"),
    ACROFIELD_CEP("cep"),
    ACROFIELD_BAIRRO("bairro"),
    ACROFIELD_REFERENCIA("referencia"),
    ACROFIELD_RELIGIAO("religiao"),
    ACROFIELD_PAROQUIA("paroquia"),
    ACROFIELD_SACRAMENTO("sacramento");

    private final String message;

    PDFModelFields(String msg){
        this.message = msg;
    }

    public String toString(){
        return this.message;
    }
}
