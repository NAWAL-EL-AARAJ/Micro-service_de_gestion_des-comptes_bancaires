package ma.enset.elaaraj.nawal.implementation_micro_service;

import ma.enset.elaaraj.nawal.implementation_micro_service.entities.BankAccount;
import ma.enset.elaaraj.nawal.implementation_micro_service.enums.AccountType;
import ma.enset.elaaraj.nawal.implementation_micro_service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class ImplementationMicroSErviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImplementationMicroSErviceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                        .balance(10000 + Math.random() * 90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();
                bankAccountRepository.save(bankAccount);
            }
            bankAccountRepository.findAll().forEach(System.out::println);
        };
    }

}
