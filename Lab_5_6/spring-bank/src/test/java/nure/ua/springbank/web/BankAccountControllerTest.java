package nure.ua.springbank.web;


import nure.ua.springbank.exeptions.BankAccountNotFoundExeption;
import nure.ua.springbank.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankAccountControllerTest {
    @Mock
    private BankAccountService bankAccountService;
    @InjectMocks
    private BankAccountController controller;

    @Test
    public void BalanceIncorrectAccountId() {
        long accountId = 12L;
        when (bankAccountService.getAccountBalance(accountId)).thenThrow(new BankAccountNotFoundExeption(accountId));
        assertThrows(BankAccountNotFoundExeption.class, ()-> controller.getBankAccountBalance(accountId));
    }

    @Test
    public void getBalanceSuccess() {
        long accountId = 12L;
        when (bankAccountService.getAccountBalance(accountId)).thenReturn(10.0);
        double result = controller.getBankAccountBalance(accountId);
        assertTrue ( result == 10.0);
    }
}
