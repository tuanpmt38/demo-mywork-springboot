package vn.shippo.demomywork.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.shippo.demomywork.model.MyWork;
import vn.shippo.demomywork.model.User;


@Repository
public interface MyWorkRepository extends PagingAndSortingRepository<MyWork, Long> {

    MyWork findByName (String name);

    Page<MyWork> findAllByUser(User user, Pageable pageable);

    Iterable<MyWork> findAllByUser(User user);

}
