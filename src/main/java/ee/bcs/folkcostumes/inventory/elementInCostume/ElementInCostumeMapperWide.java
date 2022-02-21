package ee.bcs.folkcostumes.inventory.elementInCostume;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElementInCostumeMapperWide {
//    @Mapping(source = "costumeName", target = "costume.name")
//    @Mapping(source = "elementElementTypeElementType", target = "elementType.elementType")
//    @Mapping(source = "elementElementName", target = "element.elementName")
//    @Mapping(source = "elementDescription", target = "element.description")
//    ElementInCostume elementInCostumeWideRequestToElementInCostume(ElementInCostumeWideRequest elementInCostumeWideRequest);
//
//    @InheritInverseConfiguration(name = "elementInCostumeWideRequestToElementInCostume")
//    ElementInCostumeWideRequest elementInCostumeToElementInCostumeWideRequest(ElementInCostume elementInCostume);

    @InheritConfiguration(name = "elementInCostumeWideRequestToElementInCostume")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateElementInCostumeFromElementInCostumeWideRequest(ElementInCostumeWideRequest elementInCostumeWideRequest, @MappingTarget ElementInCostume elementInCostume);
}
