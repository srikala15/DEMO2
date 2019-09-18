package anthem.Demo2.Controller;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import anthem.Demo2.Service.TestService;
import anthem.Demo2.model.StudentVO;

@RestController
public class TestController {
	private static final Logger logger = LogManager.getLogger(TestController.class);
	@Autowired
	TestService testService;

	@RequestMapping(value = "/storeDetailsToRedis", method = RequestMethod.GET)
	public ResponseEntity<Object> testing() {
		logger.info("Req came to controller:");
		HashMap<String, Object> hm = new HashMap<String, Object>();
		List<StudentVO> student = testService.getStudentDetails();

		hm.put("status", "sucess");
		hm.put("response", student);
		return new ResponseEntity<Object>(hm, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/saveStudentDetails", method = RequestMethod.POST)
	public ResponseEntity<Object> saveStudentDetails(@RequestBody StudentVO student) throws JsonProcessingException {
		logger.info("Req came to controller:");
		HashMap<String, Object> hm = new HashMap<String, Object>();
		boolean response = testService.saveStudentDetails(student);

		hm.put("status", "sucess");
		hm.put("response", response);
		return new ResponseEntity<Object>(hm, HttpStatus.OK);
	}
}
