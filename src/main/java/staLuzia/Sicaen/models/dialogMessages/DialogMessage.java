package staLuzia.Sicaen.models.dialogMessages;

/**
 * Created by Henrique on 08/05/2016.
 */
public enum DialogMessage {


    ADDED_SUCCESSFULLY_HEAD("Encontrista cadastrado com Sucesso!"),
    ADDED_SUCCESSFULLY_TITLE("CADASTRADO"),

    ERROR_REGISTER_HEAD("Erro ao Cadastrar!"),
    ERROR_REGISTER_TITLE("ERRO"),

    ERROR_EXCEPTION_HEAD("Algo de muito errado aconteceu!"),
    ERROR_EXCEPTION_TITLE("OPS"),

    ERROR_DOCUMENT_EXCEPTION_TITLE("ERRO"),
    ERROR_DOCUMENT_EXCEPTION_HEAD("Erro ao gerar Relatorio!"),

    DOCUMENT_GENERATED_TITLE("Relatorios Gerados!"),
    DOCUMENT_GENERATED_HEAD("Foram gerados os relatórios de todos os encontristas"),

    ABOUT_TITLE("About"),
    ABOUT_HEAD("Developed by Henrique Dreyer " +
            "\nhenriquedreyer@gmail.com " +
            "\n\nAtribuição-NãoComercial\n" +
            "CC BY-NC ");

    private final String message;

    DialogMessage(String msg){
        this.message = msg;
    }

    public String toString(){
        return this.message;
    }
}
