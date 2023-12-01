package Robin.TechItEasy.controllers;

import Robin.TechItEasy.dtos.TelevisionDto;
import Robin.TechItEasy.dtos.TelevisionInputDto;
import Robin.TechItEasy.services.TelevisionService;
import jakarta.validation.Valid;
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
    private TelevisionService televisionService;
    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        List<TelevisionDto> televisionDtoList;
        televisionDtoList = televisionService.getAllTelevisions();
        return ResponseEntity.ok(televisionDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getTelevision(id));
    }

    @PostMapping
    public ResponseEntity<TelevisionDto> addTelevision (@Valid @RequestBody TelevisionInputDto inputDto){
        TelevisionDto addedTelevisionDto = televisionService.addTelevision(inputDto);
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/"+addedTelevisionDto.getId()).toUriString());

        return ResponseEntity.created(uri).body(addedTelevisionDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@Valid @PathVariable Long id, @RequestBody TelevisionInputDto inputDto) {
        TelevisionDto edittedTelevisionDto = televisionService.editTelevision(id, inputDto);
        return ResponseEntity.ok(edittedTelevisionDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable Long id){
        televisionService.deleteTelevision(id);
        return new ResponseEntity<>("TV succesfully deleted", HttpStatus.OK);
    }

}
