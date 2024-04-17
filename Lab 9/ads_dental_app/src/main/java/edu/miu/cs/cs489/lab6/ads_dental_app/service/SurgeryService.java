package edu.miu.cs.cs489.lab6.ads_dental_app.service;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Surgery;

public interface SurgeryService {
    public Surgery create(Surgery surgery);

    public Surgery read(Long id);

    public Surgery update(Long id, Surgery surgery);

    public void delete(Long id);
}
