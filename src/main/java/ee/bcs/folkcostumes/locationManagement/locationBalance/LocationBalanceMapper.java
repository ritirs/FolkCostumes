package ee.bcs.folkcostumes.locationManagement.locationBalance;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationBalanceMapper {
    LocationBalance locationBalanceDtoToLocationBalance(LocationBalanceDto locationBalanceDto);

    LocationBalanceDto locationBalanceToLocationBalanceDto(LocationBalance locationBalance);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLocationBalanceFromLocationBalanceDto(LocationBalanceDto locationBalanceDto, @MappingTarget LocationBalance locationBalance);

    @Mapping(source = "location.location", target = "locationLocation")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "element.elementName", target = "elementElementName")
    @Mapping(source = "element.description", target = "elementDescription")
    LocationBalanceStatement locationBalanceToLocationBalanceStatement(LocationBalance locationBalance);
}
