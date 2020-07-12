package cz.jpetrla.sfgpetclinic.services;

import cz.jpetrla.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
