package ee.bcs.folkcostumes.userManagement.roleInGroup;

import ee.bcs.folkcostumes.userManagement.contact.ContactDto;
import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleInGroupService {

    @Resource
    private RoleInGroupMapper roleInGroupMapper;

    @Resource
    private RoleInGroupRepository roleInGroupRepository;

    @Resource
    private ContactService contactService;

    public RoleInGroupDto addNewRoleToUser(RoleInGroupRequest request) {
        Integer userId = contactService.getContactDtoByName(request.getFirstname(), request.getLastname());
        ContactDto contactDto =contactService.getContactDtoByUserId(userId);

//        RoleInGroup roleInGroup = new RoleInGroup();


        return null;
    }

    public List<RoleInGroupDto> rolesInGroups(Integer userId) {
        List<RoleInGroup> rolesInGroup = roleInGroupRepository.findByUser_Id(userId);
        return roleInGroupMapper.roleInGroupToRoleInGroupDtos(rolesInGroup);
    }
}
