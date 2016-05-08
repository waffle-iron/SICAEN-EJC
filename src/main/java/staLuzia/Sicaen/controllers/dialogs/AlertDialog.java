package staLuzia.Sicaen.controllers.dialogs;

import javafx.scene.control.Alert;
import staLuzia.Sicaen.models.dialogMessages.DialogMessage;

/**
 * Created by Henrique on 08/05/2016.
 */
public class AlertDialog {

    public AlertDialog(){}

    public void showInformationDialog(DialogMessage title, DialogMessage message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title.name());
        alert.setHeaderText(message.name());
        //alert.setContentText(content);

        alert.showAndWait();
    }

}
