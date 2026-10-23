package ma.enset.elaaraj.nawal.implementation_micro_service.web;

import ma.enset.elaaraj.nawal.implementation_micro_service.dto.BankAccountRequestDTO;
import ma.enset.elaaraj.nawal.implementation_micro_service.dto.BankAccountResponseDTO;
import ma.enset.elaaraj.nawal.implementation_micro_service.entities.BankAccount;
import ma.enset.elaaraj.nawal.implementation_micro_service.repositories.BankAccountRepository;
import ma.enset.elaaraj.nawal.implementation_micro_service.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    private final BankAccountRepository bankAccountRepository;
    private final AccountService accountService;

    public BankAccountGraphQLController(BankAccountRepository bankAccountRepository, AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
    }

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id, bankAccount);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
        bankAccountRepository.deleteById(id);
        return true;
    }
}
