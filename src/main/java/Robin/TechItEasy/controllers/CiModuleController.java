package Robin.TechItEasy.controllers;

import Robin.TechItEasy.dtos.CiModuleDto;
import Robin.TechItEasy.inputDtos.CiModuleInputDto;
import Robin.TechItEasy.services.CiModuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/ci_modules")
@RestController
public class CiModuleController {

    @Autowired
    private CiModuleService ciModuleService;
    @GetMapping
    public ResponseEntity<List<CiModuleDto>> getAllCiModules() {
        List<CiModuleDto> ciModuleDtoList;
        ciModuleDtoList = ciModuleService.getAllCiModules();
        return ResponseEntity.ok(ciModuleDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CiModuleDto> getCiModule(@PathVariable Long id) {
        return ResponseEntity.ok(ciModuleService.getCiModule(id));
    }

    @PostMapping
    public ResponseEntity<CiModuleDto> addCiModule (@Valid @RequestBody CiModuleInputDto inputDto){
        CiModuleDto addedCiModuleDto = ciModuleService.addCiModule(inputDto);
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/"+addedCiModuleDto.getId()).toUriString());

        return ResponseEntity.created(uri).body(addedCiModuleDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiModuleDto> updateCiModule(@Valid @PathVariable Long id, @RequestBody CiModuleInputDto inputDto) {
        CiModuleDto edittedCiModuleDto = ciModuleService.editCiModule(id, inputDto);
        return ResponseEntity.ok(edittedCiModuleDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCiModule(@PathVariable Long id){
        ciModuleService.deleteCiModule(id);
        return new ResponseEntity<>("CI Module succesfully deleted", HttpStatus.OK);
    }

}