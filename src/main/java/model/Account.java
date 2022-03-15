package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("account")
public class Account {
	
	@Id
    private String id;
    private String idCustomer;
    private Float balance;
    private Float maintenace;
    private Integer numberTransaction;
    private Integer maxTransaction;
    private AccountType accountType;

}
