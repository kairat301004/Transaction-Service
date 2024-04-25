package kg.megalab.transactionservice.repository;

import kg.megalab.transactionservice.models.BalanceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceHistoryRepo extends JpaRepository<BalanceHistory, Integer> {
}
