package ma.enset.elaaraj.nawal.implementation_micro_service.repositories;

import ma.enset.elaaraj.nawal.implementation_micro_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
