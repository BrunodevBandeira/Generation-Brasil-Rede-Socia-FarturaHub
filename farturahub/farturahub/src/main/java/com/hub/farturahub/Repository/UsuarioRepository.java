package com.hub.farturahub.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hub.farturahub.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findAllBycpfCnpjContainingIgnoreCase(String cpfCnpj);

	public Optional<Usuario> findAllBycpfCnpj(String cpfCnpj);
	
	public Optional<Usuario> findByEmail(String cpfCnpj);

}
