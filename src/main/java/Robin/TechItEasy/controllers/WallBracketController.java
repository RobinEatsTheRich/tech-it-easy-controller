package Robin.TechItEasy.controllers;

import Robin.TechItEasy.dtos.WallBracketDto;
import Robin.TechItEasy.inputDtos.WallBracketInputDto;
import Robin.TechItEasy.services.WallBracketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/wall_brackets")
@RestController
public class WallBracketController {

    @Autowired
    private WallBracketService wallBracketService;
    @GetMapping
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {
        List<WallBracketDto> wallBracketDtoList;
        wallBracketDtoList = wallBracketService.getAllWallBrackets();
        return ResponseEntity.ok(wallBracketDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketDto> getWallBracket(@PathVariable Long id) {
        return ResponseEntity.ok(wallBracketService.getWallBracket(id));
    }

    @PostMapping
    public ResponseEntity<WallBracketDto> addWallBracket (@Valid @RequestBody WallBracketInputDto inputDto){
        WallBracketDto addedWallBracketDto = wallBracketService.addWallBracket(inputDto);
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/"+addedWallBracketDto.getId()).toUriString());

        return ResponseEntity.created(uri).body(addedWallBracketDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@Valid @PathVariable Long id, @RequestBody WallBracketInputDto inputDto) {
        WallBracketDto edittedWallBracketDto = wallBracketService.editWallBracket(id, inputDto);
        return ResponseEntity.ok(edittedWallBracketDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWallBracket(@PathVariable Long id){
        wallBracketService.deleteWallBracket(id);
        return new ResponseEntity<>("Wall bracket succesfully deleted", HttpStatus.OK);
    }

}