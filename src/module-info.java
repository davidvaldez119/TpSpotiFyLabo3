module spotiFy {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.base;
    requires javafx.web;
    requires javafx.swing;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    opens spotiFy.Main to javafx.fxml;

    exports spotiFy.Clases;
    exports spotiFy.Main;
}