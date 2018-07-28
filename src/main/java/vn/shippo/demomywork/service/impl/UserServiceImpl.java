package vn.shippo.demomywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.shippo.demomywork.model.Role;
import vn.shippo.demomywork.model.User;
import vn.shippo.demomywork.repository.RoleRepository;
import vn.shippo.demomywork.repository.UserRepository;
import vn.shippo.demomywork.service.UserService;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
//        this.userRepository =userRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
