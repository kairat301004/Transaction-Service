package kg.megalab.transactionservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Entity
@Table(name = "balance_histories")
public class BalanceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp addDate;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "balance_id", referencedColumnName = "id")
    private Balance balance;

}
