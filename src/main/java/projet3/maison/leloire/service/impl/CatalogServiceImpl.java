package projet3.maison.leloire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet3.maison.leloire.entity.Dress;
import projet3.maison.leloire.repository.DressRepository;
import projet3.maison.leloire.service.CatalogService;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final DressRepository dressRepository;

    @Autowired
    public CatalogServiceImpl(DressRepository dressRepository) {
        this.dressRepository = dressRepository;
    }

    @Override
    public List<Dress> getAllDresses(){
        return dressRepository.findAll();
    }
}
