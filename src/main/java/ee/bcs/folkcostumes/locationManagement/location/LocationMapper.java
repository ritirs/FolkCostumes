package ee.bcs.folkcostumes.locationManagement.location;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {
    Location locationDtoToLocation(LocationDto locationDto);

    LocationDto locationToLocationDto(Location location);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLocationFromLocationDto(LocationDto locationDto, @MappingTarget Location location);

    @Mapping(target = "location", source = "newLocation")
    Location newLocationNameToLocation(String newLocation);
}
