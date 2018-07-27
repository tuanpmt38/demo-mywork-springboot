package vn.shippo.demomywork.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.shippo.demomywork.model.MyWork;

@Repository
public interface MyWorkRepository extends PagingAndSortingRepository<MyWork, Long> {

    MyWork findByName (String name);
}
