package ma.enset.elaaraj.nawal.implementation_micro_service.entities;

import ma.enset.elaaraj.nawal.implementation_micro_service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    String getId();
    AccountType getType();
    Double getBalance();
}
