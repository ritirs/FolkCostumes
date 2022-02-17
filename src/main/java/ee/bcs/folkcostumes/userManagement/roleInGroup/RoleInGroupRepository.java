package ee.bcs.folkcostumes.userManagement.roleInGroup;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleInGroupRepository extends JpaRepository<RoleInGroup, Integer> {
    List<RoleInGroup> findByUser_Id(Integer id);


}