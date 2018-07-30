package vn.shippo.demomywork.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.shippo.demomywork.model.MyWork;
import vn.shippo.demomywork.model.User;

import java.util.Optional;


public interface MyWorkService {

    Iterable<MyWork> findAll ();

    Optional<MyWork> findById (Long id);

    void save (MyWork myWork);

    void delete(Long id);

    boolean existName(String name);

    Iterable<MyWork> findAllByUser(User user);

    Page<MyWork> findAllByUser (User user, Pageable pageable);

}
