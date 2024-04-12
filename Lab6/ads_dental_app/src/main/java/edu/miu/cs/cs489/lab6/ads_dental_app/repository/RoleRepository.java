package edu.miu.cs.cs489.lab6.ads_dental_app.repository;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
