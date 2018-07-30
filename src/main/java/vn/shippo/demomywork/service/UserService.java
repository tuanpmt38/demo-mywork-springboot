package vn.shippo.demomywork.service;

import vn.shippo.demomywork.model.User;



public interface UserService {

     User findUserByEmail(String email);

     void saveUser(User user);

     boolean existEmail(String email);


}
