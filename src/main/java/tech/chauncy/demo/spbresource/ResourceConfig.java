package tech.chauncy.demo.spbresource;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:prop.properties")
public class ResourceConfig {

	@Value("https://camera-alexa-skills-us.xiaoyi.com/PrivacyPolicy.html")
	private Resource url;
	@Value("classpath:test.txt")
	private Resource file;
	@Value("${sample.date}")
	private String date;
	
	@Autowired
	private Environment env;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
		return new PropertySourcesPlaceholderConfigurer();
	}

	public  void printResource(){
		try {
			System.out.println(IOUtils.toString(url.getInputStream()));
			System.out.println(IOUtils.toString(file.getInputStream()));
			System.out.println(date);
			System.out.println(env.getProperty("sample.total"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
