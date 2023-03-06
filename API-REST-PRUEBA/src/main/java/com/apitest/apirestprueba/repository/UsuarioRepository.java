package com.apitest.apirestprueba.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apitest.apirestpueba.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

	List<Usuario> findAll();

	
	Optional<Usuario> findByCorreo(String correo);
	
	
	

}
