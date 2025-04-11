package projet3.maison.leloire.service;

import projet3.maison.leloire.entity.RendezVous;
import projet3.maison.leloire.entity.dto.RendezVousAddDto;
import projet3.maison.leloire.entity.dto.RendezVousAnnulationDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RdvService {

    RendezVous saveRendezVous(RendezVousAddDto rendezVousAddDto);
    void annulerRendezVous(RendezVousAnnulationDto annulationDto);
    int rendezVousEnAttente();
    List<RendezVous> findAllAwaitRdv();
    List<RendezVous> findAllRdv();
    List<RendezVous> findAllByUserId(Long id);
    List<LocalDateTime> getOccupiedHours(LocalDate date);
}
