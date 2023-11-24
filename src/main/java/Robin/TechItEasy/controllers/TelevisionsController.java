
package Robin.TechItEasy.controllers;

import Robin.TechItEasy.Television;
import Robin.TechItEasy.exceptions.RecordNotFoundException;
import Robin.TechItEasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelevisionsController {

    @Autowired
    private TelevisionRepository televisionRepository;


    @PostMapping("/inittelevisions")
    public ResponseEntity<String> initTelevision (){
    }
    @GetMapping("/televisions")
    public ResponseEntity<List<Robin.TechItEasy.model.Television>> getAllTelevisions() {
        return ResponseEntity.ok(televisionRepository.findAll());
    }
    @PostMapping("/televisions")
    public ResponseEntity<String> addTelevision (@RequestBody Television television){
        televisions.put(television.getSerialNumber(), television);
        return new ResponseEntity<>("television successfully added!", HttpStatus.OK);
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> showInventory(@PathVariable int id) {
        if (id >= 0 && this.televisions.get(id) != null) {
            return new ResponseEntity<>(this.televisions.get(id), HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }
    @PutMapping("/televisions/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody Television television) {
        if (id >= 0 && this.televisions.get(id) != null) {
            televisions.get(id).setName(television.getName());
            televisions.get(id).setPrice(television.getPrice());
            return new ResponseEntity<>("television successfully updated! (Serial Number Update not possible)", HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }
    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id){
        if (id >= 0 && this.televisions.get(id) != null) {
            televisions.remove(id);
            return new ResponseEntity<>("television successfully deleted", HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

}
