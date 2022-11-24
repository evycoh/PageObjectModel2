package helper.utils;

public final class DynamicXpathUtils {

    public static String getXpath(String xpath,String value){
        String t=xpath.replace("%value%",value);
        return t;
    }

}
