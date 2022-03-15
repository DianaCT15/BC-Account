package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
    AccountRepository accountRepository;

	@Override
	public Mono<Account> create(Account a) {
		return accountRepository.save(a);
	}

	@Override
	public Mono<Account> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public Flux<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Mono<Account> update(Account a) {
		return accountRepository.save(a);
	}

	@Override
	public Mono<Void> delete(String id) {
		return accountRepository.deleteById(id);
	}

}
