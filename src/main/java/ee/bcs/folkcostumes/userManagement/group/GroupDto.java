package ee.bcs.folkcostumes.userManagement.group;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupDto implements Serializable {
    private final Integer id;
    private final String groupName;
}
