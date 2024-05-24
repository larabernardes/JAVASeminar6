package lv.venta.service;

import lv.venta.model.Course;

import java.util.ArrayList;

import lv.venta.model.Grade;

public interface IFilteringService {
/*
selectGradesByStudent() - return all grades of specific student;
○ selectCoursesByStudent() - return all courses where specific student is
involved;
○ selectCoursesByProfessor() - return all courses of specific professor;
○ calculateAVGGradeInCourse() - return average grade in specific course;

 */
	public abstract ArrayList<Grade> selectFailedGradesInSystem()throws Exception; 
	
	public abstract ArrayList<Grade> selectGradesByStudentId(int id)throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByStudentId(int id)throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByProfessorId(int id)throws Exception;
	
	public abstract ArrayList<Course> calculateAVGGradeInCourseByID(int id)throws Exception;	
	
	
}
