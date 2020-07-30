package cz.jpetrla.sfgpetclinic.repositories;

import cz.jpetrla.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
