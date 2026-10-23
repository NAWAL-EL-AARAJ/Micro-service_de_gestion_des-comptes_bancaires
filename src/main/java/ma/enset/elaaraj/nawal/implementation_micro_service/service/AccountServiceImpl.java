package ma.enset.elaaraj.nawal.implementation_micro_service.service;

import ma.enset.elaaraj.nawal.implementation_micro_service.dto.BankAccountRequestDTO;
import ma.enset.elaaraj.nawal.implementation_micro_service.dto.BankAccountResponseDTO;
import ma.enset.elaaraj.nawal.implementation_micro_service.entities.BankAccount;
import ma.enset.elaaraj.nawal.implementation_micro_service.mappers.AccountMapper;
import ma.enset.elaaraj.nawal.implementation_micro_service.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private final BankAccountRepository bankAccountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(savedBankAccount);
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
        if (bankAccountDTO.getBalance() != null) bankAccount.setBalance(bankAccountDTO.getBalance());
        if (bankAccountDTO.getType() != null) bankAccount.setType(bankAccountDTO.getType());
        if (bankAccountDTO.getCurrency() != null) bankAccount.setCurrency(bankAccountDTO.getCurrency());
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(savedBankAccount);
    }
}
