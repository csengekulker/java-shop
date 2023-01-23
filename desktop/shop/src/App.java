import models.DataService;
import models.MariadbDatabase;
import models.Product;
import models.Restapi;
import views.MainView;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class App extends Application {
    public void start(Stage stage) throws Exception {
        MainView mv = new MainView();
        Scene scene = new Scene(mv, 500, 500, Color.BLACK);

        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
