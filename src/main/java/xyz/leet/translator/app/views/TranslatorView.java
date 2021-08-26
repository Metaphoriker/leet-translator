package xyz.leet.translator.app.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import xyz.leet.translator.enums.EncryptionType;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class TranslatorView implements Initializable {

    private final TranslatorViewModel translatorViewModel;

    public TranslatorView(TranslatorViewModel translatorViewModel) {
        this.translatorViewModel = translatorViewModel;
    }

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @FXML
    private ComboBox<EncryptionType> comboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textArea.setEditable(false);
        comboBox.setValue(EncryptionType.LEET_LEVEL_1);
        comboBox.setItems(encryptionTypeList());
    }

    @FXML
    public void onButtonPress(ActionEvent actionEvent) {
        textArea.setText(translatorViewModel.translate(textField.getText(), comboBox.getValue()));
    }

    private ObservableList<EncryptionType> encryptionTypeList() {

        List<EncryptionType> list = new ArrayList<>();
        Collections.addAll(list, EncryptionType.values());

        return FXCollections.observableArrayList(list);
    }

}
