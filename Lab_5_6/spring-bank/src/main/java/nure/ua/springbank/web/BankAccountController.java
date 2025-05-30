package nure.ua.springbank.web;
import jakarta.validation.Valid;
import nure.ua.springbank.model.BankAccountDTO;
import nure.ua.springbank.model.UpdateBalanceBody;
import nure.ua.springbank.model.entity.Transaction;
import nure.ua.springbank.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BankAccountController {
    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService service) {

        this.bankAccountService = service;
    }

    @GetMapping("/{accountId}")
    public double getBankAccountBalance(@PathVariable Long accountId) {

        return bankAccountService.getAccountBalance(accountId);

    }

    @PostMapping("/account")
    public BankAccountDTO createBankAccount(@Valid @RequestBody BankAccountDTO bankAccountDTO) {

       return bankAccountService.createAccount(bankAccountDTO);

    }
    @PutMapping("/update/balance")
    public void updateBalance(@RequestBody UpdateBalanceBody body) {
        bankAccountService.updateBalance(body);
    }

    //Додана реалізація для 90%
    @GetMapping("/accounts")
    public Iterable<BankAccountDTO> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }
    @DeleteMapping("/account/{accountId}")
    public void deleteAccount(@PathVariable Long accountId) {
        bankAccountService.deleteAccount(accountId);
    }

    //Додана реалізація для 100%
    @GetMapping("/account/{accountId}/transactions")
    public List<Transaction> getAccountTransactions(@PathVariable Long accountId) {
        return bankAccountService.getTransactionsForAccount(accountId);
    }


}

































