package anthem.Demo2.Service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import anthem.Demo2.model.StudentVO;

public interface TestService {

	List<StudentVO> getStudentDetails();

	boolean saveStudentDetails(StudentVO student) throws JsonProcessingException;

}
