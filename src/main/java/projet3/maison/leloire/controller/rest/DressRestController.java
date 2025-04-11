package projet3.maison.leloire.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet3.maison.leloire.entity.Dress;
import projet3.maison.leloire.entity.dto.DressDto;
import projet3.maison.leloire.service.DressService;

import java.util.List;

@RestController
@RequestMapping("api/rest/dress")
@CrossOrigin("${front.url}")
public class DressRestController {

    private final DressService dressService;

    @Autowired
    public DressRestController( DressService dressService) {
        this.dressService = dressService;
    }

    @PostMapping("/add/dress")
    public Dress addDress (@RequestBody DressDto dressDto){
        return dressService.saveDress(dressDto);
    }

    @GetMapping("/find/{id}/dress")
    public Dress findDressById(@PathVariable long id){
        return dressService.findById(id);
    }

    @DeleteMapping("/delete/{id}/dress")
    public void deleteDressById (@PathVariable long id){
        dressService.deleteDress(id);
    }

    @GetMapping("/all")
    public List<Dress> findAll(){
        return dressService.findAll();
    }

}
