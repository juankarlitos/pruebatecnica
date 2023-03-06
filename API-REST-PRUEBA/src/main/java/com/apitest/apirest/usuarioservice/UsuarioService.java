package com.apitest.apirest.usuarioservice;

import java.util.List;

import com.apitest.apirestpueba.entity.Usuario;

public interface UsuarioService {
	
	 Usuario createUsuario(Usuario usuario);
	    Usuario updateUsuario(Long id, Usuario usuario);
	    void deleteUsuario(Long id);
	    Usuario getUsuarioById(Long id);
	    List<Usuario> getAllUsuario();

}
