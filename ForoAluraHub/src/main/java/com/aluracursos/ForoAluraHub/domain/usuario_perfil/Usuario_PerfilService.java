package com.aluracursos.ForoAluraHub.domain.usuario_perfil;
import com.aluracursos.ForoAluraHub.domain.perfiles.Perfil;
import com.aluracursos.ForoAluraHub.infra.errores.ErrorDeConsulta;
import com.aluracursos.ForoAluraHub.domain.perfiles.PerfilRepository;
import com.aluracursos.ForoAluraHub.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aluracursos.ForoAluraHub.domain.usuarios.Usuario;
import java.util.List;

@Service
public class Usuario_PerfilService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRespository;

    @Autowired
    private Usuario_PerfilRepository usuarioPerfilRepository;

    public DatosListadoUsuario_Perfil agregarPefil(DatosRegistroUsuario_Perfil datosRegistroUsuarioPerfil) {

        Usuario usuario;
        Perfil perfil;

        if (usuarioRepository.findById(datosRegistroUsuarioPerfil.usuario_id()).isEmpty()) {
            throw new ErrorDeConsulta("No se halló el usuario");
        }
        if (perfilRespository.findById(datosRegistroUsuarioPerfil.perfil_id()).isEmpty()) {
            throw new ErrorDeConsulta("No se halló el perfil");
        }

        usuario = usuarioRepository.getReferenceById(datosRegistroUsuarioPerfil.usuario_id());
        perfil = perfilRespository.getReferenceById(datosRegistroUsuarioPerfil.perfil_id());

        Usuario_Perfil usuarioPerfil = new Usuario_Perfil(null, usuario, perfil);

        Usuario_Perfil usuarioPerfil1 = usuarioPerfilRepository.save(usuarioPerfil);

        return new DatosListadoUsuario_Perfil(usuarioPerfil1);
    }

    public List<DatosListadoUsuario_Perfil> mostrarUsuarioPerfil() {
        return usuarioPerfilRepository.findAll().stream().map(DatosListadoUsuario_Perfil::new).toList();
    }

    public void borrarUsuarioPerfil(Long id) {
        usuarioPerfilRepository.deleteById(id);
    }
}
