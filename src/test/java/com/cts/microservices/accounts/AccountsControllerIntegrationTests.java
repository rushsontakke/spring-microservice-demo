package com.cts.microservices.accounts;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.microservices.accounts.AccountsConfiguration;
import com.cts.microservices.services.accounts.AccountsServer;

/**
 * Imitates the {@link AccountsServer}, but without using any of the discovery
 * client code. Allows the test to use the same configuration as the
 * <code>AccountsServer</code> would.
 * 
 */
@SpringBootApplication
@Import(AccountsConfiguration.class)
class AccountsMain {
	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		System.setProperty("spring.config.name", "accounts-server");
		SpringApplication.run(AccountsMain.class, args);
	}
}

/**
 * Spring Integration/System test - by using @SpringApplicationConfiguration
 * instead of @ContextConfiguration, it picks up the same configuration that
 * Spring Boot would use.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AccountsMain.class)
public class AccountsControllerIntegrationTests extends AbstractAccountControllerTests {

}
