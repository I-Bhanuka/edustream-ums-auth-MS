package com.example.edustream_ums_auth_MS;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.example.edustream_ums_auth_MS",
				"com.example.edustream_lib_common",
				"com.example.edustream_lib_security",
		})
@Slf4j
public class EdustreamUmsAuthMsApplication implements CommandLineRunner {

	@Value("${server.port}")
	private int port;

	public static void main(String[] args) {
		SpringApplication.run(EdustreamUmsAuthMsApplication.class, args);
	}

	// To run some code after the application starts.
	@Override
	public void run(String... args) throws Exception {
		log.info("EduStream Auth Microservice started");
		log.info("Auth Microservice is running at http://localhost:{}", port);

	}

}
