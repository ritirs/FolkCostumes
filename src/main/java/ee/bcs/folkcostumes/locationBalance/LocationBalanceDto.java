package ee.bcs.folkcostumes.locationBalance;

import ee.bcs.folkcostumes.inventory.element.ElementDto;
import ee.bcs.folkcostumes.location.LocationDto;
import ee.bcs.folkcostumes.user.UserDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class LocationBalanceDto implements Serializable {
    private final Integer id;
    private final LocationDto location;
    private final ElementDto element;
    private final UserDto user;
    private final Integer quantity;
}
