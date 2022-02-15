package ee.bcs.folkcostumes.locationLog;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationLogMapper {
    LocationLog locationLogDtoToLocationLog(LocationLogDto locationLogDto);

    LocationLogDto locationLogToLocationLogDto(LocationLog locationLog);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLocationLogFromLocationLogDto(LocationLogDto locationLogDto, @MappingTarget LocationLog locationLog);
}
