package vn.shippo.demomywork.service;

import vn.shippo.demomywork.model.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
