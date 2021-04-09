package com.hub.farturahub.Seguranca;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.hub.farturahub.Repository.UsuarioRepository;
import com.hub.farturahub.model.Usuario;

@Service

public abstract class UserDetailsServiceImpl implements UserDetailsService  {
    	
	
    @Autowired
    
    private UsuarioRepository userRepository;

    private List<GrantedAuthority> authorities;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public UserDetails loadUserBycpfCnpj (String cpfCnpj) throws AccountNotFoundException{
        Optional<Usuario> user = userRepository.findAllBycpfCnpj(cpfCnpj);
        user.orElseThrow(() -> new AccountNotFoundException(cpfCnpj + "Not found."));

        return user.map(UserDetailsImpl::new).get();
    }

}

