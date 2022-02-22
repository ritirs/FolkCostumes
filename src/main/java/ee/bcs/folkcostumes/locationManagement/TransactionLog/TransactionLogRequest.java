package ee.bcs.folkcostumes.locationManagement.TransactionLog;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TransactionLogRequest implements Serializable {
    private final String elementElementName;
    private final String locationLocation;
    private final String userUsername;
    private final Integer quantity;
    private final LocalDate transactionTime;
}
