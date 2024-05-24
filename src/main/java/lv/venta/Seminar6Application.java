package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeREpo;
import lv.venta.repo.IProfessorREpo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class Seminar6Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar6Application.class, args);
	}
	
	@Bean 
	public CommandLineRunner testDB(IStudentRepo stuRepo,
			IProfessorREpo profRepo, ICourseRepo courseRepo, IGradeREpo gradeRepo) {
		
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student s1 = new Student("John", "Green");
				Student s2 = new Student("Clair", "Smart");
				stuRepo.save(s1);
				stuRepo.save(s2);
				
				Professor p1 = new Professor("Karina", "Skirmante", Degree.ms);
				Professor p2 = new Professor("Vairis", "Caune", Degree.phd);
				profRepo.save(p1);
				profRepo.save(p2);
				
				Course c1 = new Course("Algorithm Theory", 2, p2);
				Course c2 = new Course("Java", 4, p1);
				courseRepo.save(c1);
				courseRepo.save(c2);
				
				Grade g1 = new Grade(3, s1, c1);
				Grade g2 = new Grade(6, s1, c2);
				Grade g3 = new Grade(10, s2, c1);
				Grade g4 = new Grade(7, s2, c2);
				gradeRepo.save(g1);
				gradeRepo.save(g2);
				gradeRepo.save(g3);
				gradeRepo.save(g4);
				
				
			}
		};
		
		
	}

}
