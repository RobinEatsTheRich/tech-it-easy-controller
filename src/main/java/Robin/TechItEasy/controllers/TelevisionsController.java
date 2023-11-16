
package Robin.TechItEasy.controllers;

import Robin.TechItEasy.Television;
import Robin.TechItEasy.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
@RestController
public class TelevisionsController {
    public HashMap<Integer,Television> televisions = new HashMap<Integer, Television>();


    @PostMapping("/inittelevisions")
    public ResponseEntity<String> initTelevision (){

        Television samsungXl = new Television("Samsung XL",1111,449.99);
        Television huawaiSmart = new Television("Huawai Smart",2222,299.99);
        Television appleTv4 = new Television("Apple Tv 4",3333,1019.99);
        televisions.put(1111, samsungXl);
        televisions.put(2222, huawaiSmart);
        televisions.put(3333, appleTv4);
        return new ResponseEntity<>("Initialized Inventory as "+televisions, HttpStatus.OK);
    }
    @GetMapping("/televisions")
    public ResponseEntity<HashMap<Integer,Television>> showInventory() {
        return new ResponseEntity<>(this.televisions, HttpStatus.OK);
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
