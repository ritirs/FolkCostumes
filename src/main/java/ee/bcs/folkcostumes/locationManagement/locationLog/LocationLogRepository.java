package ee.bcs.folkcostumes.locationManagement.locationLog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationLogRepository extends JpaRepository<LocationLog, Integer> {
}