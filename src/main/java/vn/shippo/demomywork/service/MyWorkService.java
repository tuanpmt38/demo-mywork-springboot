package vn.shippo.demomywork.service;

import vn.shippo.demomywork.model.MyWork;

import java.util.Optional;


public interface MyWorkService {

    Iterable<MyWork> findAll ();

    Optional<MyWork> findById (Long id);

    void save (MyWork myWork);

    void delete(Long id);

    boolean existName(String name);
}
