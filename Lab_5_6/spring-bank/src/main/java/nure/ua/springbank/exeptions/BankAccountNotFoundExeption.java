package nure.ua.springbank.exeptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BankAccountNotFoundExeption extends RuntimeException {
    public BankAccountNotFoundExeption(Long id) {
        super("Not found bank account with id" + id);
    }
}
