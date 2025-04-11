package projet3.maison.leloire.entity.dto;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;


import java.time.LocalDateTime;

public class RendezVousAnnulationDto {


    private Long RendezVousId;

    @NotBlank(message = "Le motif d'annulation est obligatoire")
    private String motifAnnulation;



    public RendezVousAnnulationDto() {
    }

    public RendezVousAnnulationDto(Long rendezVousId, String motifAnnulation) {
        RendezVousId = rendezVousId;
        this.motifAnnulation = motifAnnulation;

    }

    public Long getRendezVousId() {
        return RendezVousId;
    }

    public String getMotifAnnulation() {
        return motifAnnulation;
    }


    public void setRendezVousId(Long rendezVousId) {
        RendezVousId = rendezVousId;
    }

    public void setMotifAnnulation(String motifAnnulation) {
        this.motifAnnulation = motifAnnulation;
    }


}
