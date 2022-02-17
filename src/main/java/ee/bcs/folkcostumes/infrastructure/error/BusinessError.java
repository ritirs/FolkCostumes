package ee.bcs.folkcostumes.infrastructure.error;

import lombok.Data;

@Data
public class BusinessError {
    private String message;
    private Integer errorCode;
}
