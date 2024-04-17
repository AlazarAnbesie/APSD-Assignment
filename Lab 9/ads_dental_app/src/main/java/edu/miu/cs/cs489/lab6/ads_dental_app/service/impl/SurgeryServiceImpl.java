package edu.miu.cs.cs489.lab6.ads_dental_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Surgery;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.SurgeryRepository;
import edu.miu.cs.cs489.lab6.ads_dental_app.service.SurgeryService;
import lombok.RequiredArgsConstructor;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    SurgeryRepository surgeryRepository;

    @Override
    public Surgery create(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public Surgery read(Long id) {
        return surgeryRepository.findById(id).get();
    }

    @Override
    public Surgery update(Long id, Surgery surgery) {
        Surgery surgeryToUpdate = surgeryRepository.findById(id).get();
        surgeryToUpdate.setName(surgery.getName());
        surgeryToUpdate.setLocation(surgery.getLocation());
        surgeryToUpdate.setPhone(surgery.getPhone());
        return surgeryRepository.save(surgeryToUpdate);
    }

    @Override
    public void delete(Long id) {
        surgeryRepository.deleteById(id);
    }

    @Autowired
    public void setSurgeryRepository(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }
}