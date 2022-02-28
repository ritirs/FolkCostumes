package ee.bcs.folkcostumes.locationManagement.locationBalance;

import ee.bcs.folkcostumes.inventory.element.Element;
import ee.bcs.folkcostumes.inventory.element.ElementService;
import ee.bcs.folkcostumes.locationManagement.TransactionLog.TransactionLogRequest;
import ee.bcs.folkcostumes.locationManagement.location.LocationService;
import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import ee.bcs.folkcostumes.userManagement.user.User;
import ee.bcs.folkcostumes.userManagement.user.UserService;
import ee.bcs.folkcostumes.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationBalanceService {

    @Resource
    private LocationBalanceMapper locationBalanceMapper;
    @Resource
    private LocationBalanceRepository locationBalanceRepository;
    @Resource
    private ValidationService validationService;
    @Resource
    private UserService userService;
    @Resource
    private LocationService locationService;
    @Resource
    private ElementService elementService;
    @Resource
    private ContactService contactService;

    private LocationBalance getLocationBalance(TransactionLogRequest request) {
        String location = request.getLocationLocation();
        String elementName = request.getElementElementName();
        String username = request.getUserUsername();
        return locationBalanceRepository.findByLocationElementNameAndUserName(location, elementName, username);
    }

    public void enoughBalance(TransactionLogRequest request) {
        Integer balance = getLocationBalance(request).getQuantity();
        validationService.sufficientBalance(balance, request.getQuantity());
    }

    public boolean existsLocationBalance(TransactionLogRequest request) {
        String location = request.getLocationLocation();
        String elementName = request.getElementElementName();
        String username = request.getUserUsername();
        return locationBalanceRepository.existsByLocationUsernameElementName(location, username, elementName);
    }

    public Integer updateBalanceAfterTransaction(TransactionLogRequest request) {
        Integer newBalance;
        if (existsLocationBalance(request)) {
            LocationBalance locationBalance = getLocationBalance(request);
            newBalance = locationBalance.getQuantity() + request.getQuantity();
            locationBalance.setQuantity(newBalance);
            locationBalanceRepository.save(locationBalance);
        } else {
            LocationBalance locationBalance = new LocationBalance();
            locationBalance.setLocation(locationService.getLocationByName(request.getLocationLocation()));
            locationBalance.setQuantity(request.getQuantity());
            String elementName = request.getElementElementName();
            Element element = elementService.getElementByName(elementName);
            locationBalance.setElement(element);
            locationBalance.setUser(userService.getValidUserName(request.getUserUsername()));
            locationBalanceRepository.save(locationBalance);
            newBalance = request.getQuantity();
        }
        return newBalance;
    }

    public List<LocationBalanceStatement> getElementsQuantitiesInLocation(String locationName) {
        Boolean existsBalanceInLocation = locationBalanceRepository.existsByLocation_Location(locationName);
        validationService.existsBalanceInLocation(existsBalanceInLocation, locationName);
        List<LocationBalance> balanceList = locationBalanceRepository.findByLocation_Location(locationName);
//        List<LocationBalanceStatement> locationBalanceStatements = new ArrayList<>();
//        for (LocationBalance locationBalance : balanceList) {
//            locationBalanceStatements.add(locationBalanceMapper.locationBalanceToLocationBalanceStatement(locationBalance));
//        }
        return compileBalanceStatement(balanceList);
    }

    public List<LocationBalanceStatement> getElementQuantitiesInLocations(String elementName) {
        Boolean existsElementBalance = locationBalanceRepository.existsByElement_ElementName(elementName);
        validationService.existsElementBalance(existsElementBalance, elementName);
        List<LocationBalance> balanceList = locationBalanceRepository.findByElement_ElementName(elementName);
//        List<LocationBalanceStatement> balanceStatements = new ArrayList<>();
//        for (LocationBalance locationBalance : balanceList) {
//            balanceStatements.add(locationBalanceMapper.locationBalanceToLocationBalanceStatement(locationBalance));
//        }
        return compileBalanceStatement(balanceList);
    }

    public User getUSerByFirstLastname(String firstname, String lastname) {
        return userService.getUserByFirstLastname(firstname, lastname);
    }

    public List<LocationBalanceStatement> getElementsByUser(String firstname, String lastname) {
        User user = contactService.getUserByNames(firstname, lastname);
        Boolean existsUserBalance = locationBalanceRepository.existsByUser(user);
        validationService.existsBalanceByUser(existsUserBalance);
        List<LocationBalance> balanceList = locationBalanceRepository.findByUser(user);
        return compileBalanceStatement(balanceList);
    }

    private List<LocationBalanceStatement> compileBalanceStatement(List<LocationBalance> balanceList) {
        List<LocationBalanceStatement> balanceStatements = new ArrayList<>();
        for (LocationBalance locationBalance : balanceList) {
            balanceStatements.add(locationBalanceMapper.locationBalanceToLocationBalanceStatement(locationBalance));
        }
        return balanceStatements;
    }
}
