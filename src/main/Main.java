package main;

import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.image.Image;
        import javafx.stage.Stage;

        import java.io.File;
        import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        URL url = new File("src/fxml/Main.fxml").toURI().toURL();
        URL url = new File("src/fxml/Login.fxml").toURI().toURL();

        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 400, 400));
//        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image("icons/Student.png"));
        primaryStage.show();
    }
}
