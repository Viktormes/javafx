module se.iths.javatt.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;


    opens se.iths.javatt.javafx to javafx.fxml;
    exports se.iths.javatt.javafx;
    exports se.iths.javatt.javafx.Shape;
    opens se.iths.javatt.javafx.Shape to javafx.fxml;
}