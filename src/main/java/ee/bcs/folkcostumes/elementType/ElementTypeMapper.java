package ee.bcs.folkcostumes.elementType;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElementTypeMapper {
    ElementType elementTypeDtoToElementType(ElementTypeDto elementTypeDto);

    ElementTypeDto elementTypeToElementTypeDto(ElementType elementType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateElementTypeFromElementTypeDto(ElementTypeDto elementTypeDto, @MappingTarget ElementType elementType);
}
