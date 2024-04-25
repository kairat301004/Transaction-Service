package kg.megalab.transactionservice.controller;

import kg.megalab.transactionservice.dto.TransactionDto;
import kg.megalab.transactionservice.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1")
public class TransactionalController {
    private final OrderService orderService;

    public TransactionalController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<String> makeTransaction(@RequestBody TransactionDto request){
        orderService.placeOrder(request.getUser_id(), request.getAmount());
        return ResponseEntity.ok("Транзакция успешно прошла");


    }

}
