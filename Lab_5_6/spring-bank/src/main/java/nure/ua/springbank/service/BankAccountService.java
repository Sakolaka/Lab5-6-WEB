package nure.ua.springbank.service;
import nure.ua.springbank.exeptions.BankAccountNotFoundExeption;
import nure.ua.springbank.exeptions.IncorrectAmountOfMoney;
import nure.ua.springbank.model.BankAccountDTO;
import nure.ua.springbank.model.UpdateBalanceBody;
import nure.ua.springbank.model.entity.BankAccount;
import nure.ua.springbank.model.entity.Transaction;
import nure.ua.springbank.repository.BankAccountRepository;
import nure.ua.springbank.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;


@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final ModelMapper modelMapper;

    public BankAccountService(BankAccountRepository bankAccountRepository, ModelMapper modelMapper, TransactionRepository transactionRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.modelMapper = modelMapper;
        //Додана реалізація для 100%
        this.transactionRepository = transactionRepository;
    }




    public double getAccountBalance(Long accountId) {
        return getAccount(accountId).getBalance();
        }

        public BankAccount getAccount(Long accountId) {
            Optional<BankAccount> bankAccount = bankAccountRepository.findById(accountId);
            if(bankAccount.isEmpty()){
                throw new BankAccountNotFoundExeption(accountId);
            } else {
                return bankAccount.get();
            }
        }

    public BankAccountDTO createAccount(BankAccountDTO bankAccountDTO) {
        BankAccount bankAccount = modelMapper.map(bankAccountDTO, BankAccount.class);
        BankAccount createdAccount = bankAccountRepository.save(bankAccount);
        return modelMapper.map(createdAccount, BankAccountDTO.class);

    }

    public void updateBalance(UpdateBalanceBody body) {
        BankAccount bankAccount = getAccount(body.getAccountId());
        double newBalance = bankAccount.getBalance() + body.getAmount();

        if (newBalance < 0) {
            throw new IncorrectAmountOfMoney();
        }
        bankAccount.setBalance(newBalance);
        bankAccountRepository.save(bankAccount);

        //Додана реалізація для 100%
        Transaction transaction = new Transaction();
        transaction.setAmount(body.getAmount());
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setBankAccount(bankAccount);
        transactionRepository.save(transaction);
    }
    
    //Додана реалізація для 90%
    public Iterable<BankAccountDTO> getAllAccounts() {
        Iterable<BankAccount> accounts = bankAccountRepository.findAll();
        List<BankAccountDTO> result = new ArrayList<>();
        for (BankAccount account : accounts) {
            result.add(modelMapper.map(account, BankAccountDTO.class));
        }
        return result;
    }
    public void deleteAccount(Long accountId) {
        if (!bankAccountRepository.existsById(accountId)) {
            throw new BankAccountNotFoundExeption(accountId);
        }
        bankAccountRepository.deleteById(accountId);
    }

    //Додана реалізація для 100%
    private final TransactionRepository transactionRepository;
    public List<Transaction> getTransactionsForAccount(Long accountId) {
        getAccount(accountId); // Перевірка існування
        return transactionRepository.findByBankAccount_AccountId(accountId);
    }



}





















