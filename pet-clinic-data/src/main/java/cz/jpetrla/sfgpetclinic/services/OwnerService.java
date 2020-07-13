package cz.jpetrla.sfgpetclinic.services;

import cz.jpetrla.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
