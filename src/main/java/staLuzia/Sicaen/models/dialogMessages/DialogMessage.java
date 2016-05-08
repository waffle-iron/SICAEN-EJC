package staLuzia.Sicaen.models.dialogMessages;

/**
 * Created by Henrique on 08/05/2016.
 */
public enum DialogMessage {
    ADDED_SUCCESSFULLY_HEAD("Encontrista cadastrado com Sucesso!"),
    ADDED_SUCCESSFULLY_TITLE("CADASTRADO"),

    ERROR_REGISTER_HEAD("Erro ao cadastrar!"),
    ERROR_REGISTER_TITLE("ERRO"),

    REQUIRED_FIELDS("Alguns campos são obrigatórios e precisam ser preenchidos.");

    private final String message;

    private DialogMessage(String message){
        this.message = message;
    }
}
