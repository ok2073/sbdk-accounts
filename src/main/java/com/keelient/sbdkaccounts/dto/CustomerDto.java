package com.keelient.sbdkaccounts.dto;

import com.keelient.sbdkaccounts.entity.Accounts;
import lombok.Data;

@Data
public class CustomerDto {
    private String name;
    private String email;
    private String mobileNumber;
    private Accounts accounts;
}
