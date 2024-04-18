package edu.miu.cs.cs489.lab6.ads_dental_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.User;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.UserRepository;
import edu.miu.cs.cs489.lab6.ads_dental_app.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User read(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhone(user.getPhone());
        return userRepository.save(userToUpdate);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
