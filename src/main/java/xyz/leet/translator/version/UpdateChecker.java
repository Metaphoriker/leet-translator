package xyz.leet.translator.version;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {
    
    private static final String URL_LINK = "https://raw.githubusercontent.com/Luziferium/leet-translator/main/src/main/resources/xyz/leet/translator/version/version.txt";
    
    private final String version;
    
    public UpdateChecker() {
        
        InputStream resource = getClass().getClassLoader().getResourceAsStream("xyz/leet/translator/version/version.txt");
    
        if (resource == null)
            error("JAR is corrupted. Please reinstall or try again");
    
        this.version = fetchVersion(resource);
    }
    
    public UpdateCheckerResult checkUpdate() {
    
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(URL_LINK).openConnection();
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String latestVersion;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            latestVersion = bufferedReader.readLine();
        } catch (Exception e) {
            error("Could not resolve connection to GitHub repository");
            return new UpdateCheckerResult(null, null, false);
        }
        
        return new UpdateCheckerResult(latestVersion, this.version, !latestVersion.equals(this.version));
    }

    private void error(String msg) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("AN ERROR OCCURRED");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private String fetchVersion(InputStream inputStream) {
        
        if(inputStream == null)
            return ""; // avoid exceptions
        
        byte[] data = new byte[0];
        try (InputStream in = inputStream) {
            data = in.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return new String(data);
    }
    
}
