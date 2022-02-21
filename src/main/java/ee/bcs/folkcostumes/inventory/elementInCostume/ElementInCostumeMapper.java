package ee.bcs.folkcostumes.inventory.elementInCostume;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElementInCostumeMapper {
    ElementInCostume elementInCostumeDtoToElementInCostume(ElementInCostumeDto elementInCostumeDto);

    ElementInCostumeDto elementInCostumeToElementInCostumeDto(ElementInCostume elementInCostume);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateElementInCostumeFromElementInCostumeDto(ElementInCostumeDto elementInCostumeDto, @MappingTarget ElementInCostume elementInCostume);

    @Mapping(target = "elementName", source = "elementInCostumeDto.element.elementName")
    @Mapping(target = "elementType", source = "elementInCostumeDto.element.elementType")
    @Mapping(target = "costumeName", source = "costume.name")
    List<ElementInCostumeRequest> elementsInCostumeToElementCostumeRequests(List<ElementInCostume> elementsInCostumes);

}
