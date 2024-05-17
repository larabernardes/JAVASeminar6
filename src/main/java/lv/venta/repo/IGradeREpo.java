package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeREpo extends CrudRepository<Grade, Long> {

}
