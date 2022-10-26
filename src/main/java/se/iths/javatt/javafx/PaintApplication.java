package se.iths.javatt.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class PaintApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaintApplication.class.getResource("shapes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 520);
        stage.setTitle("VIKTORS FORMER");
        stage.setScene(scene);
        stage.getIcons().add(new Image(PaintApplication.class.getResourceAsStream("GGG2.png")));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
