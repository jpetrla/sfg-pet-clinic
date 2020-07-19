package cz.jpetrla.sfgpetclinic.bootstrap;

import cz.jpetrla.sfgpetclinic.model.*;
import cz.jpetrla.sfgpetclinic.services.OwnerService;
import cz.jpetrla.sfgpetclinic.services.PetTypeService;
import cz.jpetrla.sfgpetclinic.services.SpecialityService;
import cz.jpetrla.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jan");
        owner1.setLastName("Petrla");
        owner1.setAddress("Ulice 1");
        owner1.setCity("Prague");
        owner1.setTelephone("777614903");

        Pet jansPet = new Pet();
        jansPet.setPetType(savedDogPetType);
        jansPet.setOwner(owner1);
        jansPet.setBirthDay(LocalDate.now());
        jansPet.setName("Masa");
        owner1.getPets().add(jansPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jack");
        owner2.setLastName("Master");
        owner2.setAddress("Ulice 1");
        owner2.setCity("Prague");
        owner2.setTelephone("777614903");

        Pet jacksPet = new Pet();
        jacksPet.setPetType(savedCatPetType);
        jacksPet.setOwner(owner2);
        jacksPet.setBirthDay(LocalDate.now());
        jacksPet.setName("Eliska");
        owner2.getPets().add(jacksPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Alex");
        vet1.setLastName("Black");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("White");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
