package Robin.TechItEasy.services;

import Robin.TechItEasy.dtos.WallBracketDto;
import Robin.TechItEasy.exceptions.RecordNotFoundException;
import Robin.TechItEasy.inputDtos.WallBracketInputDto;
import Robin.TechItEasy.model.WallBracket;
import Robin.TechItEasy.repository.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private WallBracketRepository wallBracketRepos;

    public WallBracketService(WallBracketRepository wallBracketRepos) {
        this.wallBracketRepos = wallBracketRepos;
    }

    public List<WallBracketDto> getAllWallBrackets(){
        List<WallBracket> wallBracketList = wallBracketRepos.findAll();
        List<WallBracketDto> wallBracketDtoList = new ArrayList<>();
        for(WallBracket wallBracket : wallBracketList)
        {
            wallBracketDtoList.add(dtoFromWallBracket(wallBracket));
        }
        return wallBracketDtoList;
    }

    public WallBracketDto getWallBracket(Long id){
        Optional<WallBracket> wallBracketOptional = wallBracketRepos.findById(id);
        if (wallBracketOptional.isPresent()) {
            WallBracket wallBracket = wallBracketOptional.get();
            return dtoFromWallBracket(wallBracket);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

    public WallBracketDto addWallBracket(WallBracketInputDto dto){
        WallBracket wallBracket = wallBracketFromDto(dto);
        wallBracketRepos.save(wallBracket);
        return dtoFromWallBracket(wallBracket);
    }

    public WallBracketDto editWallBracket(Long id, WallBracketInputDto dto){
        Optional<WallBracket> wallBracketOptional = wallBracketRepos.findById(id);
        if (wallBracketOptional.isPresent()) {
            WallBracket OgWallBracket = wallBracketOptional.get();
            WallBracket wallBracket = wallBracketFromDto(dto);
            wallBracket.setId(OgWallBracket.getId());

            WallBracket newWallBracket = wallBracketRepos.save(wallBracket);

            return dtoFromWallBracket(wallBracket);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

    public void deleteWallBracket(Long id){
        Optional<WallBracket> wallBracketOptional = wallBracketRepos.findById(id);
        if (wallBracketOptional.isPresent()) {
            wallBracketRepos.deleteById(id);
        } else {
            throw new RecordNotFoundException("ID cannot be found");
        }
    }

    public WallBracketDto dtoFromWallBracket(WallBracket wallBracket) {
        WallBracketDto dto = new WallBracketDto();
        dto.setId(wallBracket.getId());
        dto.setSize(wallBracket.getSize());
        dto.setAdjustable(wallBracket.getAdjustable());
        dto.setName(wallBracket.getName());
        dto.setPrice(wallBracket.getPrice());
        dto.setOriginalStock(wallBracket.getOriginalStock());
        dto.setSold(wallBracket.getSold());
        return dto;
    }

    public WallBracket wallBracketFromDto (WallBracketInputDto dto) {
        WallBracket wallBracket = new WallBracket();
        wallBracket.setId(dto.getId());
        wallBracket.setSize(dto.getSize());
        wallBracket.setAdjustable(dto.getAdjustable());
        wallBracket.setName(dto.getName());
        wallBracket.setPrice(dto.getPrice());
        wallBracket.setOriginalStock(dto.getOriginalStock());
        wallBracket.setSold(dto.getSold());
        return wallBracket;
    }
}

