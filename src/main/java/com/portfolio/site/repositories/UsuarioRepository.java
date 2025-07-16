package com.portfolio.site.repositories;

import com.portfolio.site.entities.Usuario;
import com.portfolio.site.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tb_usuario.email AS nome, tb_usuario.senha, tb_role.id AS roleId, tb_role.authority
            FROM tb_usuario
            INNER JOIN tb_usuario_role ON tb_usuario.id = tb_usuario_role.usuario_id
            INNER JOIN tb_role ON tb_role.id = tb_usuario_role.role_id
            WHERE tb_usuario.email = :email
			""")

    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

    Optional<Usuario> findByEmail(String email);
}
