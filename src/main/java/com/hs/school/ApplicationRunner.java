package com.hs.school;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 启动类
 * @author duyashuo
 */
@SpringBootApplication
public class ApplicationRunner {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ApplicationRunner.class).web(WebApplicationType.SERVLET).run(args);
	}
}
