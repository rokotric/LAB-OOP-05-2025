package app.src.main.java.tp;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        RegisterScene registerScene = new RegisterScene(primaryStage);
        primaryStage.setTitle("MyMoment");
        primaryStage.setScene(registerScene.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
