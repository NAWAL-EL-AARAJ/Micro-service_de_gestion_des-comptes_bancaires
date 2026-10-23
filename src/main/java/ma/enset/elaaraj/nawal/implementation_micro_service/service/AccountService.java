package ma.enset.elaaraj.nawal.implementation_micro_service.service;

import ma.enset.elaaraj.nawal.implementation_micro_service.dto.BankAccountRequestDTO;
import ma.enset.elaaraj.nawal.implementation_micro_service.dto.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
