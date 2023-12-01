package Robin.TechItEasy.services;

import Robin.TechItEasy.dtos.TelevisionDto;
import Robin.TechItEasy.dtos.TelevisionInputDto;
import Robin.TechItEasy.exceptions.RecordNotFoundException;
import Robin.TechItEasy.model.Television;
import Robin.TechItEasy.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {


    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public List<TelevisionDto> getAllTelevisions(){
        List<Television> televisionList = repos.findAll();
        List<TelevisionDto> televisionDtoList = new ArrayList<>();
        for(Television television : televisionList)
        {
            televisionDtoList.add(dtoFromTelevision(television));
        }
        return televisionDtoList;
    }

    public TelevisionDto getTelevision(Long id){
        Optional<Television> televisionOptional = repos.findById(id);
        if (televisionOptional.isPresent()) {
            Television television = televisionOptional.get();
            return dtoFromTelevision(television);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

    public TelevisionDto addTelevision(TelevisionInputDto dto){
        Television television = televisionFromDto(dto);
        repos.save(television);
        return dtoFromTelevision(television);
    }

    public TelevisionDto editTelevision(Long id, TelevisionInputDto dto){
        Optional<Television> televisionOptional = repos.findById(id);
        if (televisionOptional.isPresent()) {
            Television OgTelevision = televisionOptional.get();
            Television television = televisionFromDto(dto);
            television.setId(OgTelevision.getId());

            Television newTelevision = repos.save(television);

            return dtoFromTelevision(television);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

    public void deleteTelevision(Long id){
        Optional<Television> televisionOptional = repos.findById(id);
        if (televisionOptional.isPresent()) {
            repos.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

    public TelevisionDto dtoFromTelevision(Television television) {
        TelevisionDto dto = new TelevisionDto();
        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        return dto;
    }

    public Television televisionFromDto (TelevisionInputDto dto) {
        Television television = new Television();
        television.setId(dto.getId());
        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());
        return television;
    }
}
