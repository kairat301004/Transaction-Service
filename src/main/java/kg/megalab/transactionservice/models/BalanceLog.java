package kg.megalab.transactionservice.models;

import jakarta.persistence.*;
import kg.megalab.transactionservice.enums.Status;
import kg.megalab.transactionservice.enums.TypeOfAction;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Entity
@Table(name = "balance_logs")
public class BalanceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp addDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String message;
    @Enumerated(EnumType.STRING)
    private TypeOfAction typeOfAction;

    @ManyToOne()
    @JoinColumn(name = "balance_id", referencedColumnName = "id")
    private Balance balance;
}
