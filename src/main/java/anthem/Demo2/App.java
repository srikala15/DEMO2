package anthem.Demo2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import anthem.Demo2.Controller.TestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
	private static final Logger logger = LogManager.getLogger(TestController.class);
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		logger.info("Hello World!");

	}
}
