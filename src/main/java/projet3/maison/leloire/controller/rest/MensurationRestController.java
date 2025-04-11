package projet3.maison.leloire.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet3.maison.leloire.entity.Mensuration;
import projet3.maison.leloire.entity.RendezVous;
import projet3.maison.leloire.entity.dto.MensurationDto;
import projet3.maison.leloire.entity.dto.RendezVousAddDto;
import projet3.maison.leloire.service.MensurationService;

@RestController
@RequestMapping("api/rest/mensuration")
@CrossOrigin("${front.url}")
public class MensurationRestController {

    private final MensurationService mensurationService;

    @Autowired
    public MensurationRestController(MensurationService mensurationService) {
        this.mensurationService = mensurationService;
    }

    @PostMapping("/add")
    public Mensuration addMensuration(@RequestBody MensurationDto mensurationDto){
        return mensurationService.saveMensuration(mensurationDto);
    }
}
