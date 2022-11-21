package helper.constants;

public final class FrameworkConstants {
    private final static String PROPERTY_CONFIG_FILE_PATH=System.getProperty("user.dir")+"/src/main/resources/config.properties";
    private final static int EXPLICIT_WAIT=15;
    private final static int PAGE_LOAD_TIME=10;
    private final static int IMPLICIT_WAIT=15;
    private final static int EXPLICIT_MILLI_SEC_WAIT=150;

    public static String getPropertyConfigFilePath(){
        return PROPERTY_CONFIG_FILE_PATH;
    }

    public static int getExplicitMilliSecWait() {
        return EXPLICIT_MILLI_SEC_WAIT;
    }

    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }

    public static int getImplicitWait() {
        return IMPLICIT_WAIT;
    }

    public static int getPageLoadTime() {
        return PAGE_LOAD_TIME;
    }
}
