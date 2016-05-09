package staLuzia.Sicaen.models.dialogMessages;

/**
 * Created by Henrique on 08/05/2016.
 */
public enum DialogMessage {
    ADDED_SUCCESSFULLY_HEAD{
        @Override
        public String toString() {
            return "Encontrista cadastrado com Sucesso!";
        }
    },
    ADDED_SUCCESSFULLY_TITLE{
        @Override
        public String toString() {
            return "CADASTRADO";
        }
    },

    ERROR_REGISTER_HEAD{
        @Override
        public String toString() {
            return "Erro ao Cadastrar!";
        }
    },
    ERROR_REGISTER_TITLE{
        @Override
        public String toString() {
            return "ERRO";
        }
    },

    ERROR_EXCEPTION_TITLE{
        @Override
        public String toString() {
            return "OPS!";
        }
    },

    ERROR_EXCEPTION_HEAD{
        @Override
        public String toString() {
            return "Algo de muito errado aconteceu!";
        }
    },

    REQUIRED_FIELDS{
        @Override
        public String toString() {
            return "Alguns campos são obrigatórios e precisam ser preenchidos.";
        }
    };

    private final String message;

    private DialogMessage(){
        this.message = null;
    }

    public String toString(){
        return this.message;
    }
}
