package projet3.maison.leloire.controller.rest;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet3.maison.leloire.entity.Dress;
import projet3.maison.leloire.service.CatalogService;

import java.util.List;

@RestController
@RequestMapping("api/rest/catalog")
@CrossOrigin("${front.url}")
public class CatalogRestController {

    private final CatalogService catalogService;

    public CatalogRestController(CatalogService catalogService){
        this.catalogService = catalogService;
    }

    @GetMapping("/dresses")
    public List<Dress> fetchDresses(){
        return catalogService.getAllDresses();
    }


}
