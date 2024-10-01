package com.jorge.whitelist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class WhitelistApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhitelistApplication.class, args);
	}

	@RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello World!";
    }

}
