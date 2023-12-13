package Robin.TechItEasy.services;

import Robin.TechItEasy.dtos.CiModuleDto;
import Robin.TechItEasy.inputDtos.CiModuleInputDto;
import Robin.TechItEasy.exceptions.RecordNotFoundException;
import Robin.TechItEasy.model.CiModule;
import Robin.TechItEasy.repository.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private CiModuleRepository ciModuleRepos;

    public CiModuleService(CiModuleRepository ciModuleRepos) {
        this.ciModuleRepos = ciModuleRepos;
    }

    public List<CiModuleDto> getAllCiModules(){
        List<CiModule> ciModuleList = ciModuleRepos.findAll();
        List<CiModuleDto> ciModuleDtoList = new ArrayList<>();
        for(CiModule ciModule : ciModuleList)
        {
            ciModuleDtoList.add(dtoFromCiModule(ciModule));
        }
        return ciModuleDtoList;
    }

    public CiModuleDto getCiModule(Long id){
        Optional<CiModule> ciModuleOptional = ciModuleRepos.findById(id);
        if (ciModuleOptional.isPresent()) {
            CiModule ciModule = ciModuleOptional.get();
            return dtoFromCiModule(ciModule);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

    public CiModuleDto addCiModule(CiModuleInputDto dto){
        CiModule ciModule = ciModuleFromDto(dto);
        ciModuleRepos.save(ciModule);
        return dtoFromCiModule(ciModule);
    }

    public CiModuleDto editCiModule(Long id, CiModuleInputDto dto){
        Optional<CiModule> ciModuleOptional = ciModuleRepos.findById(id);
        if (ciModuleOptional.isPresent()) {
            CiModule OgCiModule = ciModuleOptional.get();
            CiModule ciModule = ciModuleFromDto(dto);
            ciModule.setId(OgCiModule.getId());

            CiModule newCiModule = ciModuleRepos.save(ciModule);

            return dtoFromCiModule(ciModule);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

    public void deleteCiModule(Long id){
        Optional<CiModule> ciModuleOptional = ciModuleRepos.findById(id);
        if (ciModuleOptional.isPresent()) {
            ciModuleRepos.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

    public CiModuleDto dtoFromCiModule(CiModule ciModule) {
        CiModuleDto dto = new CiModuleDto();
        dto.setId(ciModule.getId());
        dto.setType(ciModule.getType());
        dto.setName(ciModule.getName());
        dto.setPrice(ciModule.getPrice());
        dto.setOriginalStock(ciModule.getOriginalStock());
        dto.setSold(ciModule.getSold());
        return dto;
    }

    public CiModule ciModuleFromDto (CiModuleInputDto dto) {
        CiModule ciModule = new CiModule();
        ciModule.setId(dto.getId());
        ciModule.setType(dto.getType());
        ciModule.setName(dto.getName());
        ciModule.setPrice(dto.getPrice());
        ciModule.setOriginalStock(dto.getOriginalStock());
        ciModule.setSold(dto.getSold());
        return ciModule;
    }
}

