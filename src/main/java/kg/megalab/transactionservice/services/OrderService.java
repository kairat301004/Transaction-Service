package kg.megalab.transactionservice.services;

import kg.megalab.transactionservice.enums.Status;
import kg.megalab.transactionservice.enums.TypeOfAction;
import kg.megalab.transactionservice.models.Balance;
import kg.megalab.transactionservice.models.BalanceHistory;
import kg.megalab.transactionservice.models.BalanceLog;
import kg.megalab.transactionservice.models.User;
import kg.megalab.transactionservice.repository.BalanceHistoryRepo;
import kg.megalab.transactionservice.repository.BalanceLogRepo;
import kg.megalab.transactionservice.repository.BalanceRepo;
import kg.megalab.transactionservice.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;


@Service
public class OrderService {

    private final UserRepo userRepo;
    private final BalanceRepo balanceRepo;
    private final BalanceHistoryRepo balanceHistoryRepo;
    private final BalanceLogRepo balanceLogRepo;

    public OrderService(UserRepo userRepo, BalanceRepo balanceRepo, BalanceHistoryRepo balanceHistoryRepo, BalanceLogRepo balanceLogRepo) {
        this.userRepo = userRepo;
        this.balanceRepo = balanceRepo;
        this.balanceHistoryRepo = balanceHistoryRepo;
        this.balanceLogRepo = balanceLogRepo;
    }

    @Transactional
    public void placeOrder(Integer user_id, double amount) {
        User user = userRepo.findById(user_id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Balance balance = user.getBalance();
        if (balance.getBalance() < amount) {
            throw new RuntimeException("Lack of balance");
        }

        balance.setBalance(balance.getBalance() - amount);
        balanceRepo.save(balance);

        BalanceHistory balanceHistory = new BalanceHistory();
        balanceHistory.setAddDate(new Timestamp(System.currentTimeMillis()));
        balanceHistory.setAmount(-amount);
        balanceHistory.setBalance(balance);
        balanceHistoryRepo.save(balanceHistory);

        BalanceLog balanceLog = new BalanceLog();
        balanceLog.setAddDate(new Timestamp(System.currentTimeMillis()));
        balanceLog.setStatus(Status.OK);
        balanceLog.setMessage("Transaction successfully");
        balanceLog.setTypeOfAction(TypeOfAction.Снятие);
        balanceLog.setBalance(balance);
        balanceLogRepo.save(balanceLog);
    }



}
