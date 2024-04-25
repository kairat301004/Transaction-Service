package kg.megalab.transactionservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "balances")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double balance;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "balance")
    private List<BalanceHistory> balanceHistories;

    @OneToMany(mappedBy = "balance")
    private List<BalanceLog> balanceLogs;


}
