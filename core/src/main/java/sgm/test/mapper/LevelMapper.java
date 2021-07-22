package sgm.test.mapper;

import org.mapstruct.Mapper;
import sgm.test.dto.LevelDto;
import sgm.test.entity.Level;
import sgm.test.web.dto.LevelWebDto;

import java.util.List;

@Mapper
public interface LevelMapper {

    LevelWebDto toWebDto(LevelDto dto);

    LevelDto toDto(LevelWebDto webDto);

    LevelDto toDto(Level entity);

    Level toEntity(LevelDto dto);

    List<LevelDto> toDtoList(List<Level> list);

    List<LevelWebDto> toWebDtoList(List<LevelDto> listDto);
}
