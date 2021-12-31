package xyz.leet.translator.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
import xyz.leet.translator.app.views.LoadingView;
import xyz.leet.translator.app.views.TranslatorView;
import xyz.leet.translator.app.views.TranslatorViewModel;
import xyz.leet.translator.translator.Translator;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;

/**
 * Central point of contact for loading, connecting and opening Views with its ViewModel.
 */
public class LeetController {
    
    private final Translator translator;
    private final Stage stage;
    
    public LeetController(Stage stage, Translator translator) {
        
        this.stage = stage;
        this.translator = translator;
    }
    
    public void showTranslatorView() {
        loadAndShowView(TranslatorView.class, (Class<?> param) -> new TranslatorView(new TranslatorViewModel(translator)), "Leet-Translator");
    }
    
    public void showLoadingView() {
        loadAndShowView(LoadingView.class, (Class<?> param) -> new LoadingView(), "Loading...");
    }
    
    public void closeLatestView() {
        stage.close();
    }
    
    private <T> void loadAndShowView(Class<T> clazz, Callback<Class<?>, Object> controllerFactory, String title) {
        
        Parent root = loadView(clazz, controllerFactory);
        Scene scene = new Scene(root);
        
        stage.getIcons().addAll(new Image("leet.png"));
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }
    
    private <T> Parent loadView(Class<T> clazz, Callback<Class<?>, Object> controllerFactory) {
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        
        URL fxmlLocation = clazz.getResource(clazz.getSimpleName() + ".fxml");
        
        fxmlLoader.setLocation(fxmlLocation);
        fxmlLoader.setControllerFactory(controllerFactory);
        
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new IllegalStateException(MessageFormat.format("FXML couldn't get loaded for class: ", clazz), e);
        }
    }
    
}
