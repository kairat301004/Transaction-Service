package kg.megalab.transactionservice.dto;

import lombok.Data;

@Data
public class TransactionDto {
    private Integer user_id;
    private double amount;
}
