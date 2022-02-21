package ee.bcs.folkcostumes.inventory.element;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElementMapper1 {
    @Mapping(source = "elementTypeId", target = "elementType.id")
    @Mapping(source = "elementTypeElementType", target = "elementType.elementType")
    Element elementDto1ToElement(ElementDto1 elementDto1);

    @InheritInverseConfiguration(name = "elementDto1ToElement")
    ElementDto1 elementToElementDto1(Element element);

    @InheritConfiguration(name = "elementDto1ToElement")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateElementFromElementDto1(ElementDto1 elementDto1, @MappingTarget Element element);
}
