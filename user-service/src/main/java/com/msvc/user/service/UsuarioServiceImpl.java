package com.msvc.user.service;

import com.msvc.user.entity.Usuario;
import com.msvc.user.model.reqres.UsuarioDTO;
import com.msvc.user.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Usuario saveUsuario(UsuarioDTO usuario) {
        Usuario usuario1 = new Usuario();
        usuario1.setName(usuario.getName());
        usuario1.setEmail(usuario.getEmail());
        usuario1.setAdditional_information(usuario.getAdditional_information());
        return usuarioRepository.save(usuario1);
    }
    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    @Override
    public Usuario getUsuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with userId[%d] not found",usuarioId)));
    }


}
