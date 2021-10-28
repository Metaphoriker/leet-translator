package xyz.leet.translator.app.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import xyz.leet.translator.enums.EncryptionType;

import java.net.URL;
import java.util.*;

/**
 * Leet-Translator view which represents the Translator visually.
 */
public class TranslatorView implements Initializable {

    private final TranslatorViewModel translatorViewModel;

    public TranslatorView(TranslatorViewModel translatorViewModel) {
        this.translatorViewModel = translatorViewModel;
    }

    @FXML
    private TextArea textInput;

    @FXML
    private TextArea textOutput;

    @FXML
    private ComboBox<EncryptionType> comboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

}