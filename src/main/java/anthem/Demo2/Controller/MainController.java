package anthem.Demo2.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/")
	public String testingbitbucket() {
		return "it's working!!!";
	}
}
