//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hml.dubbo.log;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ItboysPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    public ItboysPropertyPlaceholderConfigurer() {
        String profile = System.getProperty("profile-name");
        String proName = StringUtils.isBlank(profile)?"classpath:/dev.properties":"classpath:/" + profile + ".properties";
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(proName);
        this.setLocation(resource);
    }
}