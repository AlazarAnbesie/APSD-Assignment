package edu.miu.cs.cs489.lab6.ads_dental_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
