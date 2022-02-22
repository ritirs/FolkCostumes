package ee.bcs.folkcostumes.locationManagement.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface LocationRepository extends JpaRepository<Location, Integer> {
    boolean existsByLocation(String location);

    Location findByLocation(String location);






}