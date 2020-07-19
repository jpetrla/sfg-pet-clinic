package cz.jpetrla.sfgpetclinic.services.map;

import cz.jpetrla.sfgpetclinic.model.PetType;
import cz.jpetrla.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        super.delete(petType);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
