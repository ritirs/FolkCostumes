package ee.bcs.folkcostumes.userManagement.roleInGroup;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RoleInGroupRepository extends JpaRepository<RoleInGroup, Integer> {

    List<RoleInGroup> findUserRolesInGroupsByUser_Id(Integer id);

    List<RoleInGroup> findByGroup_GroupName(String groupName);

    boolean existsByGroup_GroupName(String groupName);

    boolean existsByGroup_GroupNameAndUser_Id(String groupName, Integer id);








}