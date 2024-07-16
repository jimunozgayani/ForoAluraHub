package com.aluracursos.ForoAluraHub.controller;

import com.aluracursos.ForoAluraHub.domain.usuario_perfil.DatosListadoUsuario_Perfil;
import com.aluracursos.ForoAluraHub.domain.usuario_perfil.DatosRegistroUsuario_Perfil;
import com.aluracursos.ForoAluraHub.domain.usuario_perfil.Usuario_PerfilService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/usuarioperfil")
@SecurityRequirement(name = "bearer-key")
public class Usuario_Perfil_Controller {

    @Autowired
    private Usuario_PerfilService usuarioPerfilService;

    @PostMapping
    public ResponseEntity<DatosListadoUsuario_Perfil> agregarUsuariosPerfiles(@RequestBody @Valid DatosRegistroUsuario_Perfil datosRegistroUsuarioPerfil) {
        return ResponseEntity.ok(usuarioPerfilService.agregarPefil(datosRegistroUsuarioPerfil));
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoUsuario_Perfil>> mostrarPerfilesUsuarios() {
        return ResponseEntity.ok(usuarioPerfilService.mostrarUsuarioPerfil());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity borrarUsuarioPerfil(@PathVariable Long id) {
        usuarioPerfilService.borrarUsuarioPerfil(id);
        return ResponseEntity.noContent().build();
    }

}