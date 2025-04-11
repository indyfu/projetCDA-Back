package projet3.maison.leloire.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import projet3.maison.leloire.entity.RendezVous;
import projet3.maison.leloire.entity.dto.RendezVousAddDto;
import projet3.maison.leloire.entity.dto.RendezVousAnnulationDto;
import projet3.maison.leloire.service.RdvService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/rest/rdv")
@CrossOrigin("${front.url}")
public class RdvRestController {

    private final RdvService rdvService;

    @Autowired
    public RdvRestController(RdvService rdvService) {
        this.rdvService = rdvService;
    }
    @PostMapping("/add")
    public RendezVous ajouterRdv(@RequestBody RendezVousAddDto rdvDto){
        return rdvService.saveRendezVous(rdvDto);
    }

    @GetMapping("/{id}/mes/rdv")
    public List<RendezVous> mesRdv(@PathVariable Long id) {
        return rdvService.findAllByUserId(id);
    }

    @GetMapping("/en/attente")
    public List<RendezVous> rdvEnAttente() {
        return rdvService.findAllAwaitRdv();
    }

    @PutMapping("/annuler")
    public ResponseEntity<Void> annulerRendezVous(@RequestBody @Validated RendezVousAnnulationDto annulationDto) {
        rdvService.annulerRendezVous(annulationDto);
        return ResponseEntity.noContent().build(); // Code 204 pour indiquer que l'annulation a fonctionné :D
    }

    @GetMapping("/notification")
    public Map<String, Integer> getRendezVousEnAttente() {
        int count = rdvService.rendezVousEnAttente();
        return Collections.singletonMap("count", count);
    }

    @GetMapping("/all/rdv")
        public List<RendezVous> getAllRdv(){
        return rdvService.findAllRdv();

    }

    @GetMapping("/occupied")
    public List<LocalDateTime> getOccupiedHours(@RequestParam("date") LocalDate date) {
        // Récupérer les heures réservées pour cette date
        return rdvService.getOccupiedHours(date);
    }

}
