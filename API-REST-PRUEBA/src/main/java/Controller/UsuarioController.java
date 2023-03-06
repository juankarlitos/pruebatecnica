package Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apitest.apirestprueba.repository.UsuarioRepository;
import com.apitest.apirestpueba.entity.Usuario;

public class UsuarioController {

	@Autowired
    private UsuarioRepository usuariRepository;
    
    @GetMapping
    public List<Usuario> getUsers() {
        return usuariRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Optional<Usuario> userOptional = Optional.empty();
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        Usuario savedUser = usuariRepository.save(usuario);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedUser);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> userOptional = Optional.empty();
        if (userOptional.isPresent()) {
            Usuario updatedUser = userOptional.get();
            updatedUser.setNombre(usuario.getNombre());
            updatedUser.setCorreo(usuario.getCorreo());
            updatedUser.setContraseña(usuario.getContraseña());
            usuariRepository.save(updatedUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usuariRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
	
	
	
	
}
