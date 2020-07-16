package cz.jpetrla.sfgpetclinic.bootstrap;

import cz.jpetrla.sfgpetclinic.model.Owner;
import cz.jpetrla.sfgpetclinic.model.Vet;
import cz.jpetrla.sfgpetclinic.services.OwnerService;
import cz.jpetrla.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Jan");
        owner1.setLastName("Petrla");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jack");
        owner2.setLastName("Master");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Alex");
        vet1.setLastName("Black");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("John");
        vet2.setLastName("White");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
