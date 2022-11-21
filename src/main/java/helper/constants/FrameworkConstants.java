package helper.constants;

public final class FrameworkConstants {
    private final static String PROPERTY_CONFIG_FILE_PATH=System.getProperty("user.dir")+"/src/main/resources/config.properties";

    public static String getPropertyConfigFilePath(){
        return PROPERTY_CONFIG_FILE_PATH;
    }
}
