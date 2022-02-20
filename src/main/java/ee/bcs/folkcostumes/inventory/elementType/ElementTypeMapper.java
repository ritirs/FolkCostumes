package ee.bcs.folkcostumes.inventory.elementType;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElementTypeMapper {


    ElementType elementTypeDtoToElementType(ElementTypeDto elementTypeRequest);

//    ElementTypeDto elementTypeToElementTypeDto(ElementType elementType);
//    List<ElementTypeDto> elementTypesToElementTypeDtos (List<ElementType> elementType);

    ElementTypeDto toResponse(ElementType elementType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateElementTypeFromElementTypeDto(ElementTypeDto elementTypeRequest, @MappingTarget ElementType elementType);

    ElementType nameToElementType(String name);
}
