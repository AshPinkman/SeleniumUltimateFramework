package utils;

import enums.EnvType;
import exceptions.InvalidEnvironmentException;
import exceptions.InvalidPropertyException;

import java.util.Objects;
import java.util.Properties;

public class ConfigLoader {

    private Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        String env = System.getProperty("env", EnvType.QA.name());
        switch (EnvType.valueOf(env)){
            case DEV :
                properties = PropertyUtil.propertyLoader("src/test/resources/config/config-dev.properties");
                break;
            case QA:
                properties = PropertyUtil.propertyLoader("src/test/resources/config/config-qa.properties");
                break;
            case UAT:
                properties = PropertyUtil.propertyLoader("src/test/resources/config/config-uat.properties");
                break;
            case STAGE:
                properties = PropertyUtil.propertyLoader("src/test/resources/config/config-stage.properties");
                break;
            case PROD:
                properties = PropertyUtil.propertyLoader("src/test/resources/config/config-prod.properties");
                break;
            default:
                throw new InvalidEnvironmentException("Please enter proper environment type");
        }

    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }


    public String get(String key){
        if(Objects.isNull(key) || Objects.isNull(properties.get(key.toLowerCase().trim()))){
            throw new InvalidPropertyException("Please enter valid property");
        }
        return String.valueOf(properties.get(key.toLowerCase().trim()));
    }
}
