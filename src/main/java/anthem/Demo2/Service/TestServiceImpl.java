package anthem.Demo2.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import anthem.Demo2.model.StudentListVO;
import anthem.Demo2.model.StudentVO;

@Service
public class TestServiceImpl implements TestService{

	public List<StudentVO> getStudentDetails() {
//		StudentListVO students=new StudentListVO();
	List<StudentVO> students=new ArrayList();
		StudentVO student1=new StudentVO();
		student1.setIid(1);
		student1.setlMarks(100);
		student1.setsEmail("dummy@gmail.com");
		student1.setsName("sri");
		
		StudentVO student2=new StudentVO();
		student2.setIid(1);
		student2.setlMarks(100);
		student2.setsEmail("dummy@gmail.com");
		student2.setsName("sri");
		
		students.add(student1);
		students.add(student2);

		return students;
	}

}
