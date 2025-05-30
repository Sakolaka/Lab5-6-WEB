//Додана реалізація для 100%
package nure.ua.springbank.repository;

import nure.ua.springbank.model.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findByBankAccount_AccountId(Long accountId);
}
