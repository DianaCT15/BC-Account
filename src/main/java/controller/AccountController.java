package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.AccountService;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

	 @Autowired
	 AccountService accountService;
	 
	 @PostMapping("/create")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Mono<Account> create(@RequestBody Account account){
	        return accountService.create(account);
	    }

	    @GetMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	    @ResponseStatus
	    public ResponseEntity<Mono<Account>> findById(@PathVariable("id") String id){
	        Mono<Account> accountMono = accountService.findById(id);
	        return new ResponseEntity<Mono<Account>>(accountMono,accountMono!=null? HttpStatus.OK : HttpStatus.NOT_FOUND);
	    }

	    @GetMapping("/getAll")
	    @ResponseStatus
	    public Flux<Account> findAll(){
	        return accountService.findAll();
	    }

	    @PutMapping("/update")
	    @ResponseStatus(HttpStatus.ACCEPTED)
	    public ResponseEntity<Mono<Account>> update(@RequestBody Account account){
	        Mono<Account> accountMono = accountService.update(account);
	        return new ResponseEntity<Mono<Account>>(accountMono, accountMono!=null? HttpStatus.OK : HttpStatus.NOT_FOUND);
	    }

	    @DeleteMapping("/delete/{id}")
	    @ResponseStatus(HttpStatus.ACCEPTED)
	    public Mono<Void> delete(@PathVariable("id") String id){
	        return accountService.delete(id);
	    }
}
