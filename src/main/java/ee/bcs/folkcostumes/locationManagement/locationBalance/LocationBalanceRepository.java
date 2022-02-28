package ee.bcs.folkcostumes.locationManagement.locationBalance;

import ee.bcs.folkcostumes.userManagement.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationBalanceRepository extends JpaRepository<LocationBalance, Integer> {

    @Query("select l from LocationBalance l " +
            "where l.location.location = ?1 and l.element.elementName = ?2 and l.user.username = ?3")
    LocationBalance findByLocationElementNameAndUserName(String location, String elementName, String username);

    List<LocationBalance> findByLocation_Location(String location);
    List<LocationBalance> findByElement_ElementName(String elementName);
    List<LocationBalance> findByUser(User user);




    @Query("select (count(l) > 0) from LocationBalance l " +
            "where l.location.location = ?1 and l.user.username = ?2 and l.element.elementName = ?3")
    boolean existsByLocationUsernameElementName(String location, String username, String elementName);

    boolean existsByLocation_Location(String location);
    boolean existsByElement_ElementName(String elementName);

    boolean existsByUser(User user);

    boolean existsByUser_Username(String username);

    boolean existsByUser_Id(Integer id);















}