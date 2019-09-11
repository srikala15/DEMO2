package anthem.Demo2.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import anthem.Demo2.Service.TestService;
import anthem.Demo2.model.StudentVO;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/testing",method=RequestMethod.GET)
	public ResponseEntity<Object> testing() {
		HashMap<String,Object> hm=new HashMap<String,Object>();
		
	List<StudentVO> student=	testService.getStudentDetails();
		
		hm.put("status", "success");
		hm.put("response", student);
		
		   return new ResponseEntity<Object>(hm, HttpStatus.OK);
	}
}
