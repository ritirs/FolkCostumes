package ee.bcs.folkcostumes.inventory.elementInCostume;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElementInCostumeMapper {
    ElementInCostume elementInCostumeDtoToElementInCostume(ElementInCostumeDto elementInCostumeDto);

    ElementInCostumeDto elementInCostumeToElementInCostumeDto(ElementInCostume elementInCostume);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateElementInCostumeFromElementInCostumeDto(ElementInCostumeDto elementInCostumeDto, @MappingTarget ElementInCostume elementInCostume);
}
