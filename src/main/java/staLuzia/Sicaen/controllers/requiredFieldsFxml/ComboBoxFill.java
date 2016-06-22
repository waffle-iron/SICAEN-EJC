package staLuzia.Sicaen.controllers.requiredFieldsFxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Henrique on 06/05/2016.
 */
public class ComboBoxFill {

    public static ObservableList<String> fillRelationshipComboBox(){
        ObservableList<String> relacionamento = FXCollections.observableArrayList(
                "Solteiro","Enrolado","Namorando","Casado"
        );
        return relacionamento;
    }

    public static ObservableList<String> fillTshirSizeComboBox(){
        ObservableList<String> size = FXCollections.observableArrayList(
                "PP","P","M","G","GG"
        );
        return size;
    }

    public static ObservableList<String> fillReligionComboBox(){
        ObservableList<String> religion = FXCollections.observableArrayList(
                "Católico","Evangélico","Espirita","Ateu","Nenhuma"
        );
        return religion;
    }

    public static ObservableList<String> fillPaymentComboBox(){
        ObservableList<String> pagamento = FXCollections.observableArrayList(
                "Pago","Não Pago"
        );
        return pagamento;
    }

    public static ObservableList<String> fillSacramentComboBox(){
        ObservableList<String> sacramento = FXCollections.observableArrayList(
                "Batismo", "Eucaristia", "Crisma", "Matrimônio"
        );

        return sacramento;
    }

}