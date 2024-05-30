package com.keelient.sbdkaccounts.service.impl;

import com.keelient.sbdkaccounts.constants.AccountsConstants;
import com.keelient.sbdkaccounts.dto.CustomerDto;
import com.keelient.sbdkaccounts.entity.Accounts;
import com.keelient.sbdkaccounts.entity.Customer;
import com.keelient.sbdkaccounts.exception.CustomerAlreadyExistsException;
import com.keelient.sbdkaccounts.mapper.CustomerMapper;
import com.keelient.sbdkaccounts.repository.AccountsRepository;
import com.keelient.sbdkaccounts.repository.CustomerRepository;
import com.keelient.sbdkaccounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with a given mobileNumber " +
                    customerDto.getMobileNumber());
        }

        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(customer));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }


}
