package Robin.TechItEasy.controllers;

import Robin.TechItEasy.Television;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class TelevisionsController {
    public HashMap<Integer,Television> inventory = new HashMap<Integer, Television>();


    @PostMapping("/initInventory")
    public String initTelevision (){

        Television samsungXl = new Television("Samsung XL",1111,449.99);
        Television huawaiSmart = new Television("Huawai Smart",2222,299.99);
        Television appleTv4 = new Television("Apple Tv 4",3333,1019.99);
        inventory.put(1111, samsungXl);
        inventory.put(2222, huawaiSmart);
        inventory.put(3333, appleTv4);
        return "Initialized Inventory as "+inventory;
    }
    @GetMapping("/inventory")
    public HashMap<Integer,Television> showInventory() {
        return inventory;
    }
    @PostMapping("/television")
    public String addTelevision (@RequestBody Television television){
        inventory.put(television.getSerialNumber(), television);
        return "television successfully added!";
    }

    @GetMapping("/television/{id}")
    public Television showInventory(@PathVariable int id) {
        return inventory.get(id);
    }
    @PutMapping("/television/{id}")
    public String updateTelevision(@PathVariable int id, @RequestBody Television television) {
        inventory.get(id).setName(television.getName());
        inventory.get(id).setPrice(television.getPrice());
        return "television successfully updated! (Serial Number Update not possible)";
    }
    @DeleteMapping("/television/{id}")
    public String DeleteTelevision(@PathVariable int id){
        inventory.remove(id);
        return "television successfully removed!";
    }

}
