package com.keelient.sbdkaccounts.service;

import com.keelient.sbdkaccounts.dto.CustomerDto;

public interface IAccountService  {
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);
}
