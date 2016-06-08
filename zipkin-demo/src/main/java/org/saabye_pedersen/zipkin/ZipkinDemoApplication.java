package org.saabye_pedersen.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
//@EnableZipkinStreamServer
@EnableZipkinServer
public class ZipkinDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDemoApplication.class, args);
	}
}
