package Robin.TechItEasy.controllers;

import Robin.TechItEasy.exceptions.RecordNotFoundException;
import Robin.TechItEasy.model.Television;
import Robin.TechItEasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/televisions")
@RestController
public class TelevisionsController {

    @Autowired
    private TelevisionRepository televisionRepository;
    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return ResponseEntity.ok(televisionRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Television> addTelevision (@RequestBody Television television){
        televisionRepository.save(television);
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/"+television.getId()).toUriString());
        return ResponseEntity.created(uri).body(television);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> showInventory(@PathVariable Long id) {
        if (id >= 0 && televisionRepository.findById(id).isPresent()) {
            return ResponseEntity.ok(televisionRepository.findById(id).get());
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
        if (id >= 0 && televisionRepository.findById(id).isPresent()) {
            television.setId(id);
            return ResponseEntity.ok(televisionRepository.save(television));
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id){
        if (id >= 0 && televisionRepository.findById(id).isPresent()) {
            televisionRepository.deleteById(id);
            return new ResponseEntity<>("TV succesfully deleted", HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

}
