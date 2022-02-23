package ee.bcs.folkcostumes.locationManagement.TransactionLog;

import ee.bcs.folkcostumes.inventory.element.ElementService;
import ee.bcs.folkcostumes.locationManagement.location.LocationService;
import ee.bcs.folkcostumes.locationManagement.locationBalance.LocationBalanceService;
import ee.bcs.folkcostumes.userManagement.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionLogService {

    @Resource
    private TransactionLogRequestMapper transactionLogRequestMapper;
    @Resource
    private TransactionLogRepository transactionLogRepository;
    @Resource
    private TransactionLogMapper transactionLogMapper;
    @Resource
    private LocationBalanceService locationBalanceService;
    @Resource
    private LocationService locationService;
    @Resource
    private UserService userService;
    @Resource
    private ElementService elementService;

    public void makeElementTransaction(TransactionLogRequest request) {
        locationBalanceService.existsLocationBalance(request);
//        locationBalanceService.enoughBalance(request);
        TransactionLog incomingTransaction = transactionLogRequestMapper.transactionLogRequestToTransactionLog(request);
        incomingTransaction.setUser(userService.getValidUserName(request.getUserUsername()));
        incomingTransaction.setBalance(locationBalanceService.updateBalanceAfterTransaction(request));
        incomingTransaction.setLocation(locationService.getLocationByName(request.getLocationLocation()));
        incomingTransaction.setElement(elementService.getElementByName(request.getElementElementName()));
        transactionLogRepository.save(incomingTransaction);
// tabelis võiks olla märkuse väli iga transaktsiooni juures
    }
//
//    public void takeElementOutOf(TransactionLogRequest request) {
//        locationBalanceService.enoughBalance(request);
//        TransactionLog transaction = transactionLogRequestMapper.transactionLogRequestToTransactionLog(request);
//        transaction.setUser(userService.getValidUserName(request.getUserUsername()));
//        transaction.setLocation(locationService.getLocationByName(request.getLocationLocation()));
//        transaction.setElement(elementService.getElementByName(request.getElementElementName()));
//        Integer newBalance = locationBalanceService.updateOutGoingBalance(request);
//        transaction.setBalance(newBalance);
//        transactionLogRepository.save(transaction);
//    }

    public List<TransactionLogRequest> getTransactionsInPeriod(LocalDate startingDate, LocalDate endingDate) {
        List<TransactionLog> transactionTimeIsBetween = transactionLogRepository.findByTransactionTimeIsBetween(startingDate, endingDate);
        return transactionLogRequestMapper.transactionLogsToTransactionLogRequests(transactionTimeIsBetween);
    }
}
