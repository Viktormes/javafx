module se.iths.javatt.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;


    opens se.iths.javatt.javafx to javafx.fxml;
    exports se.iths.javatt.javafx;
}