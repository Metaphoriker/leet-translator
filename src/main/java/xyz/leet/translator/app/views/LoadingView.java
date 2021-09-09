package xyz.leet.translator.app.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadingView implements Initializable {
    
    @FXML
    private ImageView gifImageView;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        Image image = new Image(getClass().getClassLoader().getResource("loading.gif").toExternalForm());
        gifImageView.setImage(image);
    }
}
