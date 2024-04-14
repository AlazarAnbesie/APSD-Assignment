package edu.miu.cs.cs489.lab6.ads_dental_app.service;

import org.springframework.stereotype.Repository;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.User;

import java.util.List;

@Repository
public interface UserService {

    public User create(User user);

    public User read(Long id);

    public User update(Long id, User user);

    public void delete(Long id);

    public List<User> getAllUsers();

}
