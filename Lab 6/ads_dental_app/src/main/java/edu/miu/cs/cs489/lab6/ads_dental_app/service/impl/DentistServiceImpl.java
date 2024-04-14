package edu.miu.cs.cs489.lab6.ads_dental_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Dentist;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.DentistRepository;
import edu.miu.cs.cs489.lab6.ads_dental_app.service.DentistService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    private DentistRepository dentistRepository;

    @Override
    public Dentist create(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Dentist read(Long id) {
        return dentistRepository.findById(id).get();
    }

    @Override
    public Dentist update(Long id, Dentist dentist) {
        Dentist dentistToUpdate = dentistRepository.findById(id).get();
        dentistToUpdate.setName(dentist.getName());
        dentistToUpdate.setSpecialization(dentist.getSpecialization());
        dentistToUpdate.setEmail(dentist.getEmail());
        dentistToUpdate.setPhone(dentist.getPhone());
        return dentistRepository.save(dentistToUpdate);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        dentistRepository.deleteById(id);
    }

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Autowired
    public void setDentistRepository(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }
}
