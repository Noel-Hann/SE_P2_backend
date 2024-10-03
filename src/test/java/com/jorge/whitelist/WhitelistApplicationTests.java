package com.jorge.whitelist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import src/main/java/com/jorge/whitelist/WhitelistApplication.java;

@SpringBootTest
class WhitelistApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testAddUser() {
	    User user = new User("Test user", "1234")
	    WhitelistApplication.addUser(user);
	}

}
