package com.mybank.BankingApplication.service;


import com.mybank.BankingApplication.model.UserPrincipal;
import com.mybank.BankingApplication.model.UserSignUp;
import com.mybank.BankingApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userSignUpRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSignUp userSignUp = userSignUpRepository.findByUsername(username);
        if(userSignUp == null){
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(userSignUp);
    }
}

