package kg.megalab.transactionservice.repository;

import kg.megalab.transactionservice.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepo extends JpaRepository<Balance, Integer> {
}
