package com.hml.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication //相当于 @Configuration、@EnableAutoConfiguration 、 @ComponentScan 三个的作用
@ComponentScan(basePackages = {"com.hml.dubbo.provider"}, includeFilters = {@ComponentScan.Filter(classes = { Service.class}) })//扫描路径
@ImportResource(locations = { "classpath:dubbo-provider.xml" })//是引入spring配置文件.xml
//@MapperScan("cn.itboys.member.mapper")
@WebAppConfiguration //注解在类上,用来声明加载的ApplicationContex 是一个WebApplicationContext ,它的属性指定的是Web资源的位置,默认为 src/main/webapp ,自定义修改为 resource
//@EnableAutoConfiguration// 会在你开启某些功能的时候自动配置
//		，这个注解告诉Spring Boot根据添加的jar依赖猜测你想如何配置Spring。
//		由于spring-boot-starter-web添加了Tomcat和Spring MVC，所以auto-configuration将假定你正在开发一个web应用，并对Spring进行相应地设置。
//@Configuration//表示这个类中定义了bean,将bean加入到spring容器中去
public class ProviderApplication extends WebMvcConfigurerAdapter {

	private static Logger logger = LoggerFactory.getLogger(ProviderApplication.class);

	 public static void main(String[] args) {
		    // -Dserver.port=$PORT 指定启动的 端口 右键 Run as 或 Debug as 的 Run Configuration
		    // 或 Debug Configuration 的Arguments 的 vm arguments可修改启动端口
		    // 可以这样加上 java -Dserver.port=8886 -Dprofile-name=real -Xms128m -Xmx128m -XX:PermSize=64m -Xss256k -XX:+DisableExplicitGC -XX:+UseParNewGC -XX:+UseCMSCompactAtFullCollection -XX:-CMSParallelRemarkEnabled -XX:+PrintGCTimeStamps -XX:+PrintGCDetails
	        SpringApplication app = new SpringApplication(ProviderApplication.class);
	        app.setWebEnvironment(true);
	        //app.setShowBanner(false);
	        Set<Object> set = new HashSet<Object>();
	        set.add("applicationContext.xml");
	        app.setSources(set);
	        app.run(args);

		    logger.info("SuccessStartApplication");
		    logger.info("................");
	 }

}
