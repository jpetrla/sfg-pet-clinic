package cz.jpetrla.sfgpetclinic.services.springdatajpa;

import cz.jpetrla.sfgpetclinic.model.Owner;
import cz.jpetrla.sfgpetclinic.repositories.OwnerRepository;
import cz.jpetrla.sfgpetclinic.repositories.PetRepository;
import cz.jpetrla.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    public static final String LAST_NAME_PETRLA = "Petrla";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME_PETRLA).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = service.findByLastName(LAST_NAME_PETRLA);

        assertEquals(LAST_NAME_PETRLA, owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(Owner.builder().id(1L).build());
        returnOwners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwners);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(returnOwners.size(), owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}