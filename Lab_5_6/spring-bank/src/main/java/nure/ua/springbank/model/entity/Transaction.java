//Додана реалізація для 100%
package nure.ua.springbank.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;

    private LocalDateTime timestamp;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "account_id")
    private BankAccount bankAccount;
}
