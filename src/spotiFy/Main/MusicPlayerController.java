package spotiFy.Main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import spotiFy.Clases.Song;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicPlayerController {

    private MediaPlayer mediaPlayer;
    private List<Song> songList = new ArrayList<>();


    @FXML
    private Button botonPlay;

    @FXML
    private Button botonPausa;

    @FXML
    private Button stopButton;

    @FXML
    public void initialize() {
        loadSongsFromFile();
    }

    @FXML
    public void handlePlay() {
        if (mediaPlayer == null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3"));
            File audioFile = fileChooser.showOpenDialog(new Stage());
            if (audioFile != null) {
                Media media = new Media(audioFile.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            }
        } else {
            mediaPlayer.play();
        }
    }

    @FXML
    public void handlePause() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @FXML
    public void handleStop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

    @FXML
    public void handleAddSong() {
        mostrarVentanaAgregarCancion();
    }

    private void mostrarVentanaAgregarCancion() {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Agregar Canción");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Nombre de la canción
        Label nameLabel = new Label("Nombre:");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 0);

        // Duración de la canción
        Label durationLabel = new Label("Duración:");
        GridPane.setConstraints(durationLabel, 0, 1);
        TextField durationInput = new TextField();
        GridPane.setConstraints(durationInput, 1, 1);

        // Género de la canción
        Label genreLabel = new Label("Género:");
        GridPane.setConstraints(genreLabel, 0, 2);
        TextField genreInput = new TextField();
        GridPane.setConstraints(genreInput, 1, 2);


        // Álbum de la canción
        Label albumLabel = new Label("Álbum:");
        GridPane.setConstraints(albumLabel, 0, 4);
        TextField albumInput = new TextField();
        GridPane.setConstraints(albumInput, 1, 4);


        // Botón para agregar la canción
        Button addButton = new Button("Agregar");
        GridPane.setConstraints(addButton, 1, 6);
        addButton.setOnAction(e -> {
            String name = nameInput.getText();
            Double duration = Double.parseDouble(durationInput.getText());
            Genre genre = Genre.valueOf(genreInput.getText().toUpperCase());
            Artist invitedArtist = new Artist(artistInput.getText(), 0, "");
            Album album = new Album(Integer.parseInt(yearInput.getText()), albumInput.getText(), invitedArtist);

            Song song = new Song(name, duration, genre, invitedArtist, album);
            songList.add(song);
            saveSongsToFile();
            ventana.close();
        });

        grid.getChildren().addAll(nameLabel, nameInput, durationLabel, durationInput, genreLabel, genreInput, artistLabel, artistInput, albumLabel, albumInput, yearLabel, yearInput, addButton);

        Scene scene = new Scene(grid, 600, 400);
        ventana.setScene(scene);
        ventana.showAndWait();
    }

    private void saveSongsToFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("songs.json"), songList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSongsFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            songList = mapper.readValue(new File("songs.json"), new TypeReference<List<Song>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
