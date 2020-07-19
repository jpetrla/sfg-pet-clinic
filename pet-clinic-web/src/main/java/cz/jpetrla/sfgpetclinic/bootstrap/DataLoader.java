package cz.jpetrla.sfgpetclinic.bootstrap;

import cz.jpetrla.sfgpetclinic.model.Owner;
import cz.jpetrla.sfgpetclinic.model.Pet;
import cz.jpetrla.sfgpetclinic.model.PetType;
import cz.jpetrla.sfgpetclinic.model.Vet;
import cz.jpetrla.sfgpetclinic.services.OwnerService;
import cz.jpetrla.sfgpetclinic.services.PetTypeService;
import cz.jpetrla.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("White");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
