package com.hub.farturahub.service;


import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hub.farturahub.Repository.UsuarioRepository;
import com.hub.farturahub.model.UserLogin;
import com.hub.farturahub.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Usuario> CadastrarUsuario(Usuario usuario) {

		if (repository.findByEmail(usuario.getEmail()).isPresent()) {
			return null;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return Optional.of(repository.save(usuario));
	}
	
	 public Optional<UserLogin> Logar(Optional<UserLogin> user) {
	       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	       Optional<Usuario> usuario = repository.findByEmail(user.get().getEmail());

	        if(usuario.isPresent()) {
	            if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
	                String auth = user.get().getEmail() + ":" + user.get().getSenha();
	                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
	                String authHeader = "Basic " + new String(encodeAuth);

	                user.get().setToken(authHeader);
	                user.get().setCpfCnpj(usuario.get().getCpfCnpj());
	                user.get().setEmail(usuario.get().getEmail());
	                user.get().setNomeCompleto(usuario.get().getNomeCompleto());
	                user.get().setSenha(usuario.get().getSenha());

	                return user;
	            }
	        }
	        return null;
	    }
}
