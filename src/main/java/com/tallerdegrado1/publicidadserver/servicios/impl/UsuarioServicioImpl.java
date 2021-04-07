package com.tallerdegrado1.publicidadserver.servicios.impl;

import com.tallerdegrado1.publicidadserver.config.ConstantePublicidad;
import com.tallerdegrado1.publicidadserver.excepciones.LoginExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.usuario.UsuarioExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.usuario.UsuarioNoEncontrado;
import com.tallerdegrado1.publicidadserver.excepciones.usuario.UsuarioRegistradoExcepcion;
import com.tallerdegrado1.publicidadserver.modelo.Usuario;
import com.tallerdegrado1.publicidadserver.repositorios.UsuarioRepositorio;
import com.tallerdegrado1.publicidadserver.servicios.UsuarioServicio;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.LoginRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.UsuarioRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.LoginResponse;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.UsuarioResponse;
import com.tallerdegrado1.publicidadserver.servicios.mappers.UsuarioMapper;
import com.tallerdegrado1.publicidadserver.utilidades.EncriptadorPass;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    private final UsuarioMapper usuarioMapper = new UsuarioMapper();

    @Override
    public UsuarioResponse registrarUsuario(UsuarioRequest usuarioRequest) throws UsuarioExcepcion {

        Optional<Usuario> usuario = usuarioRepositorio.getUsuarioByUsu(usuarioRequest.getUsu());
        if (usuario.isPresent()) {
            throw new UsuarioRegistradoExcepcion();
        }
        Usuario nuevoUsuario = usuarioMapper.toEntity(usuarioRequest);
        String passEncriptada = encriptar(usuarioRequest.getPass());
        nuevoUsuario.setPass(passEncriptada);
        //saveAndFlush crea o actuliza
       Usuario usuarioRegistrado= usuarioRepositorio.saveAndFlush(nuevoUsuario);
        return usuarioMapper.toDto(usuarioRegistrado);
    }

    //findAll() buca todo en la BD
    @Override
    public List<UsuarioResponse> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarioMapper.toDto(usuarios);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws UsuarioExcepcion, LoginExcepcion {
        Usuario usuario = usuarioRepositorio.getUsuarioByUsu(loginRequest.getUsu())
                .orElseThrow(() -> new UsuarioNoEncontrado("Usuario no Registrado"));
        verificarPass(loginRequest.getPass(), usuario.getPass());
        String token = getJWTToken(usuario.getUsu());
        return new LoginResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getTelefono(),
                usuario.getCorreo(),
                usuario.getFoto(),
                usuario.getUsu(),
                token
        );
    }

    private void verificarPass(String loginPass, String usuarioPass) throws LoginExcepcion {
        if(!EncriptadorPass.checkPassword(loginPass,usuarioPass)){
          throw new LoginExcepcion("Contrasenha incorrecta");
        }
    }
    private String getJWTToken(String username) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        //        return CLAVE_BEARER  + token;
        return Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        ConstantePublicidad.CLAVE_TOKEN).compact();
    }

    private String encriptar(String pass) {
        return EncriptadorPass.hashPassword(pass);
    }
}
