package vn.shippo.demomywork.repository;

import org.springframework.data.repository.CrudRepository;
import vn.shippo.demomywork.model.Role;


public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);

}
