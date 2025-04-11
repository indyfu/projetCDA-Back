package projet3.maison.leloire.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projet3.maison.leloire.entity.BearerToken;
import projet3.maison.leloire.entity.Role;
import projet3.maison.leloire.entity.User;
import projet3.maison.leloire.entity.dto.AuthenticationDto;
import projet3.maison.leloire.entity.dto.RegistrationDto;
import projet3.maison.leloire.entity.dto.UserDto;
import projet3.maison.leloire.repository.RoleRepository;
import projet3.maison.leloire.repository.UserRepository;
import projet3.maison.leloire.security.JwtUtilities;
import projet3.maison.leloire.service.SecurityService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Annotation @Service permettant à Spring de découvrir la classe et l'instancier lorsqu'une
    méthode de l'interface SecurityService sera invoqué.
 */

@Service //Permet a SpringBoot de trouver les implémentations
public class SecurityServiceImpl implements SecurityService {

    /// ////////////
    /// ATTRIBUTS//
    /// ///////////

    // Injecté par le biais de son mutateur (setter)
    private UserRepository userDao;
    // Injecté par son mutateur
    private RoleRepository roleRepository;
    // Injecté par son mutateur
    private AuthenticationManager authenticationManager;
    // Injecté par son mutateur
    private PasswordEncoder passwordEncoder;
    // injecté par son mutateur
    private JwtUtilities jwtUtilities;
    /// /////////////////////
    /// Méthodes publiques//
    /// ////////////////////



    @Override   // Enregistre un utilisateur
    public ResponseEntity<Object> register(RegistrationDto registrationDto) {
        if(userDao.existsByLogin(registrationDto.getLogin())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Identifiant déjà utilisé.");
        } else {
            User user = new User();
            user.setName(registrationDto.getName());
            user.setSurname(registrationDto.getSurname());
            user.setAddress(registrationDto.getAddress());
            user.setPhoneNumber(registrationDto.getPhoneNumber());
            user.setLogin(registrationDto.getLogin());
            user.setPassword(passwordEncoder.encode(registrationDto.getPassword())); // Pour encoder le password pour insérer en base de données
            Role role = roleRepository.findByRoleName(registrationDto.getRoleName());
            user.setRoles(Collections.singletonList(role));
            user.setEmail(registrationDto.getEmail());
            // On va pouvoir sauvegarder notre User :
            userDao.save(user);
            // On va créer le token
            String token = jwtUtilities.generateToken(registrationDto.getLogin(),
                    Collections.singletonList(role.getRoleName()));
            return ResponseEntity.status(HttpStatus.OK).body(new BearerToken(
                    token, "Bearer "));
        }
    }

    // Authentification de l'utilisateur
    @Override
    public ResponseEntity<UserDto> authenticate(AuthenticationDto authenticationDto) {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationDto.getLogin(),
                        authenticationDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userDao.findByLogin(authentication.getName())
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));;
        List<String> rolesNames = new ArrayList<>();
        user.getRoles().forEach(role-> rolesNames.add(role.getRoleName()));
        String token = jwtUtilities.generateToken(user.getUsername(),rolesNames);
       UserDto userDto = new UserDto(user.getId(), user.getName(), user.getSurname(), token);
        return ResponseEntity.ok(userDto);
    }





    /// //////////
    /// SETTERS//
    /// /////////
    /*
    Annotation @Autowired placée sur le mutateur de l'objet que Spring devra
    instancier pour pratiquer l'inversion de contrôle par injection de dépendance.
     */

    @Autowired
    public void setUserDao(UserRepository userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setJwtUtilities(JwtUtilities jwtUtilities) {
        this.jwtUtilities = jwtUtilities;
    }
}
