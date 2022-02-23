package ee.bcs.folkcostumes.locationManagement;

import ee.bcs.folkcostumes.locationManagement.TransactionLog.TransactionLogRequest;
import ee.bcs.folkcostumes.locationManagement.location.LocationService;
import ee.bcs.folkcostumes.locationManagement.locationBalance.LocationBalanceService;
import ee.bcs.folkcostumes.locationManagement.TransactionLog.TransactionLogService;
import ee.bcs.folkcostumes.locationManagement.locationBalance.LocationBalanceStatement;
import ee.bcs.folkcostumes.userManagement.user.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationManagementController {

    @Resource
    private LocationService locationService;
    @Resource
    private LocationBalanceService locationBalanceService;
    @Resource
    private TransactionLogService transactionLogService;

    @GetMapping("/get/all")
    public List<String> getAllLocations() {
        return locationService.getAllLocationNames();
    }

//    ToDO: see meetod annab errorit. parandada
    @PostMapping("/add/locations")
    public String addLocations(@RequestParam List<String> newLocations) {
        locationService.addNewLocations(newLocations);
        return "Uued lao asukohad lisatud.";
    }

    @PostMapping("/make/element/transaction")
    public String addElementInTo(@RequestBody TransactionLogRequest request) {
        transactionLogService.makeElementTransaction(request);
        return "Andmed sisestatud.";
    }

    @GetMapping("get/element/quantities/in/locations")
    public List<LocationBalanceStatement> getElementQuantitiesInLocations(@RequestParam String elementName) {
        return locationBalanceService.getElementQuantitiesInLocations(elementName);
    }

    @GetMapping("get/elements/quantities/in/location")
    public List<LocationBalanceStatement> getElementsQuantitiesInLocation(@RequestParam String location) {
        return locationBalanceService.getElementsQuantitiesInLocation(location);
    }
//  TODO: siin on midagi valesti, ei anna õiget tulemust, paranda
    @GetMapping("/get/elements/by/user")
    public List<LocationBalanceStatement> getElementsByUser(@RequestParam String firstName, @RequestParam String lastName) {
        User user = locationBalanceService.getUSerByFirstLastname(firstName, lastName);
        return locationBalanceService.getElementsByUser(user);
    }


    //   TODO: ei tööta. ei saa aru, miks kuupäeva sisse ei võta.
    @GetMapping("get/transactions/in/period")
    public LocalDate getTransactionsInPeriod(@RequestParam LocalDate endingDate) {
        return endingDate;
    }
//    LocalDate endingDate
//    public List<TransactionLogRequest> getTransactionsInPeriod(LocalDate startingDate, LocalDate endingDate) {
//            return transactionLogService.getTransactionsInPeriod(startingDate, endingDate);
//    sama teema järgmiste aruannetega, neid praegu tegema ei hakka:
    //    @GetMapping("get/transactions/by/element/in/period")
//    @GetMapping("get/transactions/by/costume/in/period")
//    @GetMapping("get/transactions/by/location/in/period")


//    @GetMapping("get/quantities/of/costume/elements/in/locations")


}
