package projet3.maison.leloire.service;


import org.springframework.http.ResponseEntity;
import projet3.maison.leloire.entity.dto.AuthenticationDto;
import projet3.maison.leloire.entity.dto.RegistrationDto;
import projet3.maison.leloire.entity.dto.UserDto;

public interface SecurityService {

    ResponseEntity<Object> register(RegistrationDto registrationDto);
    ResponseEntity<UserDto> authenticate (AuthenticationDto authenticationDto);
}
