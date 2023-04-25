package com.starengtech.aboutWorld.resources;

import com.starengtech.aboutWorld.entities.AwUser;
import com.starengtech.aboutWorld.entitiesDTO.AwUserDTO;
import com.starengtech.aboutWorld.services.AwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/awuser")
public class AwUserResource {
    
    @Autowired
    private AwUserService service;

    @GetMapping
    public ResponseEntity<List<AwUserDTO>> findAll(){
        List<AwUser> list = service.findAll();
        List<AwUserDTO> listDto = list.stream().map(x -> new AwUserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AwUserDTO> findById(@PathVariable Long id){
        AwUserDTO ProfileDTO = new AwUserDTO(service.findById(id));
        return ResponseEntity.ok().body(ProfileDTO);
    }

    @GetMapping(value = "/find-by-email")
    public ResponseEntity <AwUserDTO> findUserByNameAndPassword(@RequestParam(name = "email") String email) {
        Optional<AwUser> profile;
        profile = service.findByEmail(email);
        if(!profile.isEmpty()){
            AwUserDTO userDto = new AwUserDTO(profile.get());
            return ResponseEntity.ok().body(userDto);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/find-by-remote")
    public ResponseEntity<List<AwUserDTO>> findByRemote(){
        List<AwUser> list = service.findByRemote();
        List<AwUserDTO> listDto = list.stream().map(x -> new AwUserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/find-by-country")
    public ResponseEntity<List<AwUserDTO>> findByCountry(@RequestParam(name = "country") String country){
        List<AwUser> list = service.findByCountry(country);
        List<AwUserDTO> listDto = list.stream().map(x -> new AwUserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/find-by-nationality")
    public ResponseEntity<List<AwUserDTO>> findByNationality(@RequestParam(name = "nationality") String nationality){
        List<AwUser> list = service.findByNationality(nationality);
        List<AwUserDTO> listDto = list.stream().map(x -> new AwUserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/find-by-country-and-nationality")
    public ResponseEntity<List<AwUserDTO>> findByCountryAndNationality(@RequestParam(name = "country") String country, @RequestParam(name = "nationality") String nationality){
        List<AwUser> list = service.findByCountryAndNationality(country, nationality);
        List<AwUserDTO> listDto = list.stream().map(x -> new AwUserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<AwUserDTO> insert(@RequestBody AwUser Profile){
        AwUserDTO ProfileDTO = new AwUserDTO(service.insert(Profile));
        return ResponseEntity.ok().body(ProfileDTO);
    }

    @DeleteMapping(value = "/{id}/m$s*a")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
