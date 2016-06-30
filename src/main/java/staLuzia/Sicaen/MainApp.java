package staLuzia.Sicaen;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import staLuzia.Sicaen.controllers.MainLayoutController;

/**
 * Created by Henrique on 06/05/2016.
 */
public class MainApp extends Application{
    private FXMLLoader fxmloader;

    @Override
    public void start(final Stage stage) throws Exception {
        Parent root = fxmloader.load(getClass().getResource("/fxml/MainLayout.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/Styles.css");

        stage.setTitle("Sistema de Cadastro de Encontristas - EJC");
        stage.setScene(scene);

        stage.setResizable(false);
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                MainLayoutController.close();
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }
}