package com.msvc.user.controller;

import com.msvc.user.entity.Usuario;
import com.msvc.user.model.dtos.GenericResponseDTO;
import com.msvc.user.model.reqres.UsuarioDTO;
import com.msvc.user.service.UsuarioServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/user")
@Slf4j
public class UsuarioController extends CommonController{

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @RequestMapping(path = "/createUser", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<GenericResponseDTO<Usuario>> createUser(@RequestBody UsuarioDTO usuario){
        try {
            log.info("UsuarioDTO: " + usuario.toString());
            return ResponseEntity.ok(new GenericResponseDTO(SUCCESS,HTTP_SUCCESS,null,null,
                    "Servicio ejecutado exitosamente", usuarioService.saveUsuario(usuario)));
        }catch (Exception e){
            log.warn(e.getMessage(), e);
            return new ResponseEntity<>(new GenericResponseDTO<>(ERROR, HTTP_APP_FAILURE, null,
                    e.getMessage(), null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
