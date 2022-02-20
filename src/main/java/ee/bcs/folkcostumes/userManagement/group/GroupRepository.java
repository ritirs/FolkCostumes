package ee.bcs.folkcostumes.userManagement.group;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    Group findByGroupName(String groupName);

}