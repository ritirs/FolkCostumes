package ee.bcs.folkcostumes.inventory.elementInCostume;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElementInCostumeMapper {
    ElementInCostume elementInCostumeDtoToElementInCostume(ElementInCostumeDto elementInCostumeDto);

    ElementInCostumeDto elementInCostumeToElementInCostumeDto(ElementInCostume elementInCostume);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateElementInCostumeFromElementInCostumeDto(ElementInCostumeDto elementInCostumeDto, @MappingTarget ElementInCostume elementInCostume);

    @Mapping(target = "elementName", source = "element.elementName")
    @Mapping(target = "elementType", source = "element.elementType.elementType")
    @Mapping(target = "costumeName", source = "costume.name")
    ElementInCostumeRequest elementsInCostumeToElementCostumeRequests (ElementInCostume elementsInCostumes);


    @Mapping(source = "costumeId", target = "costume.id")
    @Mapping(source = "costumeName", target = "costume.name")
    @Mapping(source = "elementId", target = "element.id")
    @Mapping(source = "elementElementTypeId", target = "element.elementType.id")
    @Mapping(source = "elementElementTypeElementType", target = "element.elementType.elementType")
    @Mapping(source = "elementElementName", target = "element.elementName")
    @Mapping(source = "elementDescription", target = "element.description")
    ElementInCostume elementInCostumeDtoLargeToElementInCostume(ElementInCostumeDtoLarge elementInCostumeDtoLarge);

    @InheritInverseConfiguration(name = "elementInCostumeDtoLargeToElementInCostume")
    ElementInCostumeDtoLarge elementInCostumeToElementInCostumeDtoLarge(ElementInCostume elementInCostume);

    @InheritConfiguration(name = "elementInCostumeDtoLargeToElementInCostume")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateElementInCostumeFromElementInCostumeDtoLarge(ElementInCostumeDtoLarge elementInCostumeDtoLarge, @MappingTarget ElementInCostume elementInCostume);

}
