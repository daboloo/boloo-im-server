package com.grady.fim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhongjinHacker
 */
@SpringBootApplication
@MapperScan("com.grady.fim.mapper")
public class FimApplication {

	public static void main(String[] args) {
		SpringApplication.run(FimApplication.class, args);
	}

}
