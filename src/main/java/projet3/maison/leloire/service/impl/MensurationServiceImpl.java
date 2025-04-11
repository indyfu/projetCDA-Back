package projet3.maison.leloire.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet3.maison.leloire.entity.Mensuration;
import projet3.maison.leloire.entity.RendezVous;
import projet3.maison.leloire.entity.dto.MensurationDto;
import projet3.maison.leloire.repository.MensurationRepository;
import projet3.maison.leloire.repository.RendezVousRepository;
import projet3.maison.leloire.service.MensurationService;

import java.util.Optional;


@Service
public class MensurationServiceImpl implements MensurationService {
    private final MensurationRepository mensurationRepository;
    private RendezVousRepository rendezVousRepository;

    @Autowired
    public MensurationServiceImpl(MensurationRepository mensurationRepository, RendezVousRepository rendezVousRepository) {
        this.mensurationRepository = mensurationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Transactional
    @Override
    public Mensuration saveMensuration(MensurationDto mensurationDto) {
        
            Mensuration mensuration = new Mensuration(
           mensurationDto.getLongueurTailleDos(),
            mensurationDto.getLongueurTailleDevant(),
            mensurationDto.getTourPoitrine(),
            mensurationDto.getHauteurPoitrine(),
            mensurationDto.getDemiEcartPoitrine(),
            mensurationDto.getTourTaille(),
            mensurationDto.getTourPetiteHanche(),
            mensurationDto.getTourGrandeHanche(),
            mensurationDto.getDemiTourEncolure(),
            mensurationDto.getDemiCarrureDos(),
            mensurationDto.getDemiCarrureDevant(),
            mensurationDto.getLongueurEpaule(),
            mensurationDto.getTourEmmanchure(),
            mensurationDto.getHauteurDessousBras(),
            mensurationDto.getLongueurBras(),
            mensurationDto.getGrosseurBras(),
            mensurationDto.getHauteurCoude(),
            mensurationDto.getTourPoigner(),
            mensurationDto.getHauteurTailleHanche(),
            mensurationDto.getHauteurMontant(),
            mensurationDto.getEnfourchure(),
            mensurationDto.getHauteurTailleGenou(),
            mensurationDto.getHauteurTailleATerre(),
            mensurationDto.getHauteurTailleCoteATerre());

            Long idRendezVous = mensurationDto.getIdRendezVous();
            if (idRendezVous != null) {
                Optional<RendezVous> rendezVousOptional = rendezVousRepository.findById(idRendezVous);
                if (rendezVousOptional.isPresent()) {
                    mensuration.setRendezVous(rendezVousOptional.get());
                } else {
                    // Gérer le cas où le RendezVous n'existe pas.
                    // Vous pouvez lancer une exception personnalisée, loguer un avertissement, etc.
                    throw new IllegalArgumentException("Le RendezVous avec l'ID " + idRendezVous + " n'existe pas.");
                }
            } else {
                // Si l'idRendezVous est null, la relation ManyToOne sera null dans l'entité Mensuration.
                // Assurez-vous que cela correspond à votre logique métier (nullable=true dans l'entité).
            }

            return mensurationRepository.save(mensuration);
        }
}
