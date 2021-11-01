package xyz.leet.translator.app.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * A loading view which is shown if something is loading so that the user gets the input that something is being loaded.
 * Shows an infinity loading GIF as long as data is being loaded.
 */
public class LoadingView implements Initializable {
    
    @FXML
    private ImageView gifImageView;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        Image image = new Image(getClass().getClassLoader().getResource("loading.gif").toExternalForm());
        gifImageView.setImage(image);
    }
}
