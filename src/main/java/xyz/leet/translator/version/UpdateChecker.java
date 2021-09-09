package xyz.leet.translator.version;

import javafx.scene.control.Alert;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UpdateChecker {
    
    private static final String URL_LINK = "https://raw.githubusercontent.com/redaam/leet-translator/main/src/main/resources/xyz/leet/translator/version.txt?token=AL5WWYJ7EHRURRTI4QNB3JDBEYZXU";
    private File versionFile;
    
    private static void error(String msg) {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("AN ERROR OCCURRED");
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
    public UpdateChecker() {
        
        URL resource = getClass().getClassLoader().getResource("xyz/leet/translator/version.txt");
        
        if (resource == null) {
            
            error("JAR is corrupted. Please reinstall or try again");
            return;
        }
        
        instantiateVersionFile(resource);
    }
    
    public UpdateCheckerResult isUpdateAvailable() {
        
        HttpURLConnection connection = null;
        String currentVersion;
        String latestVersion;
        
        try {
            
            connection = (HttpURLConnection) new URL(URL_LINK).openConnection();
            connection.connect();
            
            currentVersion = Files.readString(Path.of(versionFile.toURI()));
            latestVersion = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
        } catch (Exception e) {
            
            error("Could not resolve connection to GitHub repository");
            return new UpdateCheckerResult(null, null, false);
        } finally {
            
            if (connection != null) connection.disconnect();
        }
        
        return new UpdateCheckerResult(latestVersion, currentVersion, !latestVersion.equals(currentVersion));
    }
    
    private void instantiateVersionFile(URL resource) {
        
        try {
            this.versionFile = Paths.get(resource.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    
}
