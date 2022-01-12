package xyz.leet.translator.version;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class UpdateChecker {
    
    private static final String URL_LINK = "https://raw.githubusercontent.com/Luziferium/leet-translator/main/src/main/resources/xyz/leet/translator/version.txt";
    
    private File versionFile;
    
    public UpdateChecker() {
        
        URL resource = getClass().getClassLoader().getResource("xyz/leet/translator/version/version.txt");
        
        if (resource == null) {
            error("JAR is corrupted. Please reinstall or try again");
            return;
        }
        
        instantiateVersionFile(resource);
    }
    
    public UpdateCheckerResult checkUpdate() {
        
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

    private void error(String msg) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("AN ERROR OCCURRED");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private Path fetchVersionFile(URI uri) throws IOException {
    
        Map<String, String> env = new HashMap<>();
        
        String[] array = uri.toString().split("!");
        FileSystem fs = FileSystems.newFileSystem(URI.create(array[0]), env);
    
        return fs.getPath(array[1]);
    }
    
    private void instantiateVersionFile(URL resource) {
        
        try {
            this.versionFile = new File(fetchVersionFile(resource.toURI()).toString());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
    
}
