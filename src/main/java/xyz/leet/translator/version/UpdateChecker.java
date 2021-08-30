package xyz.leet.translator.version;

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

    public UpdateChecker() {

        URL resource = getClass().getClassLoader().getResource("version.txt");

        if(resource == null) {

            try {
                throw new FileNotFoundException("Either the File got deleted or the repo is not public.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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

            e.printStackTrace();
            return new UpdateCheckerResult(null, null, false);
        } finally {

            if(connection != null)
                connection.disconnect();
        }

        return new UpdateCheckerResult(currentVersion, latestVersion, !latestVersion.equals(currentVersion));
    }

    private void instantiateVersionFile(URL resource) {

        try {
            this.versionFile = Paths.get(resource.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
