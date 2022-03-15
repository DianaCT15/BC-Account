package repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import model.Account;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
}
