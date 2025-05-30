package nure.ua.springbank.repository;
import nure.ua.springbank.model.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
