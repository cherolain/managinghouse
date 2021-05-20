package com.reward.security;

import com.reward.entity.Utente;
import com.reward.repo.UtentiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UtentiRepo utente;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       Optional <Utente> u= utente.findByNome(s);
        if(u==null) {
            throw new UsernameNotFoundException("utente non trovato");
        }
        return new MyUserDetail(u.get());
    }

}
