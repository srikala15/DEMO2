package anthem.Demo2.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import anthem.Demo2.model.StudentVO;
import redis.clients.jedis.Jedis;

@Service
public class TestServiceImpl implements TestService {
	private static final Logger logger = LogManager.getLogger(TestServiceImpl.class);
	Jedis jedis = new Jedis();

	public List<StudentVO> getStudentDetails() {
		List<StudentVO> students = new ArrayList<StudentVO>();
		StudentVO student1 = new StudentVO();
		student1.setIid(1);
		student1.setlMarks(100);
		student1.setsEmail("dummy@gmail.com");
		student1.setsName("sri");

		StudentVO student2 = new StudentVO();
		student2.setIid(1);
		student2.setlMarks(100);
		student2.setsEmail("dummy@gmail.com");
		student2.setsName("kala");

		students.add(student1);
		students.add(student2);
		try {
		
		jedis.append("s1", student1.toString());
		jedis.append("s2", student2.toString());
		}catch(Exception e) {
			logger.error("Getting Exception while stroing Data into Redis Database!!");
		}
		
		
		logger.info("Retrieving data from redis"+ jedis.get("s1").toString());
		return students;
	}

	@Override
	public boolean saveStudentDetails(StudentVO student) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(student);
		jedis.append(student.getsName(), json);
		
		
		
		return false;
	}

}
