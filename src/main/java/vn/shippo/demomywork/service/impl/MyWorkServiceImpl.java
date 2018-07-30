package vn.shippo.demomywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.shippo.demomywork.model.MyWork;
import vn.shippo.demomywork.model.User;
import vn.shippo.demomywork.repository.MyWorkRepository;
import vn.shippo.demomywork.service.MyWorkService;

import java.util.Optional;


@Service
@Transactional
public class MyWorkServiceImpl implements MyWorkService {

    private MyWorkRepository myWorkRepository;

    @Autowired
    public MyWorkServiceImpl(MyWorkRepository myWorkRepository){
        this.myWorkRepository = myWorkRepository;
    }

    @Override
    public Iterable <MyWork> findAll() {
        return myWorkRepository.findAll();
    }

    @Override
    public Optional<MyWork> findById(Long id) {
        return myWorkRepository.findById(id);
    }

    @Override
    public void save(MyWork myWork) {
        myWorkRepository.save(myWork);
    }

    @Override
    public void delete(Long id) {
        myWorkRepository.deleteById(id);
    }

    @Override
    public boolean existName(String name) {
        MyWork myWork = myWorkRepository.findByName(name);
        return (myWork !=null);
    }

    @Override
    public Iterable<MyWork> findAllByUser(User user) {
        return myWorkRepository.findAllByUser(user);
    }

    @Override
    public Page<MyWork> findAllByUser(User user, Pageable pageable) {
        return myWorkRepository.findAllByUser(user, pageable);
    }


}
