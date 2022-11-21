package helper.utils;

import helper.constants.FrameworkConstants;
import helper.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtils {
    private PropertyUtils(){}
    private static HashMap<String,String>CONFIGMAP;
    private static FileInputStream fis;
    private static Properties pro;

    static{
        try {
            fis=new FileInputStream(FrameworkConstants.getPropertyConfigFilePath());
            pro=new Properties();
            pro.load(fis);
            CONFIGMAP=new HashMap<>();
            for(Object key: pro.keySet()){
                CONFIGMAP.put(String.valueOf(key),String.valueOf(pro.get(key)));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static String getValue(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            try {
                throw new Exception("Property name " + key + " is not found");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }  return CONFIGMAP.get(key.name().toLowerCase());
    }


}
