package ee.bcs.folkcostumes.inventory.elementType;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElementTypeMapper {


    ElementType elementTypeDtoToElementType(ElementTypeRequest elementTypeRequest);

    ElementTypeRequest elementTypeToElementTypeDto(ElementType elementType);

    List<ElementTypeRequest> elementTypesToElementTypeDtos(List<ElementType> elementTypes);

    ElementTypeRequest toResponse(ElementType elementType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateElementTypeFromElementTypeDto(ElementTypeRequest elementTypeRequest, @MappingTarget ElementType elementType);
}
