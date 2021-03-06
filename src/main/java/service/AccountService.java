package service;

import model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
    Mono<Account> create(Account a);
    Mono<Account> findById(String id);
    Flux<Account> findAll();
    Mono<Account> update(Account a);
    Mono<Void> delete(String id);
}
