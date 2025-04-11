package projet3.maison.leloire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet3.maison.leloire.entity.Dress;
import projet3.maison.leloire.entity.Style;
import projet3.maison.leloire.entity.dto.DressDto;
import projet3.maison.leloire.repository.DressRepository;
import projet3.maison.leloire.repository.StyleRepository;
import projet3.maison.leloire.service.DressService;

import java.util.List;


@Service
public class DressServiceImpl implements DressService {
    private final DressRepository dressRepository;
    private final StyleRepository styleRepository;



    @Autowired
    public DressServiceImpl(DressRepository dressRepository, StyleRepository styleRepository) {
        this.dressRepository = dressRepository;
        this.styleRepository = styleRepository;
    }


    @Override
    public Dress saveDress(DressDto dressDto) {
        Style style = styleRepository.findById(dressDto.getStyleId())
                .orElseThrow(() -> new RuntimeException("Style not found"));
        Dress dress = new Dress(
                dressDto.getName(),
                style,
                dressDto.getPrix(),
                dressDto.getImage(),
                dressDto.getImageAlt1(),
                dressDto.getImageAlt2(),
                dressDto.getDescription()
        );
        return dressRepository.save(dress);


    }

    @Override
    public Dress findById(long id) {
        // Vérifier si la robe existe
         Dress dress = dressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Robe introuvable"));
        return dress;
    }

    @Override
    public void deleteDress(long id) {
        // Vérifier si la robe existe
        Dress dress = dressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Robe introuvable"));
        dressRepository.deleteById(id);
    }

    @Override
    public List<Dress> findAll() {
        return dressRepository.findAll();
    }

}
