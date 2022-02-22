package ee.bcs.folkcostumes.locationManagement.TransactionLog;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionLogMapper {
    TransactionLog locationLogDtoToLocationLog(TransactionLogDto locationLogDto);

    TransactionLogDto locationLogToLocationLogDto(TransactionLog locationLog);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLocationLogFromLocationLogDto(TransactionLogDto locationLogDto, @MappingTarget TransactionLog locationLog);
}
