package vn.shippo.demomywork.service;


import vn.shippo.demomywork.model.User;

public interface UserService {

    User findByEmail(String email);

    void saveUser (User user);

}
