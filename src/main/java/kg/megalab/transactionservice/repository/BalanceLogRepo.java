package kg.megalab.transactionservice.repository;

import kg.megalab.transactionservice.models.BalanceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceLogRepo extends JpaRepository<BalanceLog, Integer> {
}
