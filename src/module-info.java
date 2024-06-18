module spotiFy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens spotiFy.Main to javafx.fxml;

    exports spotiFy.Main;
}
