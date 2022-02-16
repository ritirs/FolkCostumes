package ee.bcs.folkcostumes.userManagement.roleType;


import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleTypeService {

    @Resource
    private RoleTypeMapper roleTypeMapper;

    @Resource
    private RoleTypeRepository roleTypeRepository;


    public RoleTypeDto addNewRoleType(String newRoleTypeName) {
        RoleType newRoleType = new RoleType();
        newRoleType.getId();
        newRoleType.setName(newRoleTypeName);
        roleTypeRepository.save(newRoleType);
        return roleTypeMapper.roleTypeToRoleTypeDto(newRoleType);
    }

    public RoleTypeDto getByRoleTypeName(String roleTypeName) {
        RoleType roleType = roleTypeRepository.findByName(roleTypeName);
        return roleTypeMapper.roleTypeToRoleTypeDto(roleType);
    }

    public String updateRoleTypeName(String oldRoleTypeName, String newRoleTypeName) {
        RoleTypeDto oldRoleTypeDto = getByRoleTypeName(oldRoleTypeName);
        RoleType roleType = roleTypeMapper.roleTypeDtoToRoleType(oldRoleTypeDto);
        roleType.setName(newRoleTypeName);
        roleTypeRepository.save(roleType);
        return "\"" + oldRoleTypeName + "\"" + " muudetud uueks nimetuseks \"" + roleType.getName() + "\"";
    }

    public List<String> getAllRoleTypeNames() {
        List<RoleType> allRoleTypes = roleTypeRepository.findAll();
//        List<RoleTypeDto> roleTypeDtos = roleTypeMapper.
        List<String> roleTypeNames = new ArrayList<>();
        for (RoleType roleType : allRoleTypes) {
            roleTypeNames.add(roleType.getName());
        }
        return roleTypeNames;
    }
}
