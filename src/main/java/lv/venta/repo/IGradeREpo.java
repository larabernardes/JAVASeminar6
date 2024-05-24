package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeREpo extends CrudRepository<Grade, Long> {

	ArrayList<Grade> findByGrvalueLessThan(int i);

	ArrayList<Grade> findByStudentIds(long id);

}
