package nure.ua.springbank.model;
import lombok.Data;

@Data
public class UpdateBalanceBody {
    private long accountId;
    private double amount;
}
