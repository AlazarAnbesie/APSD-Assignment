package edu.miu.cs.cs489.lab6.ads_dental_app.repository;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Role;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT r FROM Role r WHERE r.roleType = ?1")
    Optional<Role> findRoleByRoleType(RoleType roleType);

    // List of roles by patient id
    @Query("SELECT r FROM Role r JOIN r.user u WHERE u.id = ?1")
    Optional<List<Role>> findRolesByUserId(Long userId);

}
