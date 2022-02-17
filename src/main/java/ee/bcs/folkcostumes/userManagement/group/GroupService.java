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
        Group newGroup = new Group();
        newGroup.setGroupName(newGroupName);
        groupRepository.save(newGroup);
        return groupMapper.groupToGroupDto(newGroup);

    }

    public String updateGroup(String oldGroupName, String newName) {
        GroupDto oldGroupDto = getGroupByName(oldGroupName);
        Group group = groupMapper.groupDtoToGroup(oldGroupDto);
        group.setGroupName(newName);
        groupRepository.save(group);
        return "\"" + oldGroupName + "\"" + " muudetud uueks nimetuseks \"" + newName + "\"";
    }

    public GroupDto getGroupByName(String groupName) {
        Group group = groupRepository.findByGroupName(groupName);
        return groupMapper.groupToGroupDto(group);
    }

    public List<String> getAllGroupNames() {
        List<Group> all = groupRepository.findAll();
//        List<GroupDto> groupNamesDtos = groupMapper.groupToGroupDto(all);
        List<String> groupNames = new ArrayList<>();
        for (Group group : all) {
            groupNames.add(group.getGroupName());
        }
        return groupNames;
    }

}
