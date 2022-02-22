package ee.bcs.folkcostumes.locationManagement.TransactionLog;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionLogRequestMapper {
//    @Mapping(source = "elementId", target = "element.id")
//    @Mapping(source = "elementElementTypeElementType", target = "element.elementType.elementType")
    @Mapping(source = "elementElementName", target = "element.elementName")
//    @Mapping(source = "locationLocation", target = "location.location")
//    @Mapping(source = "userUsername", target = "user.username")
    TransactionLog transactionLogRequestToTransactionLog(TransactionLogRequest transactionLogRequest);

    @InheritInverseConfiguration(name = "transactionLogRequestToTransactionLog")
    TransactionLogRequest transactionLogsToTransactionLogRequests(TransactionLog transactionLog);

    @InheritInverseConfiguration(name = "transactionLogRequestToTransactionLog")
    List<TransactionLogRequest> transactionLogsToTransactionLogRequests(List<TransactionLog> transactionLogs);

    @InheritConfiguration(name = "transactionLogRequestToTransactionLog")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTransactionLogFromTransactionLogRequest(TransactionLogRequest transactionLogRequest, @MappingTarget TransactionLog transactionLog);
}
