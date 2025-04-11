package projet3.maison.leloire.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projet3.maison.leloire.entity.Dress;
import projet3.maison.leloire.entity.RendezVous;
import projet3.maison.leloire.entity.Role;
import projet3.maison.leloire.entity.RoleName;
import projet3.maison.leloire.entity.Status;
import projet3.maison.leloire.entity.StatusName;
import projet3.maison.leloire.entity.User;
import projet3.maison.leloire.entity.dto.RendezVousAddDto;
import projet3.maison.leloire.entity.dto.RendezVousAnnulationDto;
import projet3.maison.leloire.repository.DressRepository;
import projet3.maison.leloire.repository.RendezVousRepository;
import projet3.maison.leloire.repository.StatusRepository;
import projet3.maison.leloire.repository.UserRepository;
import projet3.maison.leloire.service.RdvService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RdvServiceImpl implements RdvService {

    private final RendezVousRepository rendezVousRepository;
    private final DressRepository dressRepository;
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public RdvServiceImpl(RendezVousRepository rendezVousRepository, DressRepository dressRepository, UserRepository userRepository, StatusRepository statusRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.dressRepository = dressRepository;
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public RendezVous saveRendezVous(RendezVousAddDto rendezVousAddDto) {
        // Récupérer l'utilisateur connecté depuis Spring Security
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // Chercher l'utilisateur en base de données à partir de son login
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        // Vérifier si la robe existe
        Dress dress = dressRepository.findById(rendezVousAddDto.getDressId())
                .orElseThrow(() -> new RuntimeException("Robe introuvable"));

        // Vérifier si le status EN_ATTENTE existe
        Status statusEnAttente = statusRepository.findByStatusName(StatusName.EN_ATTENTE)
                .orElseThrow(() -> new RuntimeException("Impossible de trouver le status"));

        // Créer un nouvel objet RendezVous
        RendezVous rendezVous = new RendezVous(
                rendezVousAddDto.getDate_du_rendez_vous(),
                rendezVousAddDto.getCommentaire(),
                user, // L'utilisateur authentifié est associé ici
                dress,
                statusEnAttente
        );

        // Sauvegarder le rendez-vous dans la base de données
        return rendezVousRepository.save(rendezVous);
    }
    @Override
    @Transactional
    @PreAuthorize("isAuthenticated()") //On vérifie que l'utilisateur est connecté
    public void annulerRendezVous(RendezVousAnnulationDto dto) {
        // Vérifier que le rendez-vous existe
        RendezVous rendezVous = rendezVousRepository.findById(dto.getRendezVousId())
                .orElseThrow(() -> new RuntimeException("Rendez-vous introuvable"));

        // Vérifier que l'utilisateur authentifié est bien le propriétaire du rendez-vous
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!rendezVous.getUser().getUsername().equals(username)) {
            throw new RuntimeException("Vous n'avez pas l'autorisation d'annuler ce rendez-vous");
        }

        // Mettre à jour l'annulation
        rendezVousRepository.annulerRendezVous(dto.getRendezVousId(), LocalDateTime.now(), dto.getMotifAnnulation());
    }

    @Override
    public List<RendezVous> findAllByUserId(Long id) {
        return rendezVousRepository.findByUser(id);
    }

    @Override
    public int rendezVousEnAttente() {
        return rendezVousRepository.rendezVousEnAttente();
    }

    @Override
    public List<RendezVous> findAllAwaitRdv() {
        return rendezVousRepository.findAllAwaitRdv();
    }

    @Override
    public List<RendezVous> findAllRdv() {
        return rendezVousRepository.findAllRdv();
    }

    @Override
    public List<LocalDateTime> getOccupiedHours(LocalDate date) {
        // Appel à la méthode du repository pour récupérer les heures réservées pour cette date
        return rendezVousRepository.findOccupiedHoursByDate(date);
    }


}
