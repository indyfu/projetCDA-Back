package projet3.maison.leloire.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet3.maison.leloire.entity.dto.AuthenticationDto;
import projet3.maison.leloire.entity.dto.RegistrationDto;
import projet3.maison.leloire.entity.dto.UserDto;
import projet3.maison.leloire.service.SecurityService;

/*
    Annotation @RestController indiquant à Spring qu'il faudra instancier cet
    objet lorsque son Servlet renverra vers un endpoint se trouvant ici.
    Par défaut il fait des singleton.
 */

@RestController
@RequestMapping("api/rest/security")
@CrossOrigin("${front.url}")  // ${} Renvoie vers un couple clé-valeur présent dans application.properties
public class SecurityRestController {

    // Injecté par le biais de son mutateur
    private SecurityService securityService;


    /// /////////////////////
    /// Méthodes publiques///
    /// /////////////////////

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegistrationDto registrationDto){
        return securityService.register(registrationDto);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserDto> authenticate (@RequestBody AuthenticationDto authenticationDto){
        return securityService.authenticate(authenticationDto);
    }


    /// //////////
    /// Setter///
    /// /////////
    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
}
