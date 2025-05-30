package nure.ua.springbank.model.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
@Data
public class BankAccount {
    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long accountId;
    private String name;
    private String surname;
    private String number;
    private double balance;
    //Додана реалізація для 100%
    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

}
























