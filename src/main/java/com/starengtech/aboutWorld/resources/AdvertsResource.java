package com.starengtech.aboutWorld.resources;

import com.starengtech.aboutWorld.entities.Adverts;
import com.starengtech.aboutWorld.entities.AwUser;
import com.starengtech.aboutWorld.entitiesDTO.AdvertsDTO;
import com.starengtech.aboutWorld.entitiesDTO.AwUserDTO;
import com.starengtech.aboutWorld.services.AdvertsService;
import com.starengtech.aboutWorld.services.AdvertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/awadverts")
public class AdvertsResource {
    
    @Autowired
    private AdvertsService service;

    @GetMapping
    public ResponseEntity<List<AdvertsDTO>> findAll(){
        List<Adverts> list = service.findAll();
        List<AdvertsDTO> listDto = list.stream().map(x -> new AdvertsDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AdvertsDTO> findById(@PathVariable Long id){
        AdvertsDTO ProfileDTO = new AdvertsDTO(service.findById(id));
        return ResponseEntity.ok().body(ProfileDTO);
    }

    @PostMapping
    public ResponseEntity<AdvertsDTO> insert(@RequestBody Adverts ad){
        AdvertsDTO ProfileDTO = new AdvertsDTO(service.insert(ad));
        return ResponseEntity.ok().body(ProfileDTO);
    }

    @DeleteMapping(value = "/{id}/m$s*a")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/find-by-user")
    public ResponseEntity<List<AdvertsDTO>> findByAwUser(@RequestBody AwUser user){
        List<Adverts> list = service.findByAwUser(user);
        List<AdvertsDTO> listDto = list.stream().map(x -> new AdvertsDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/find-by-country")
    public ResponseEntity<List<AdvertsDTO>> findByCountry(@RequestParam(name = "country") String country){
        List<Adverts> list = service.findByCountry(country);
        List<AdvertsDTO> listDto = list.stream().map(x -> new AdvertsDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/find-by-nationality")
    public ResponseEntity<List<AdvertsDTO>> findByNationality(@RequestParam(name = "nationality") String nationality){
        List<Adverts> list = service.findByNationality(nationality);
        List<AdvertsDTO> listDto = list.stream().map(x -> new AdvertsDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/find-by-country-and-nationality")
    public ResponseEntity<List<AdvertsDTO>> findByCountryAndNationality(@RequestParam(name = "country") String country, @RequestParam(name = "nationality") String nationality){
        List<Adverts> list = service.findByCountryAndNationality(country, nationality);
        List<AdvertsDTO> listDto = list.stream().map(x -> new AdvertsDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

}
