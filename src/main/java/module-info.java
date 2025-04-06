module demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens bilheteria to javafx.fxml;
    opens controller to javafx.fxml;
    exports bilheteria;
    exports controller;
}