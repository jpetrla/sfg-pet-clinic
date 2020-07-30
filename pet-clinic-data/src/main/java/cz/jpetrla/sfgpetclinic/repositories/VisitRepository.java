package cz.jpetrla.sfgpetclinic.repositories;

import cz.jpetrla.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
