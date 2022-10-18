module se.iths.javatt.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.iths.javatt.javafx to javafx.fxml;
    exports se.iths.javatt.javafx;
}