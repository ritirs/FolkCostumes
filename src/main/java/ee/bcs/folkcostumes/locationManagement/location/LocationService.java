package ee.bcs.folkcostumes.locationManagement.location;

import ee.bcs.folkcostumes.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    @Resource
    private LocationRepository locationRepository;
    @Resource
    private LocationMapper locationMapper;
    @Resource
    private ValidationService validationService;

    public List<String> getAllLocationNames() {
        List<String> locationNames = new ArrayList<>();
        List<Location> allLocations = locationRepository.findAll();
        for (Location location : allLocations) {
            locationNames.add(location.getLocation());
        }
        return locationNames;
    }

//    public void addNewLocation(String newLocation) {
//        boolean locationExists = locationRepository.existsByLocation(newLocation);
//        validationService.locationExists(locationExists, newLocation);
//        locationMapper.newLocationNameToLocation(newLocation);
//    }

    public void addNewLocations(List<String> newLocationNames) {
        for (String newLocationName : newLocationNames) {
            boolean locationExists = locationRepository.existsByLocation(newLocationName);
            validationService.locationExists(locationExists, newLocationName);
            locationMapper.newLocationNameToLocation(newLocationName);
        }
    }

    public Location getLocationByName(String locationLocation) {
        return locationRepository.findByLocation(locationLocation);
    }
}
