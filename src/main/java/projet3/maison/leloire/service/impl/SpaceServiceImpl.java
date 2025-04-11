package projet3.maison.leloire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet3.maison.leloire.entity.User;
import projet3.maison.leloire.entity.dto.UserModifyDto;
import projet3.maison.leloire.repository.UserRepository;
import projet3.maison.leloire.service.SpaceService;

@Service
public class SpaceServiceImpl implements SpaceService {
    private final UserRepository userRepository;

    @Autowired
    public SpaceServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
        return user;
    }

    @Override
    public User modifyUser(UserModifyDto userModifyDto) {
        userRepository.modifyUser(userModifyDto.getId(), userModifyDto.getName(), userModifyDto.getSurname(),
                userModifyDto.getAddress(), userModifyDto.getPhoneNumber(), userModifyDto.getEmail());

        // Récupérer l'utilisateur mis à jour après modification
        User updatedUser = userRepository.findById(userModifyDto.getId())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable après modification"));

        return updatedUser;
    }

}
