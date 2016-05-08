package staLuzia.Sicaen.controllers.dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import staLuzia.Sicaen.models.dialogMessages.DialogMessage;

/**
 * Created by Henrique on 08/05/2016.
 */
public class AlertDialog {

    public AlertDialog(){}

    public void showInformationDialog(DialogMessage title, DialogMessage message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title.toString());
        alert.setHeaderText(message.toString());

        alert.showAndWait();
    }

    public void showWarningDialog(DialogMessage title, DialogMessage header,DialogMessage content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title.toString());
        alert.setHeaderText(header.toString());
        alert.setContentText(content.toString());

        alert.showAndWait();
    }

    public void showExceptionDialog(DialogMessage title, DialogMessage message, Exception exception){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title.toString());
        alert.setHeaderText(message.toString());

        Label label = new Label("O erro gerou o segunte relatório:");

        TextArea textArea = new TextArea(exception.toString());
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

}
