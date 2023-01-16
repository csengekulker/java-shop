package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class MainWindow extends Application{
    Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView mv = new MainView();
        scene = new Scene(mv, 500, 500, Color.BLACK);

        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
