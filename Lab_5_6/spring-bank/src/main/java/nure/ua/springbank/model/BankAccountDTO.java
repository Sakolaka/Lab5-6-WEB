package nure.ua.springbank.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BankAccountDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long accountId;
    private String name;
    @NotNull
    private String surname;
    @NotNull
    @NotEmpty
    private String number;
    @Min(value=0)
    private double balance;
}
