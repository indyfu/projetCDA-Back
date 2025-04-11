package projet3.maison.leloire.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet3.maison.leloire.entity.Status;
import projet3.maison.leloire.entity.StatusName;

import java.util.Optional;


public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByStatusName(StatusName statusName);

}
