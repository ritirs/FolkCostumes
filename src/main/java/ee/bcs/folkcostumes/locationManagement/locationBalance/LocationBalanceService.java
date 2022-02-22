package ee.bcs.folkcostumes.locationManagement.locationBalance;

import ee.bcs.folkcostumes.locationManagement.TransactionLog.TransactionLogRequest;
import ee.bcs.folkcostumes.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LocationBalanceService {

    @Resource
    private LocationBalanceMapper locationBalanceMapper;
    @Resource
    private LocationBalanceRepository locationBalanceRepository;
    @Resource
    private ValidationService validationService;

    public Integer getBalance(TransactionLogRequest request) {
        LocationBalance balance = getLocationBalance(request);
        return balance.getQuantity();
    }

    private LocationBalance getLocationBalance(TransactionLogRequest request) {
        String location = request.getLocationLocation();
        String elementName = request.getElementElementName();
        String username = request.getUserUsername();
        LocationBalance balance = locationBalanceRepository.findByLocationElementNameAndUserName(location, elementName, username);
        return balance;
    }


    public void enoughBalance(TransactionLogRequest request) {
        Integer balance = getLocationBalance(request).getQuantity();
        validationService.sufficientBalance(balance, request.getQuantity());
    }

    public Integer updateIncomingBalance(TransactionLogRequest request) {
        LocationBalance locationBalance = getLocationBalance(request);
        Integer newBalance = locationBalance.getQuantity() + request.getQuantity();
        locationBalance.setQuantity(newBalance);
        locationBalanceRepository.save(locationBalance);
        return newBalance;
    }

    public Integer updateOutGoingBalance(TransactionLogRequest request) {
        LocationBalance locationBalance = getLocationBalance(request);
        Integer newBalance = locationBalance.getQuantity() - request.getQuantity();
        locationBalance.setQuantity(newBalance);
        locationBalanceRepository.save(locationBalance);
        return newBalance;
    }

}
