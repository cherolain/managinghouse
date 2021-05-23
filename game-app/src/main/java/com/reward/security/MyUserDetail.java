package com.reward.security;

import com.reward.entity.Ruolo;
import com.reward.entity.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;

public class MyUserDetail implements UserDetails {


    private Utente utente;

    public MyUserDetail(Utente utente) {
        this.utente = utente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String [] roles=utente.getRuoli().stream().map(role ->role.getNome()).toArray(String[]::new);
        return  AuthorityUtils.createAuthorityList(roles);

    }

    @Override
    public String getPassword() {
        return utente.getPassword();
    }

    @Override
    public String getUsername() {
        return utente.getNome();
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
