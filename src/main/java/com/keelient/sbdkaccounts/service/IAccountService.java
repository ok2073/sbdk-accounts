package com.keelient.sbdkaccounts.service;

import com.keelient.sbdkaccounts.dto.CustomerDto;

public interface IAccountService  {
    /**
     *
     * @param customerDto - CustomerDto object
     */
    void createAccount(CustomerDto customerDto);
}
