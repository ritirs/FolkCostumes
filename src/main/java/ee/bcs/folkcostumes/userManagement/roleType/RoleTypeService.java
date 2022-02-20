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
        RoleType newRoleType = roleTypeMapper.newNameToRoleType(newRoleTypeName);
        roleTypeRepository.save(newRoleType);
        return roleTypeMapper.roleTypeToRoleTypeDto(newRoleType);
    }

    public RoleTypeDto getRoleTypeDtoByName(String roleTypeName) {
        RoleType roleType = roleTypeRepository.findByName(roleTypeName);
        return roleTypeMapper.roleTypeToRoleTypeDto(roleType);
    }

    public RoleType getRoleTypeByName(String roleTypename) {
        return roleTypeRepository.findByName(roleTypename);
    }

    public String updateRoleTypeName(String oldRoleTypeName, String newRoleTypeName) {
        RoleTypeDto oldRoleTypeDto = getRoleTypeDtoByName(oldRoleTypeName);
        RoleType roleType = roleTypeMapper.roleTypeDtoToRoleType(oldRoleTypeDto);
        roleType.setName(newRoleTypeName);
        roleTypeRepository.save(roleType);
        return "\"" + oldRoleTypeName + "\"" + " muudetud uueks nimetuseks \"" + roleType.getName() + "\"";
    }

    public List<String> getAllRoleTypeNames() {
        List<RoleType> allRoleTypes = roleTypeRepository.findAll();
        List<String> roleTypeNames = new ArrayList<>();
        for (RoleType roleType : allRoleTypes) {
            roleTypeNames.add(roleType.getName());
        }
        return roleTypeNames;
    }
}
