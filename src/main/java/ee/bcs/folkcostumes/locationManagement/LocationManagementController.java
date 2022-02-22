package ee.bcs.folkcostumes.locationManagement;

import ee.bcs.folkcostumes.locationManagement.TransactionLog.TransactionLogRequest;
import ee.bcs.folkcostumes.locationManagement.location.LocationService;
import ee.bcs.folkcostumes.locationManagement.locationBalance.LocationBalanceService;
import ee.bcs.folkcostumes.locationManagement.TransactionLog.TransactionLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
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

    @PostMapping("/add/locations")
    public String addLocations(@RequestBody List<String> newLocations) {
        locationService.addNewLocations(newLocations);
        return "Uued lao asukohad lisatud.";
    }

    @PostMapping("/add/element/into")
    public String addElementInTo(@RequestBody TransactionLogRequest request) {
        transactionLogService.addElementInTo(request);
        return "Andmed sisestatud.";
    }

    @PostMapping("/take/element/out/of")
    public String takeElementOutOf(@RequestBody TransactionLogRequest request) {
        transactionLogService.takeElementOutOf(request);
        return "Andmed sisestatud.";
    }

    @GetMapping("get/transactions/in/period")
    public List<TransactionLogRequest> getTransactionsInPeriod(LocalDate startingDate, LocalDate endingDate) {
        return transactionLogService.getTransactionsInPeriod(startingDate, endingDate);
    }

//    @GetMapping("get/transactions/by/element/in/period")
//    @GetMapping("get/transactions/by/costume/in/period")
//    @GetMapping("get/transactions/by/location/in/period")
//    @GetMapping("get/quantities/elements/in/location")
//    @GetMapping("get/quantities/element/in/locations")
//    @GetMapping("get/quantities/of/costume/elements/in/locations")

}
