package ee.bcs.folkcostumes.locationLog;

import ee.bcs.folkcostumes.inventory.element.ElementDto;
import ee.bcs.folkcostumes.location.LocationDto;
import ee.bcs.folkcostumes.user.UserDto;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class LocationLogDto implements Serializable {
    private final Integer id;
    private final ElementDto element;
    private final LocationDto location;
    private final UserDto user;
    private final Integer quantity;
    private final Integer balance;
    private final LocalDate transactionTime;
}
