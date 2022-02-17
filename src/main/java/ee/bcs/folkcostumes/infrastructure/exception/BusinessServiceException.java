package ee.bcs.folkcostumes.infrastructure.exception;

import lombok.Data;

@Data
public class BusinessServiceException extends RuntimeException {
    private String message;
    private Integer errorCode;

    public BusinessServiceException(String message, Integer errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
