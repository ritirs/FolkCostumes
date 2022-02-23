package ee.bcs.folkcostumes.locationManagement.locationBalance;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationBalanceStatementMapper {

    LocationBalance locationBalanceRequestToLocationBalance(LocationBalanceRequest locationBalanceRequest);

    @Mapping(source = "locationLocation", target = "location.location")
    @Mapping(source = "elementElementName", target = "element.elementName")
    @Mapping(source = "elementDescription", target = "element.description")
    LocationBalance locationBalanceStatementToLocationBalance(LocationBalanceStatement locationBalanceStatement);

    @InheritInverseConfiguration(name = "locationBalanceStatementToLocationBalance")
    LocationBalanceStatement locationBalanceToLocationBalanceStatement(LocationBalance locationBalance);

    @InheritConfiguration(name = "locationBalanceStatementToLocationBalance")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLocationBalanceFromLocationBalanceStatement(LocationBalanceStatement locationBalanceStatement, @MappingTarget LocationBalance locationBalance);
}
