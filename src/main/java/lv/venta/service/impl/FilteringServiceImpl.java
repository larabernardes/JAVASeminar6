package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.repo.IGradeREpo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilteringService;

@Service
public class FilteringServiceImpl implements IFilteringService {
	
	@Autowired
	private IGradeREpo gradeRepo;
	
	@Autowired
	private IStudentRepo StudentRepo;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> calculateAVGGradeInCourseByID(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
