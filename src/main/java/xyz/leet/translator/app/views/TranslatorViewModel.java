package xyz.leet.translator.app.views;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import xyz.leet.translator.enums.EncryptionType;
import xyz.leet.translator.translator.Translator;

public class TranslatorViewModel {
    
    private final StringProperty toTranslateProperty = new SimpleStringProperty();
    private final StringProperty outputProperty = new SimpleStringProperty();
    private final Property<EncryptionType> encryptionTypeProperty = new SimpleObjectProperty<>();
    
    private final Translator translator;
    
    public TranslatorViewModel(Translator translator) {
        this.translator = translator;
    }
    
    public void translate() {
        
        if (encryptionTypeProperty.getValue() == EncryptionType.DECODE)
            outputProperty.setValue(translator.translate(toTranslateProperty.get()));
        else
            outputProperty.setValue(translator.translate(toTranslateProperty.get(), encryptionTypeProperty.getValue()));
    }
    
    public StringProperty getToTranslateProperty() {
        return toTranslateProperty;
    }
    
    public StringProperty getOutputProperty() {
        return outputProperty;
    }
    
    public Property<EncryptionType> getEncryptionTypeProperty() {
        return encryptionTypeProperty;
    }
}
