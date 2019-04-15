package com.sh.graduate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.sh.graduate.util.IdWorker;
@SpringBootApplication
@EntityScan("com.sh.graduate.pojo")//扫描实体类
@ComponentScan(basePackages={"com.sh.api"})//扫描接口
@ComponentScan(basePackages={"com.sh.graduate"})//扫描本项目下的所有类
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
