package nure.ua.springbank;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankConfiguration {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
