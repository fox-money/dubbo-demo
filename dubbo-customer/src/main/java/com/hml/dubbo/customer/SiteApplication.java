package com.hml.dubbo.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@ImportResource(locations = {"classpath:applicationContext.xml", "classpath:dubbo-customer.xml" })
@WebAppConfiguration
public class SiteApplication extends WebMvcConfigurerAdapter {

	private static Logger logger = LoggerFactory.getLogger(SiteApplication.class);

	 public static void main(String[] args) {
		    // -Dserver.port=$PORT 指定启动的 端口 右键 Run as 或 Debug as 的 Run Configuration
		    // 或 Debug Configuration 的Arguments 的 vm arguments可修改启动端口
		    // 可以这样加上 java -Dserver.port=8886 -Dprofile-name=real -Xms128m -Xmx128m -XX:PermSize=64m -Xss256k -XX:+DisableExplicitGC -XX:+UseParNewGC -XX:+UseCMSCompactAtFullCollection -XX:-CMSParallelRemarkEnabled -XX:+PrintGCTimeStamps -XX:+PrintGCDetails
	        SpringApplication app = new SpringApplication(SiteApplication.class);
	        app.setWebEnvironment(true);
	        //app.setShowBanner(false);
	        Set<Object> set = new HashSet<Object>();
	        //set.add("applicationContext.xml");
	        app.setSources(set);
	        app.run(args);

		    logger.info("SuccessStartOLQuanApplication");
		    logger.info("................");
	 }

}
