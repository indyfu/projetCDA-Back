package projet3.maison.leloire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet3.maison.leloire.entity.RendezVous;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    @Query("SELECT r FROM RendezVous r WHERE r.user.id = :userId AND r.dateAnnulation IS NULL")
    List<RendezVous> findByUser(@Param("userId") Long userId);

    @Modifying
    @Query("UPDATE RendezVous r SET r.dateAnnulation = :dateAnnulation, r.motifAnnulation = :motifAnnulation WHERE r.id = :rendezVousId")
    void annulerRendezVous(@Param("rendezVousId") Long rendezVousId, @Param("dateAnnulation") LocalDateTime dateAnnulation, @Param("motifAnnulation") String motifAnnulation);

    @Query("SELECT COUNT(r) FROM RendezVous r WHERE r.status.id = 1")
    int rendezVousEnAttente();

    @Query("SELECT r FROM RendezVous r WHERE r.status.id = 1")
    List<RendezVous> findAllAwaitRdv();

    @Query("SELECT r FROM RendezVous r WHERE r.status.id = 1 OR r.status.id = 2 ")
    List<RendezVous> findAllRdv();

    @Query("SELECT r.dateDuRendezVous FROM RendezVous r WHERE FUNCTION('DATE', r.dateDuRendezVous) = :date")
    List<LocalDateTime> findOccupiedHoursByDate(@Param("date") LocalDate date);
}
