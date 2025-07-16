package com.portfolio.site.services;

import com.portfolio.site.entities.Role;
import com.portfolio.site.entities.Usuario;
import com.portfolio.site.projections.UserDetailsProjection;
import com.portfolio.site.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = repositorio.searchUserAndRolesByEmail(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("Email não encontrado");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(result.get(0).getUsuario());
        usuario.setSenha(result.get(0).getSenha());
        for (UserDetailsProjection projection : result) {
            usuario.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return usuario;
    }
}
