package com.aluracursos.ForoAluraHub.controller;

import com.aluracursos.ForoAluraHub.domain.respuestas.DatosTopicoRespuestas;
import com.aluracursos.ForoAluraHub.domain.topicos.DatosActualizarTopicos;
import com.aluracursos.ForoAluraHub.domain.topicos.DatosListadoTopicos;
import com.aluracursos.ForoAluraHub.domain.topicos.DatosRegistroTopicos;
import com.aluracursos.ForoAluraHub.domain.topicos.TopicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DatosListadoTopicos> agregarTopico(@RequestBody @Valid DatosRegistroTopicos datosRegistroTopico) {
        DatosListadoTopicos datosListadoTopico = topicoService.agregarTopico(datosRegistroTopico);
        return ResponseEntity.ok(datosListadoTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> mostrarTopicos(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(topicoService.getTopicos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopicos> mostrarTopico(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.getTopico(id));
    }

    @PutMapping
    public ResponseEntity<DatosListadoTopicos> actualizarTopico(@RequestBody @Valid DatosActualizarTopicos datosActualizarTopico) {
        return ResponseEntity.ok(topicoService.actualizaTopico(datosActualizarTopico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity borraTopico(@PathVariable Long id) {
        topicoService.desactivaTopico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/respuestas")
    public ResponseEntity<Page<DatosTopicoRespuestas>>  respuestasTopico(@PathVariable Long id, @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(topicoService.getRespuestas(id, pageable));
    }
}