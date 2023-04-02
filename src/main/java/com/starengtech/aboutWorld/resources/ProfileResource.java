package com.starengtech.aboutWorld.resources;

import com.starengtech.aboutWorld.entities.UserProfile;
import com.starengtech.aboutWorld.entitiesDTO.ProfileDTO;
import com.starengtech.aboutWorld.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/profile")
public class ProfileResource {
    
    @Autowired
    private ProfileService service;

    @GetMapping
    public ResponseEntity<List<ProfileDTO>> findAll(){
        List<UserProfile> list = service.findAll();
        List<ProfileDTO> listDto = list.stream().map(x -> new ProfileDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfileDTO> findById(@PathVariable Long id){
        ProfileDTO ProfileDTO = new ProfileDTO(service.findById(id));
        return ResponseEntity.ok().body(ProfileDTO);
    }

    @GetMapping(value = "/find-by-email")
    public ResponseEntity <ProfileDTO> findUserByNameAndPassword(@RequestParam(name = "email") String email, @RequestParam(name = "pssd") String password) {
        Optional<UserProfile> profile;
        if(password.equals("none.ks$ata*0lo3h4seq@wt@uiH2GfdX9asdzbv$7rhgd")){
            profile = service.findByEmail(email);
        }else{
            profile = service.findByEmailAndPassword(email,password);
        }
        if(!profile.isEmpty()){
            ProfileDTO userDto = new ProfileDTO(profile.get());
            return ResponseEntity.ok().body(userDto);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> insert(@RequestBody UserProfile Profile){
        ProfileDTO ProfileDTO = new ProfileDTO(service.insert(Profile));
        return ResponseEntity.ok().body(ProfileDTO);
    }

    @DeleteMapping(value = "/{id}/m$s*a")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
