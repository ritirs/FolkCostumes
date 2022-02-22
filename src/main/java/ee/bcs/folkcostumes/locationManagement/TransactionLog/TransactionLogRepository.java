package ee.bcs.folkcostumes.locationManagement.TransactionLog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, Integer> {

    List<TransactionLog> findByTransactionTimeIsBetween(LocalDate transactionTimeStart, LocalDate transactionTimeEnd);


}