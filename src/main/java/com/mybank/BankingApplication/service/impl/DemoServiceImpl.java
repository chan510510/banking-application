package com.mybank.BankingApplication.service.impl;

import com.mybank.BankingApplication.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public int calculator() {
        int a = 5;
        int b = 7;
        int c = a * b;
        return c;
    }
}
