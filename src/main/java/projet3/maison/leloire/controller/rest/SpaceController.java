package projet3.maison.leloire.controller.rest;


import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet3.maison.leloire.entity.Dress;
import projet3.maison.leloire.entity.RendezVous;
import projet3.maison.leloire.entity.User;
import projet3.maison.leloire.entity.dto.RendezVousAddDto;
import projet3.maison.leloire.entity.dto.UserDto;
import projet3.maison.leloire.entity.dto.UserModifyDto;
import projet3.maison.leloire.service.RdvService;
import projet3.maison.leloire.service.SpaceService;

import java.util.List;

@RestController
@RequestMapping("api/rest/space")
@CrossOrigin("${front.url}")
public class SpaceController {
    private final SpaceService spaceService;
    private final RdvService rdvService;

    @Autowired
    public SpaceController(SpaceService spaceService, RdvService rdvService) {
        this.spaceService = spaceService;
        this.rdvService = rdvService;
    }

    @GetMapping("/{id}/infos")
    public User findUserById(@PathVariable Long id){
        return spaceService.findById(id);
    }

    @GetMapping("/{id}/mes/rdv")
    public List<RendezVous> mesRdv(@PathVariable Long id) {
        return rdvService.findAllByUserId(id);
    }

    @PutMapping("/{id}/user/infos")
    public ResponseEntity<User> modifyUserInfos(@PathVariable Long id, @RequestBody UserModifyDto userModifyDto){
      User user =  spaceService.modifyUser(userModifyDto);
        return ResponseEntity.ok(user);

    }
    @PutMapping("/{id}/user/rdv")
    public void modifyUserRdv(@PathVariable Long id, @RequestBody RendezVousAddDto rendezVousAddDto){

    }

}
