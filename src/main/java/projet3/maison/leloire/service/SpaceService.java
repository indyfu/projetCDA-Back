package projet3.maison.leloire.service;

import projet3.maison.leloire.entity.User;
import projet3.maison.leloire.entity.dto.UserModifyDto;

public interface SpaceService {
    User findById(Long id);
    User modifyUser(UserModifyDto userModifyDto);
}
