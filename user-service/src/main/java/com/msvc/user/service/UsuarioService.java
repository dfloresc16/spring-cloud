package com.msvc.user.service;

import com.msvc.user.entity.Usuario;
import com.msvc.user.model.reqres.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    Usuario saveUsuario(UsuarioDTO usuario);
    List<Usuario> getAllUsuarios();

    Usuario getUsuario(Long usuarioId);

}
