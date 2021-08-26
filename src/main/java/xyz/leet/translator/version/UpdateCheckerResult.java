package xyz.leet.translator.version;

public record UpdateCheckerResult(String newVersion, String oldVersion, boolean updateAvailable) {

}
