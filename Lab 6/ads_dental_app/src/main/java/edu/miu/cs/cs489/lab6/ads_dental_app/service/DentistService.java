package edu.miu.cs.cs489.lab6.ads_dental_app.service;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Dentist;

import java.util.List;

public interface DentistService {

    public Dentist create(Dentist dentist);

    public Dentist read(Long id);

    public Dentist update(Long id, Dentist dentist);

    public void delete(Long id);

    public List<Dentist> getAllDentists();

}
