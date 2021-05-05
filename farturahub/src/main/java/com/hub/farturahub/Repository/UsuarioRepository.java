package com.hub.farturahub.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hub.farturahub.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//public Optional<Usuario> findAllByEmailContainingIgnoreCase(String email);

	//public Optional<Usuario> findAllByEmail(String email);
	
	public Optional<Usuario> findByEmail(String email);

}
