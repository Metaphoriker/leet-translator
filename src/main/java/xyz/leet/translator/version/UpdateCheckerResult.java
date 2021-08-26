package xyz.leet.translator.version;

public class UpdateCheckerResult {

    public final boolean updateAvailable;
    public final String oldVersion;
    public final String newVersion;

    public UpdateCheckerResult(String newVersion, String oldVersion, boolean updateAvailable) {

        this.updateAvailable = updateAvailable;
        this.oldVersion = oldVersion;
        this.newVersion = newVersion;
    }

}
