package com.mybank.BankingApplication.model;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;

import java.util.Collection;
import java.util.List;


public class UserPrincipal implements UserDetails {

    private UserSignUp userSignUp;

    public UserPrincipal(UserSignUp userSignUp){
        this.userSignUp=userSignUp;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ADMIN"));

    }

    @Override
    public String getPassword() {
        return userSignUp.getPassword();
    }

    @Override
    public String getUsername() {
        return userSignUp.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


