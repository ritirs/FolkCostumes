package ee.bcs.folkcostumes.inventory.element;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElementMapper {
    Element elementDtoToElement(ElementDto elementDto);


    ElementDto elementToElementDto(Element element);
    List<ElementDto> elementToElementDto(List<Element> element);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateElementFromElementDto(ElementDto elementDto, @MappingTarget Element element);
}
