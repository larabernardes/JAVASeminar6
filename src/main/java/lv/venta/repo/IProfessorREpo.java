package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Professor;

public interface IProfessorREpo extends CrudRepository<Professor, Long> {

}
