package com.hml.dubbo.log;

import ch.qos.logback.core.PropertyDefinerBase;
import org.apache.commons.lang.StringUtils;
import org.itboys.framework.resource.PropertiesUtils;

import java.io.IOException;
import java.util.Properties;


public class LogBackPathVariable extends PropertyDefinerBase {

    private static final String DEFAULT_LOG_PATH = "/var/log";

    @Override
    public String getPropertyValue() {
        String profile = System.getProperty("profile-name");
        String proName = StringUtils.isBlank(profile)?"classpath:/dev.properties":"classpath:/"+profile+".properties";
        try {
            Properties properties = PropertiesUtils.loadProperties(proName);
            String path = properties.getProperty("log.path");
            if (StringUtils.isBlank(path)) {
                path = DEFAULT_LOG_PATH;
            }
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return DEFAULT_LOG_PATH;
        }
    }
}
