package cz.jpetrla.sfgpetclinic.repositories;

import cz.jpetrla.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
