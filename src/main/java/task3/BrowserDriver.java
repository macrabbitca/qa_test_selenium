package task3;

/**
 * Browser driver path.
 */
public enum BrowserDriver {
    /**
     * chrome driver local path
     */
    CHROME("src/main/resources/driver/chromedriver"),

    /**
     * firefox driver local path
     */
    FIREFOX("src/main/resources/driver/geckodriver"),

    /**
     * safari driver local path
     */
    SAFARI(""),

    /**
     * ie driver local path
     */
    IE(""),

    /**
     * edge driver local path
     */
    EDGE("");

    private final String path;

    BrowserDriver(String path) {
        this.path = path;
    }


    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Browser{" + "path='" + path + '\'' + '}';
    }
}
