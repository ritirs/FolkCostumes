package ee.bcs.folkcostumes.userManagement.roleType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleTypeRepository extends JpaRepository<RoleType, Integer> {
    RoleType findByName(String name);


}