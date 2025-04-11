package projet3.maison.leloire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projet3.maison.leloire.entity.Mensuration;

public interface MensurationRepository extends JpaRepository<Mensuration, Long> {
}
