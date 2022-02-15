package ee.bcs.folkcostumes.costume;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CostumeMapper {
    Costume costumeDtoToCostume(CostumeDto costumeDto);

    CostumeDto costumeToCostumeDto(Costume costume);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCostumeFromCostumeDto(CostumeDto costumeDto, @MappingTarget Costume costume);
}
