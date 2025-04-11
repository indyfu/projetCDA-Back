package projet3.maison.leloire.service;

import projet3.maison.leloire.entity.Dress;
import projet3.maison.leloire.entity.dto.DressDto;

import java.util.List;

public interface DressService {
    Dress saveDress(DressDto dressDto);
    Dress findById(long id);
    void deleteDress(long id);
    List<Dress> findAll();
}
