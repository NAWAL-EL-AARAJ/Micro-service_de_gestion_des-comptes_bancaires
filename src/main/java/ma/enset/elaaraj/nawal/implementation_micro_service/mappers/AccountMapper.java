package ma.enset.elaaraj.nawal.implementation_micro_service.mappers;

import ma.enset.elaaraj.nawal.implementation_micro_service.dto.BankAccountResponseDTO;
import ma.enset.elaaraj.nawal.implementation_micro_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
