package ee.bcs.folkcostumes.inventory.elementType;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElementTypeMapper {


    ElementType elementTypeDtoToElementType(ElementTypeDto elementTypeDto);

    ElementTypeDto elementTypeToElementTypeDto(ElementType elementType);

    List<ElementTypeDto> elementTypesToElementTypeDtos(List<ElementType> elementTypes);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateElementTypeFromElementTypeDto(ElementTypeDto elementTypeDto, @MappingTarget ElementType elementType);
}
