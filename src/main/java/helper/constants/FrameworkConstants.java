package helper.constants;

import helper.enums.ConfigProperties;
import helper.utils.PropertyUtils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class FrameworkConstants {
    private final static String PROPERTY_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/config.properties";
    private final static String DATA_PATH=System.getProperty("user.dir")+"/src/main/resources/data.xlsx";
    private final static int EXPLICIT_WAIT = 15;
    private final static int PAGE_LOAD_TIME = 10;
    private final static int IMPLICIT_WAIT = 15;
    private final static int EXPLICIT_MILLI_SEC_WAIT = 150;


    public static String getPropertyConfigFilePath() {
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

    public static String getExtentReportOutput() {
        if (PropertyUtils.getValue(ConfigProperties.OVER_RIDE_REPORT).equals("yes")) {
            Format formatter = new SimpleDateFormat("YY_MM_dd_HH_mm_ss");
            Date date = new Date(System.currentTimeMillis());
            return "outputs/" + formatter.format(date) + "_report.html";
        } else {
            return "outputs/report.html";
        }
    }

    public static String getDataPath() {
        return DATA_PATH;
    }
}