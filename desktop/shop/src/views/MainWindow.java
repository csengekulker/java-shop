package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class MainWindow extends Application{

    public MainWindow() {
    }

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
