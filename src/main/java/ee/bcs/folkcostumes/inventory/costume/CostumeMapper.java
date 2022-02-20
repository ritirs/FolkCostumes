package ee.bcs.folkcostumes.inventory.costume;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CostumeMapper {
    Costume costumeDtoToCostume(CostumeDto costumeDto);

    CostumeDto costumeToCostumeDto(Costume costume);

    List<CostumeDto> costumesToCostumeDtos(List<Costume> costumes);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCostumeFromCostumeDto(CostumeDto costumeDto, @MappingTarget Costume costume);


    Costume nameToCostume(String name);
}
