package xyz.leet.translator.app.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import xyz.leet.translator.enums.EncryptionType;

import java.net.URL;
import java.util.*;

/**
 * A window with 2 tabs.
 * <p>
 * The first tab represents the {@link xyz.leet.translator.translator.Translator} with a cute little UI to translate a given String
 * to the selected {@link EncryptionType} and back.
 * <p>
 * The second tab are the credits for the creators of Leet-Translator.
 */
public class TranslatorView implements Initializable {
    
    private final TranslatorViewModel translatorViewModel;
    
    @FXML
    private TabPane tabPane;
    
    @FXML
    private TextArea textInput;
    
    @FXML
    private TextArea textOutput;
    
    @FXML
    private ComboBox<EncryptionType> comboBox;
    
    public TranslatorView(TranslatorViewModel translatorViewModel) {
        this.translatorViewModel = translatorViewModel;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        tabPane.setBackground(new Background(backgroundImage()));
        
        textInput.setEditable(true);
        textInput.setWrapText(true);
        textOutput.setEditable(false);
        textOutput.setWrapText(true);
        
        comboBox.setItems(encryptionTypeList());
        comboBox.setValue(comboBox.getItems().get(0));
        
        translatorViewModel.getToTranslateProperty().bindBidirectional(textInput.textProperty());
        translatorViewModel.getOutputProperty().bindBidirectional(textOutput.textProperty());
        translatorViewModel.getEncryptionTypeProperty().bindBidirectional(comboBox.valueProperty());
    }
    
    @FXML
    public void onButtonPress(ActionEvent actionEvent) {
        translatorViewModel.translate();
    }
    
    private ObservableList<EncryptionType> encryptionTypeList() {
        
        List<EncryptionType> list = new ArrayList<>();
        
        Collections.addAll(list, EncryptionType.values());
        list.sort(Comparator.comparing(Enum::name));
        
        return FXCollections.observableArrayList(list);
    }
    
    private BackgroundImage backgroundImage() {
        
        Image image = new Image(getClass().getClassLoader().getResource("background.png").toExternalForm());
        
        return new BackgroundImage(
                image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
        );
    }
    
}