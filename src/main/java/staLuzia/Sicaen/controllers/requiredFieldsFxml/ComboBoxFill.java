package staLuzia.Sicaen.controllers.requiredFieldsFxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Henrique on 06/05/2016.
 */
public class ComboBoxFill {

    public ObservableList<String> fillRelationshipComboBox(){
        ObservableList<String> relacionamento = FXCollections.observableArrayList(
                "Solteiro","Enrolado","Namorando","Casado"
        );
        return relacionamento;
    }

    public ObservableList<String> fillTshirSizeComboBox(){
        ObservableList<String> size = FXCollections.observableArrayList(
                "PP","P","M","G","GG"
        );
        return size;
    }

    public ObservableList<String> fillReligionComboBox(){
        ObservableList<String> religion = FXCollections.observableArrayList(
                "Católico","Evangélico","Espirita","Ateu","Nenhuma"
        );
        return religion;
    }

}