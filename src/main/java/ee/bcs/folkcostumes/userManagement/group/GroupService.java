package ee.bcs.folkcostumes.userManagement.group;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    @Resource
    private GroupMapper groupMapper;

    @Resource
    private GroupRepository groupRepository;


    public GroupDto addNewGroup(String newGroupName) {
        Group group = groupMapper.newGroupNameToGroup(newGroupName);
        groupRepository.save(group);
        return groupMapper.groupToGroupDto(group);

    }

    public String updateGroupName(String oldGroupName, String newName) {
        Group group = getGroupByName(oldGroupName);
        group.setGroupName(newName);
        groupRepository.save(group);
        return "\"" + oldGroupName + "\"" + " muudetud uueks nimetuseks \"" + newName + "\"";
    }

    public Group getGroupByName(String groupName) {
        return groupRepository.findByGroupName(groupName);
    }

    public List<String> getAllGroupNames() {
        List<Group> all = groupRepository.findAll();
        List<String> groupNames = new ArrayList<>();
        for (Group group : all) {
            groupNames.add(group.getGroupName());
        }
        return groupNames;
    }


    public GroupDto getGroupDtoByName(String groupName) {
        Group byGroupName = groupRepository.findByGroupName(groupName);
        return groupMapper.groupToGroupDto(byGroupName);
    }

}
