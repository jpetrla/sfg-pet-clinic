package cz.jpetrla.sfgpetclinic.repositories;

import cz.jpetrla.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}