package ee.bcs.folkcostumes.locationManagement.locationBalance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface LocationBalanceRepository extends JpaRepository<LocationBalance, Integer> {

    @Query("select l from LocationBalance l " +
            "where l.location.location = ?1 and l.element.elementName = ?2 and l.user.username = ?3")
    LocationBalance findByLocationElementNameAndUserName(String location, String elementName, String username);



}