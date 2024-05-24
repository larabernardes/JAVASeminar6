package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeREpo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilteringService;

@Service
public class FilteringServiceImpl implements IFilteringService {
	
	@Autowired
	private IGradeREpo gradeRepo;
	
	@Autowired
	private IStudentRepo StudentRepo;
	
	@Autowired
	private ICourseRepo CourseRepo;

	@Override
	public ArrayList<Grade> selectFailedGradesInSystem() throws Exception {
		ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);
		
		if(result.isEmpty()) throw new Exception("There is no failed grade in the System");
		
		return result;
	}

	@Override
	public ArrayList<Grade> selectGradesByStudentId(long id) throws Exception {
		if(id < 1) throw new Exception("Id should be positive");
		
		if(!StudentRepo.existsById(id)) throw new Exception("Student with id (" + id + ") is not in the system");
		
		ArrayList<Grade> result = gradeRepo.findByStudentIds(id);
		
		if(result.isEmpty()) throw new Exception("Student with id (" + id + ") does not have any grades");
		
		return null;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(long id) throws Exception {
		if(id < 1) throw new Exception("Id should be positive");
		
		if(!StudentRepo.existsById(id)) throw new Exception("Student with id (" + id + ") is not in the system");
		

		ArrayList<Course> result = CourseRepo.findByGradesStudentIds(id);
		
		if(result.isEmpty()) throw new Exception("Professor with id (" + id + ") does not have any courses");
		
		
		
		return null;
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
		if(id < 1) throw new Exception("Id should be positive");
		
		if(!CourseRepo.existsById(id)) throw new Exception("Course with id (" + id + ") is not in the system");
		
		ArrayList<Course> result = CourseRepo.findByProfessorIdp(id);
		
		if(result.isEmpty()) throw new Exception("Professor with id (" + id + ") does not have any courses");
		
		return result;
		
	}

	@Override
	public float calculateAVGGradeInCourseByID(long id) throws Exception {
		if(id < 1) throw new Exception("Id should be positive");
		
		if(!CourseRepo.existsById(id)) throw new Exception("Course with id (" + id + ") is not in the system");
		
		float result = gradeRepo.calculateAVGGrade_MyFunction(id);
		
		if(result == 0) throw new Exception("There is no grade in this course");
		
		return result;
	}

}
