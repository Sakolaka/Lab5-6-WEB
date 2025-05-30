package nure.ua.springbank.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class IncorrectAmountOfMoney extends RuntimeException {

}
